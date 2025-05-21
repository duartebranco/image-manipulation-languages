import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
@SuppressWarnings("CheckReturnValue")
public class CodeGenVisitor extends imlBaseVisitor<String> {

   private StringBuilder sb = new StringBuilder();
    
   public String getCode() {
      return sb.toString();
   }

   private int tempVarCounter = 0;
   
   private String getTempVar() {
      return "_temp" + (tempVarCounter++);
   }

   private Set<String> convertedKernels = new HashSet<>();

   private String ensureKernelIsNumpy(String kernelVar) {
      if (!convertedKernels.contains(kernelVar)) {
         convertedKernels.add(kernelVar);
         return kernelVar + " = np.array(" + kernelVar + ", dtype=np.uint8)\n";
      }
      return null;
   }

   @Override public String visitProgram(imlParser.ProgramContext ctx) {
      // emit Python header
      sb.append("#!/usr/bin/env python3\n")
         .append("from PIL import Image\n")
         .append("import numpy as np\n")
         .append("import cv2\n\n");
      // visit each statement
      for (imlParser.StatementContext st : ctx.statement()) {
         visit(st);
      }
      return sb.toString();  // return all code
   }

   @Override public String visitStatement(imlParser.StatementContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitVariableDeclaration(imlParser.VariableDeclarationContext ctx) {
      // emit:   <name> = <expr>
      String varName = ctx.ID().getText();
      String exprResult = visit(ctx.expression());
      // If exprResult is a temp variable (starts with _temp), assign it to varName
      if (exprResult.startsWith("_temp")) {
         sb.append(varName).append(" = ").append(exprResult).append("\n");
      } else {
         sb.append(varName).append(" = ").append(exprResult).append("\n");
      }
      return null;
   }

   @Override public String visitAssignment(imlParser.AssignmentContext ctx) {
      String rhs = visit(ctx.expression());
      if (rhs.contains("\0")) {
         String[] parts = rhs.split("\0");
         for (String line : parts[0].split("\n")) {
               if (!line.isEmpty()) sb.append(line).append("\n");
         }
         sb.append(ctx.ID().getText())
            .append(" = ")
            .append(parts[1])
            .append("\n");
      } else {
         sb.append(ctx.ID().getText())
            .append(" = ")
            .append(rhs)
            .append("\n");
      }
      System.err.println("DEBUG: [assignment] " + ctx.ID().getText() + " = " + rhs);
      return null;
   }

   @Override public String visitIfStatement(imlParser.IfStatementContext ctx) {
     String cond = visit(ctx.expression());
      sb.append("if ").append(cond).append(":\n");

      // Process statements in the 'then' block
      for (imlParser.StatementContext st : ctx.thenStmts) { // Use the 'thenStmts' label
         sb.append("    "); // Add indentation
         visit(st);
      }

      // Check if there is an 'else' block
      if (ctx.elseStmts != null && !ctx.elseStmts.isEmpty()) { // Use the 'elseStmts' label
         sb.append("else:\n");
         // Process statements in the 'else' block
         for (imlParser.StatementContext st : ctx.elseStmts) {
            sb.append("    "); // Add indentation
            visit(st);
         }
      }
      return null;
   }

   @Override 
   public String visitForStatement(imlParser.ForStatementContext ctx) {
      String type = ctx.type().getText().trim(); // e.g., "percentage"
      String var = ctx.ID().getText();           // e.g., "p"
      String iterable = visit(ctx.expression()); // e.g., "l"

      sb.append("for ").append(var).append(" in ").append(iterable).append(":\n");
      for (imlParser.StatementContext st : ctx.statement()) {
         sb.append("    ");
         visit(st);
      }
      return null;
   }

   @Override public String visitUntilStatement(imlParser.UntilStatementContext ctx) {
      String condition = visit(ctx.expression());
      sb.append("while (").append(condition).append("):\n");
      for (imlParser.StatementContext stmt : ctx.statement()) {
         visitIndented(stmt, "    ");
      }
      return null;
   }

   private void visitIndented(imlParser.StatementContext ctx, String indent) {
      int before = sb.length();
      visitWithIndent(ctx, indent);
      int after = sb.length();
      // Indent all lines generated for this statement
      String[] lines = sb.substring(before, after).split("\n", -1);
      sb.delete(before, after);
      for (String line : lines) {
         if (!line.isEmpty()) {
               sb.append(indent).append(line).append("\n");
         }
      }
   }

   // Overload for assignment and other statements
   private void visitWithIndent(imlParser.StatementContext ctx, String indent) {
      visit(ctx);
   }

   @Override public String visitOutputStatement(imlParser.OutputStatementContext ctx) {
      sb.append("print(")
         .append(visit(ctx.expression()))
         .append(")\n");
      return null;
   }

   @Override public String visitDrawStatement(imlParser.DrawStatementContext ctx) {
      String expr = visit(ctx.expression());
      sb.append("Image.fromarray(np.clip((")
      .append(expr)
      .append(") * 255, 0, 255).astype(np.uint8)).show()\n");
      return null;
   }

   @Override 
   public String visitStoreStatement(imlParser.StoreStatementContext ctx) {
      String exprToStore = visit(ctx.expression());
      String rawPath = ctx.STRING().getText(); // e.g., "\"animation.gif\""
      String relPath = rawPath.substring(1, rawPath.length() - 1); // e.g., "animation.gif"

      // pythonStringLiteralForSave is a Java string that represents a Python string literal.
      // e.g., "\"examples/animation.gif\"". This is correct for save() methods.
      String pythonStringLiteralForSave = "\"examples/" + relPath + "\"";

      // pathContentForFString is the raw path, e.g., "examples/animation.gif".
      // This will be wrapped in single quotes within the f-string.
      String pathContentForFString = "examples/" + relPath;

      sb.append("if isinstance(").append(exprToStore).append(", list):\n");
      sb.append("    _pil_images_for_gif = [Image.fromarray(np.clip(_frame, 0, 255).astype(np.uint8)) for _frame in ").append(exprToStore).append("]\n");
      sb.append("    if _pil_images_for_gif:\n");
      sb.append("        _pil_images_for_gif[0].save(").append(pythonStringLiteralForSave)
        .append(", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)\n");
      sb.append("    else:\n");
      // Corrected f-string: use single quotes for the path literal inside the f-string expression
      sb.append("        print(f\"Warning: Image list '").append(exprToStore.replace("\"", "\\\""))
        .append("' is empty. Cannot save GIF to {'").append(pathContentForFString).append("'}\")\n");
      sb.append("elif isinstance(").append(exprToStore).append(", np.ndarray):\n");
      sb.append("    Image.fromarray(np.clip((").append(exprToStore)
        .append(") * 255, 0, 255).astype(np.uint8)).save(").append(pythonStringLiteralForSave).append(")\n");
      sb.append("else:\n");
      sb.append("    print(f\"Error: Cannot store type {type(").append(exprToStore).append(")} as image/GIF for expression '").append(exprToStore.replace("\"", "\\\"")).append("'.\")\n");
      return null;
   }


   @Override public String visitAppendStatement(imlParser.AppendStatementContext ctx) {
      int before = sb.length();
      String listName = ctx.ID().getText();
      String itemToAppend = visit(ctx.expression());
      sb.append(listName).append(".append(").append(itemToAppend).append(")\n");
      int after = sb.length();
      System.err.println("DEBUG: [append] " + sb.substring(before, after));
      return null;
   }

   @Override public String visitLoadExpr(imlParser.LoadExprContext ctx) {
      String pathExpr = visit(ctx.expression());
      return "np.array(Image.open(\"examples/\" + (" + pathExpr + ")).convert('L')) / 255.0";
   }

   @Override public String visitStringConversionExpr(imlParser.StringConversionExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitReadExpr(imlParser.ReadExprContext ctx) {
      // read "prompt"
      return "input(" + ctx.STRING().getText() + ")";
   }

   @Override
   public String visitComparisonExpr(imlParser.ComparisonExprContext ctx) {
      String left = visit(ctx.left);
      String right = visit(ctx.right);
      String op = ctx.operator.getText();
      return left + " " + op + " " + right;
   }   

   @Override public String visitCountPixelExpr(imlParser.CountPixelExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitAnyPixelExpr(imlParser.AnyPixelExprContext ctx) {
      String image = visit(ctx.expression());
      String op = ctx.operator.getText();
      String number = ctx.NUMBER().getText();

      // Convert operator if needed
      if (op.equals(".>")) op = ">";

      return "np.any(" + image + " " + op + " " + number + ")";
   }

   @Override public String visitRowsExpr(imlParser.RowsExprContext ctx) {
      // “rows of X” → número de linhas em X
      return visit(ctx.expression()) + ".shape[0]";
   }

   @Override public String visitParenExpr(imlParser.ParenExprContext ctx) {
      return "(" + visit(ctx.expression()) + ")";
   }

   @Override public String visitColumnsExpr(imlParser.ColumnsExprContext ctx) {
      // “columns of X” → número de colunas em X
      return visit(ctx.expression()) + ".shape[1]";
   }

   @Override public String visitPrimaryExpr(imlParser.PrimaryExprContext ctx) {
      return visit(ctx.primary());
   }

   @Override public String visitErodeExpr(imlParser.ErodeExprContext ctx) {
      String image = visit(ctx.expression(0));
      String kernel = visit(ctx.expression(1));
      String kernelConv = ensureKernelIsNumpy(kernel);
      if (kernelConv != null) {
         return kernelConv + "\0" + "cv2.erode(" + image + ", " + kernel + ", iterations=1)";
      }
      return "cv2.erode(" + image + ", " + kernel + ", iterations=1)";
   }

   @Override public String visitOpenExpr(imlParser.OpenExprContext ctx) {
      String input = visit(ctx.expression(0));
      String kernel = visit(ctx.expression(1));
      ensureKernelIsNumpy(kernel);
      String tempVar = getTempVar();
      sb.append(tempVar).append(" = cv2.morphologyEx(").append(input)
         .append(", cv2.MORPH_OPEN, ").append(kernel).append(")\n");
      return tempVar;
   }

   @Override public String visitCloseExpr(imlParser.CloseExprContext ctx) {
      String input = visit(ctx.expression(0));
      String kernel = visit(ctx.expression(1));
      ensureKernelIsNumpy(kernel);
      String tempVar = getTempVar();
      sb.append(tempVar).append(" = cv2.morphologyEx(").append(input)
         .append(", cv2.MORPH_CLOSE, ").append(kernel).append(")\n");
      return tempVar;
   }

   @Override public String visitTopHatExpr(imlParser.TopHatExprContext ctx) {
      String img = visit(ctx.expression(0));
      String kernel = visit(ctx.expression(1));
      ensureKernelIsNumpy(kernel);
      String resultVar = getTempVar();
      sb.append(resultVar + " = cv2.morphologyEx((" + img + " * 255).astype(np.uint8), cv2.MORPH_TOPHAT, " + kernel + ").astype(np.float32) / 255.0\n");
      return resultVar;
   }

   // 2ª gramática
   @Override public String visitRunExpr(imlParser.RunExprContext ctx) {
      String pathExpr = visit(ctx.expression());
      return "run_iiml_program(" + pathExpr + ")";
   }

   @Override public String visitBlackHatExpr(imlParser.BlackHatExprContext ctx) {
      String img = visit(ctx.expression(0));
      String kernel = visit(ctx.expression(1));
      ensureKernelIsNumpy(kernel);
      String resultVar = getTempVar();
      sb.append(resultVar + " = cv2.morphologyEx((" + img + " * 255).astype(np.uint8), cv2.MORPH_BLACKHAT, " + kernel + ").astype(np.float32) / 255.0\n");
      return resultVar;
   }

   @Override public String visitDilateExpr(imlParser.DilateExprContext ctx) {
      String image = visit(ctx.expression(0));
      String kernel = visit(ctx.expression(1));
      String kernelConv = ensureKernelIsNumpy(kernel);
      if (kernelConv != null) {
         return kernelConv + "\0" + "cv2.dilate(" + image + ", " + kernel + ", iterations=1)";
      }
      return "cv2.dilate(" + image + ", " + kernel + ", iterations=1)";
   }

   @Override public String visitPrimary(imlParser.PrimaryContext ctx) {
      if (ctx.ID()        != null) return ctx.ID().getText();
      if (ctx.NUMBER()    != null) return ctx.NUMBER().getText();
      if (ctx.PERCENTAGE()!= null) {
         String t = ctx.PERCENTAGE().getText(); 
         return "(" + t.substring(0, t.length()-1) + "/100)";
      }
      if (ctx.STRING()    != null) return ctx.STRING().getText();
      if (ctx.list()      != null) return visit(ctx.list());
      return null;
   }

   @Override public String visitList(imlParser.ListContext ctx) {
      if (ctx.expression() == null || ctx.expression().isEmpty()) {
         return "[]";
      }
      var elems = ctx.expression().stream()
                     .map(this::visit)
                     .collect(Collectors.joining(", "));
      return "[" + elems + "]";
   }

   @Override public String visitType(imlParser.TypeContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override
   public String visitPixelOperationExpr(imlParser.PixelOperationExprContext ctx) {
      String left = visit(ctx.left);
      String right = visit(ctx.right);
      String op = ctx.operator.getText();
      switch (op) {
         case ".*": return left + " * " + right;
         case ".+": return left + " + " + right;
         case ".-": return left + " - " + right;
         default: return left + " " + op + " " + right;
      }
   }

   @Override
   public String visitScaleExpr(imlParser.ScaleExprContext ctx) {
      String left = visit(ctx.left);
      String right = visit(ctx.right);
      String op = ctx.operator.getText();
      // Use PIL.Image.resize for scaling
      String axis;
      switch (op) {
         case "|*": axis = "vertical"; break;
         case "-*": axis = "horizontal"; break;
         case "+*": axis = "both"; break;
         default: axis = "both";
      }
      // For simplicity, assume right is a float or int
      if (axis.equals("vertical")) {
         return "np.array(Image.fromarray(" + left + ").resize((" + left + ".shape[1], int(" + left + ".shape[0] * " + right + "))))";
      } else if (axis.equals("horizontal")) {
         return "np.array(Image.fromarray(" + left + ").resize((int(" + left + ".shape[1] * " + right + "), " + left + ".shape[0])))";
      } else {
         return "np.array(Image.fromarray(" + left + ").resize((int(" + left + ".shape[1] * " + right + "), int(" + left + ".shape[0] * " + right + "))))";
      }
   }
}
