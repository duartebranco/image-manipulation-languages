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
      return kernelVar + " = np.array(" + kernelVar + ", dtype=np.uint8)\n";
   }

   @Override 
   public String visitProgram(imlParser.ProgramContext ctx) {
      // emit Python header
      sb.append("#!/usr/bin/env python3\n")
         .append("from PIL import Image\n")
         .append("import numpy as np\n")
         .append("import cv2\n")
         .append("import sys\n")
         .append("import os\n")
         .append("sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))\n")
         .append("sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../src/iiml')))\n")
         .append("from src.iiml.run_iiml import run_iiml_program\n\n");
      // Primeiro, visita todas as funções
      for (imlParser.FunctionDeclContext f : ctx.functionDecl()) {
         visit(f);
      }
      // Depois, visita todos os statements
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

   @Override 
   public String visitVariableDeclaration(imlParser.VariableDeclarationContext ctx) {
      String varName = ctx.ID().getText();
      if (ctx.expression() != null) {
         String exprResult = visit(ctx.expression());
         sb.append(varName).append(" = ").append(exprResult).append("\n");
      }
      // Se não houver expressão, só declara o nome (opcional em Python, normalmente ignora)
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
      return null;
   }

   @Override public String visitIfStatement(imlParser.IfStatementContext ctx) {
      String cond = visit(ctx.expression());
      sb.append("if ").append(cond).append(":\n");
      for (imlParser.StatementContext st : ctx.thenStmts) {
         visitIndented(st, "    ");
      }
      if (ctx.elseStmts != null && !ctx.elseStmts.isEmpty()) {
         sb.append("else:\n");
         for (imlParser.StatementContext st : ctx.elseStmts) {
               visitIndented(st, "    ");
         }
      }
      return null;
   }

   @Override 
   public String visitForStatement(imlParser.ForStatementContext ctx) {
      String type = ctx.type().getText().trim();
      String var = ctx.ID().getText();
      String iterable = visit(ctx.expression());

      sb.append("for ").append(var).append(" in ").append(iterable).append(":\n");
      for (imlParser.StatementContext st : ctx.statement()) {
         visitIndented(st, "    ");
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
      sb.append("img_draw = ").append(expr).append("\n");
      sb.append("if img_draw.ndim == 2:\n");
      sb.append("    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8)).show()\n");
      sb.append("else:\n");
      sb.append("    Image.fromarray(np.clip(img_draw * 255, 0, 255).astype(np.uint8), 'RGB').show()\n");
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

      sb.append("img_store = ").append(exprToStore).append("\n");
      sb.append("if isinstance(img_store, list):\n");
      sb.append("    _pil_images_for_gif = [Image.fromarray(np.clip(_frame * 255, 0, 255).astype(np.uint8)) for _frame in img_store]\n");
      sb.append("    if _pil_images_for_gif:\n");
      sb.append("        _pil_images_for_gif[0].save(").append(pythonStringLiteralForSave)
      .append(", save_all=True, append_images=_pil_images_for_gif[1:], duration=100, loop=0)\n");
      sb.append("    else:\n");
      sb.append("        print(f\"Warning: Image list '").append(exprToStore.replace("\"", "\\\""))
      .append("' is empty. Cannot save GIF to {'").append(pathContentForFString).append("'}\")\n");
      sb.append("elif isinstance(img_store, np.ndarray):\n");
      sb.append("    if img_store.ndim == 2:\n");
      sb.append("        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8)).save(").append(pythonStringLiteralForSave).append(")\n");
      sb.append("    else:\n");
      sb.append("        Image.fromarray(np.clip(img_store * 255, 0, 255).astype(np.uint8), 'RGB').save(").append(pythonStringLiteralForSave).append(")\n");
      sb.append("else:\n");
      sb.append("    print(f\"Error: Cannot store type {type(img_store)} as image/GIF for expression '").append(exprToStore.replace("\"", "\\\"")).append("'.\")\n");      
      return null;
   }


   @Override public String visitAppendStatement(imlParser.AppendStatementContext ctx) {
      int before = sb.length();
      String listName = ctx.ID().getText();
      String itemToAppend = visit(ctx.expression());
      sb.append(listName).append(".append(").append(itemToAppend).append(")\n");
      int after = sb.length();
      return null;
   }

   @Override public String visitLoadExpr(imlParser.LoadExprContext ctx) {
      String pathExpr = visit(ctx.expression());
      return "(lambda _p: np.array(Image.open('examples/' + _p).convert('L')) / 255.0 if _p.lower().endswith(('.pgm')) else np.array(Image.open('examples/' + _p).convert('RGB')) / 255.0)(" + pathExpr + ")";
   }

   @Override public String visitStringConversionExpr(imlParser.StringConversionExprContext ctx) {
      String expr = visit(ctx.expression());
      return "str(" + expr + ")";
   }

   @Override
   public String visitNumberConversionExpr(imlParser.NumberConversionExprContext ctx) {
      String expr = visit(ctx.expression());
      // Usa float() para aceitar números e strings numéricas
      return "float(" + expr + ")";
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

   @Override
   public String visitCountPixelExpr(imlParser.CountPixelExprContext ctx) {
      String value = visit(ctx.expression(0));
      String image = visit(ctx.expression(1));
      // Conta o número de pixeis iguais a value na imagem
      return "np.sum(" + image + " == " + value + ")";
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
      String tempVar = getTempVar();
      sb.append(kernelConv);
      sb.append("if ").append(image).append(".ndim == 3:\n");
      sb.append("    ").append(tempVar).append(" = np.stack([cv2.erode(").append(image).append("[...,c], ").append(kernel).append(", iterations=1) for c in range(").append(image).append(".shape[2])], axis=-1)\n");
      sb.append("else:\n");
      sb.append("    ").append(tempVar).append(" = cv2.erode(").append(image).append(", ").append(kernel).append(", iterations=1)\n");
      return tempVar;
   }

   @Override public String visitOpenExpr(imlParser.OpenExprContext ctx) {
      String input = visit(ctx.expression(0));
      String kernel = visit(ctx.expression(1));
      String kernelConv = ensureKernelIsNumpy(kernel);
      String tempVar = getTempVar();
      sb.append(kernelConv);
      sb.append(tempVar).append(" = cv2.morphologyEx(").append(input)
         .append(", cv2.MORPH_OPEN, ").append(kernel).append(")\n");
      return tempVar;
   }

   @Override public String visitCloseExpr(imlParser.CloseExprContext ctx) {
      String input = visit(ctx.expression(0));
      String kernel = visit(ctx.expression(1));
      String kernelConv = ensureKernelIsNumpy(kernel);
      String tempVar = getTempVar();
      sb.append(kernelConv);
      sb.append(tempVar).append(" = cv2.morphologyEx(").append(input)
         .append(", cv2.MORPH_CLOSE, ").append(kernel).append(")\n");
      return tempVar;
   }

   @Override public String visitTopHatExpr(imlParser.TopHatExprContext ctx) {
      String img = visit(ctx.expression(0));
      String kernel = visit(ctx.expression(1));
      String kernelConv = ensureKernelIsNumpy(kernel);
      String resultVar = getTempVar();
      sb.append(kernelConv);
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
      String kernelConv = ensureKernelIsNumpy(kernel);
      String resultVar = getTempVar();
      sb.append(kernelConv);
      sb.append(resultVar + " = cv2.morphologyEx((" + img + " * 255).astype(np.uint8), cv2.MORPH_BLACKHAT, " + kernel + ").astype(np.float32) / 255.0\n");
      return resultVar;
   }

   @Override public String visitDilateExpr(imlParser.DilateExprContext ctx) {
      String image = visit(ctx.expression(0));
      String kernel = visit(ctx.expression(1));
      String kernelConv = ensureKernelIsNumpy(kernel);
      String tempVar = getTempVar();
      sb.append(kernelConv);
      sb.append(tempVar).append(" = cv2.dilate(").append(image).append(", ").append(kernel).append(", iterations=1)\n");
      return tempVar;
   }

   @Override
   public String visitPrimary(imlParser.PrimaryContext ctx) {
      if (ctx.ID() != null) return ctx.ID().getText();
      if (ctx.NUMBER() != null) return ctx.NUMBER().getText();
      if (ctx.PERCENTAGE() != null) {
         String t = ctx.PERCENTAGE().getText();
         return "(" + t.substring(0, t.length()-1) + "/100)";
      }
      if (ctx.STRING() != null) return ctx.STRING().getText();
      if (ctx.BOOLEAN() != null) {
         String val = ctx.BOOLEAN().getText();
         if (val.equals("true")) return "True";
         if (val.equals("false")) return "False";
      }
      if (ctx.list() != null) return visit(ctx.list());
      if (ctx.primary() != null && ctx.expression() != null) {
         // indexação: l2d[1][1]
         return visit(ctx.primary()) + "[" + visit(ctx.expression()) + "]";
      }
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

      // Heurística: se ambos os lados são comparações, então é booleano
      boolean leftIsBool = left.contains(">") || left.contains("<") || left.contains("==") || left.contains("!=");
      boolean rightIsBool = right.contains(">") || right.contains("<") || right.contains("==") || right.contains("!=");

      if (op.equals(".|")) {
         if (leftIsBool && rightIsBool) {
               return "(" + left + ") | (" + right + ")";
         } else {
               return left + " / " + right;
         }
      }
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
      String axis;
      switch (op) {
         case "|*": axis = "vertical"; break;
         case "-*": axis = "horizontal"; break;
         case "+*": axis = "both"; break;
         default: axis = "both";
      }
      String width = "int(" + left + ".shape[1] * " + right + ")";
      String height = "int(" + left + ".shape[0] * " + right + ")";
      if (axis.equals("vertical")) {
         height = "int(" + left + ".shape[0] * " + right + ")";
         width = left + ".shape[1]";
      } else if (axis.equals("horizontal")) {
         width = "int(" + left + ".shape[1] * " + right + ")";
         height = left + ".shape[0]";
      }
      String tempVar = getTempVar();
      sb.append("if ").append(left).append(".ndim == 2:\n");
      sb.append("    ").append(tempVar).append(" = np.array(Image.fromarray(np.clip((")
      .append(left).append(") * 255, 0, 255).astype(np.uint8)).resize((")
      .append(width).append(", ").append(height).append("))) / 255.0\n");
      sb.append("else:\n");
      sb.append("    ").append(tempVar).append(" = np.array(Image.fromarray(np.clip((")
      .append(left).append(") * 255, 0, 255).astype(np.uint8), mode='RGB').resize((")
      .append(width).append(", ").append(height).append("))) / 255.0\n");
      return tempVar;
   }

   @Override
   public String visitFlipExpr(imlParser.FlipExprContext ctx) {
      String image = visit(ctx.expression());
      String op = ctx.operator.getText();
      String tempVar = getTempVar();
      switch (op) {
         case "-": // vertical flip
               sb.append(tempVar).append(" = np.flipud(").append(image).append(")\n");
               break;
         case "|": // horizontal flip
               sb.append(tempVar).append(" = np.fliplr(").append(image).append(")\n");
               break;
         case "+": // both
               sb.append(tempVar).append(" = np.flipud(np.fliplr(").append(image).append("))\n");
               break;
         default:
               throw new IllegalArgumentException("Unknown flip operator: " + op);
      }
      return tempVar;
   }

   @Override
   public String visitUnaryPixelOperationExpr(imlParser.UnaryPixelOperationExprContext ctx) {
      String operand = visit(ctx.expression());
      String op = ctx.operator.getText();
      if (op.equals(".-")) {
         return "1.0 - " + operand; // Inverso da imagem
      }
      return operand; // Caso não identificado
   }

   @Override
   public String visitArithmeticExpr(imlParser.ArithmeticExprContext ctx) {
      String left = visit(ctx.left);
      String right = visit(ctx.right);
      String op = ctx.operator.getText();
      if (op.equals("+")) {
         // Se algum dos lados é string, faz concatenação
         return left + " + " + right;
      }
      return left + " " + op + " " + right;
   }

   @Override
   public String visitPixelBoolOperationExpr(imlParser.PixelBoolOperationExprContext ctx) {
      String left = visit(ctx.left);
      String right = visit(ctx.right);
      String op = ctx.operator.getText();
      switch (op) {
         case ".>": return left + " > " + right;
         case ".<": return left + " < " + right;
         case ".==": return left + " == " + right;
         case ".!=": return left + " != " + right;
         case ".&": return left + " & " + right;
         case ".|": return left + " | " + right;
         case ".!": return "~" + left;
         default: throw new RuntimeException("Unknown pixel-wise boolean op: " + op);
      }
   }

   @Override
   public String visitUnaryPixelBoolOperationExpr(imlParser.UnaryPixelBoolOperationExprContext ctx) {
      String operand = visit(ctx.expression());
      return "~" + operand;
   }

   @Override
   public String visitAllPixelExpr(imlParser.AllPixelExprContext ctx) {
      String image = visit(ctx.expression());
      String op = ctx.operator.getText();
      String number = ctx.NUMBER().getText();

      // Converter operador se necessário
      if (op.equals(".>")) op = ">";

      return "np.all(" + image + " " + op + " " + number + ")";
   }

   @Override
   public String visitFunctionDecl(imlParser.FunctionDeclContext ctx) {
      String funcName = ctx.ID().getText();
      StringBuilder params = new StringBuilder();
      if (ctx.paramList() != null) {
         for (int i = 0; i < ctx.paramList().param().size(); i++) {
               if (i > 0) params.append(", ");
               params.append(ctx.paramList().param(i).ID().getText());
         }
      }
      sb.append("def ").append(funcName).append("(").append(params).append("):\n");
      // Corpo da função
      for (imlParser.StatementContext st : ctx.statement()) {
         sb.append("    ");
         visit(st);
      }
      if (ctx.expression() != null) {
         sb.append("    return ").append(visit(ctx.expression())).append("\n");
      }
      sb.append("\n");
      return null;
   }

   @Override
   public String visitFunctionCallExpr(imlParser.FunctionCallExprContext ctx) {
      String funcName = ctx.ID().getText();
      String args = "";
      if (ctx.expression() != null && !ctx.expression().isEmpty()) {
         args = ctx.expression().stream().map(this::visit).collect(Collectors.joining(", "));
      }
      return funcName + "(" + args + ")";
   }

   @Override
   public String visitTryCatchStatement(imlParser.TryCatchStatementContext ctx) {
      sb.append("try:\n");
      for (imlParser.StatementContext st : ctx.tryBlock) {
         sb.append("    ");
         visit(st);
      }
      sb.append("except Exception as e:\n");
      for (imlParser.StatementContext st : ctx.catchBlock) {
         sb.append("    ");
         visit(st);
      }
      return null;
   }

   @Override
   public String visitExitStatement(imlParser.ExitStatementContext ctx) {
      sb.append("exit()\n");
      return null;
   }
}
