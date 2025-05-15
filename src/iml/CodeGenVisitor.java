import java.util.stream.Collectors;
@SuppressWarnings("CheckReturnValue")
public class CodeGenVisitor extends imlBaseVisitor<String> {

   private StringBuilder sb = new StringBuilder();
    
   public String getCode() {
      return sb.toString();
   }

   @Override public String visitProgram(imlParser.ProgramContext ctx) {
      // emit Python header
      sb.append("#!/usr/bin/env python3\n")
         .append("from PIL import Image\n")
         .append("import numpy as np\n\n");
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
      sb.append(ctx.ID().getText())
         .append(" = ")
         .append(visit(ctx.expression()))
         .append("\n");
      return null;
   }

   @Override public String visitAssignment(imlParser.AssignmentContext ctx) {
      // emit:   <name> = <expr>
      sb.append(ctx.ID().getText())
         .append(" = ")
         .append(visit(ctx.expression()))
         .append("\n");
      return null;
   }

   @Override public String visitIfStatement(imlParser.IfStatementContext ctx) {
      // if cond then stmts done
      String cond = visit(ctx.expression());
      sb.append("if ").append(cond).append(":\n");
      for (var st : ctx.statement()) {
         sb.append("    ");
         visit(st);
      }
      return null;
   }

   @Override public String visitForStatement(imlParser.ForStatementContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitUntilStatement(imlParser.UntilStatementContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitOutputStatement(imlParser.OutputStatementContext ctx) {
      sb.append("print(")
         .append(visit(ctx.expression()))
         .append(")\n");
      return null;
   }

   @Override public String visitDrawStatement(imlParser.DrawStatementContext ctx) {
      sb.append("Image.fromarray(")
         .append(visit(ctx.expression()))
         .append(").show()\n");
      return null;
   }

   @Override 
   public String visitStoreStatement(imlParser.StoreStatementContext ctx) {
      // <expr> store into "images/yyy.pgm" → save "examples/images/yyy.pgm"
      String img = visit(ctx.expression());
      String raw = ctx.STRING().getText();                  // e.g. "\"images/copy.pgm\""
      String lit = raw.substring(1, raw.length()-1);        // images/copy.pgm
      String quoted = "\"examples/" + lit + "\"";
      sb.append("Image.fromarray(np.clip(")
         .append(img)
         .append(", 0, 255).astype(np.uint8)).save(")
         .append(quoted)
         .append(")\n");
      return null;
   }

   @Override public String visitAppendStatement(imlParser.AppendStatementContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitLoadExpr(imlParser.LoadExprContext ctx) {
      // load from "path"
      String raw = ctx.expression().getText();              // p.ex. "\"images/sample00.pgm\""
      String lit = raw.substring(1, raw.length()-1);       // images/sample00.pgm
      String quoted = "\"examples/" + lit + "\"";          
      return "np.array(Image.open(" + quoted + ").convert('L'))";
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
      String res = null;
      return visitChildren(ctx);
      //return res;
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
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitOpenExpr(imlParser.OpenExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitCloseExpr(imlParser.CloseExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitTopHatExpr(imlParser.TopHatExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitRunExpr(imlParser.RunExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitBlackHatExpr(imlParser.BlackHatExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitDilateExpr(imlParser.DilateExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
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
