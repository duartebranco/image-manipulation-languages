// Generated from iml.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link imlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface imlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link imlParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(imlParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(imlParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(imlParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(imlParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(imlParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(imlParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#untilStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntilStatement(imlParser.UntilStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#outputStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputStatement(imlParser.OutputStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#drawStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrawStatement(imlParser.DrawStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#storeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStoreStatement(imlParser.StoreStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#appendStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppendStatement(imlParser.AppendStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loadExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoadExpr(imlParser.LoadExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConversionExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConversionExpr(imlParser.StringConversionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pixelOperationExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPixelOperationExpr(imlParser.PixelOperationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadExpr(imlParser.ReadExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(imlParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code countPixelExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCountPixelExpr(imlParser.CountPixelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anyPixelExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnyPixelExpr(imlParser.AnyPixelExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowsExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowsExpr(imlParser.RowsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(imlParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnsExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnsExpr(imlParser.ColumnsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flipExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlipExpr(imlParser.FlipExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(imlParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scaleExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScaleExpr(imlParser.ScaleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code erodeExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErodeExpr(imlParser.ErodeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code openExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenExpr(imlParser.OpenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code closeExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCloseExpr(imlParser.CloseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code topHatExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopHatExpr(imlParser.TopHatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code runExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRunExpr(imlParser.RunExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blackHatExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlackHatExpr(imlParser.BlackHatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dilateExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDilateExpr(imlParser.DilateExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(imlParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(imlParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link imlParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(imlParser.TypeContext ctx);
}