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
      String res = null;
      return visitChildren(ctx);
      //return res;
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
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitDrawStatement(imlParser.DrawStatementContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitStoreStatement(imlParser.StoreStatementContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitAppendStatement(imlParser.AppendStatementContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitLoadExpr(imlParser.LoadExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitStringConversionExpr(imlParser.StringConversionExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitReadExpr(imlParser.ReadExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitComparisonExpr(imlParser.ComparisonExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
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
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitParenExpr(imlParser.ParenExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitColumnsExpr(imlParser.ColumnsExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitImageArithmeticExpr(imlParser.ImageArithmeticExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitPrimaryExpr(imlParser.PrimaryExprContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
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

   @Override public String visitArithmeticExpr(imlParser.ArithmeticExprContext ctx) {
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
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitList(imlParser.ListContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitType(imlParser.TypeContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }
}
