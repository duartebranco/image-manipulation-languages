// Generated from iml.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link imlParser}.
 */
public interface imlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link imlParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(imlParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(imlParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(imlParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(imlParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(imlParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(imlParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(imlParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(imlParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(imlParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(imlParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(imlParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(imlParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#untilStatement}.
	 * @param ctx the parse tree
	 */
	void enterUntilStatement(imlParser.UntilStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#untilStatement}.
	 * @param ctx the parse tree
	 */
	void exitUntilStatement(imlParser.UntilStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#outputStatement}.
	 * @param ctx the parse tree
	 */
	void enterOutputStatement(imlParser.OutputStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#outputStatement}.
	 * @param ctx the parse tree
	 */
	void exitOutputStatement(imlParser.OutputStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#drawStatement}.
	 * @param ctx the parse tree
	 */
	void enterDrawStatement(imlParser.DrawStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#drawStatement}.
	 * @param ctx the parse tree
	 */
	void exitDrawStatement(imlParser.DrawStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#storeStatement}.
	 * @param ctx the parse tree
	 */
	void enterStoreStatement(imlParser.StoreStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#storeStatement}.
	 * @param ctx the parse tree
	 */
	void exitStoreStatement(imlParser.StoreStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#appendStatement}.
	 * @param ctx the parse tree
	 */
	void enterAppendStatement(imlParser.AppendStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#appendStatement}.
	 * @param ctx the parse tree
	 */
	void exitAppendStatement(imlParser.AppendStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loadExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLoadExpr(imlParser.LoadExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loadExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLoadExpr(imlParser.LoadExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConversionExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringConversionExpr(imlParser.StringConversionExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConversionExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringConversionExpr(imlParser.StringConversionExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterReadExpr(imlParser.ReadExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitReadExpr(imlParser.ReadExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpr(imlParser.ComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpr(imlParser.ComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code countPixelExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCountPixelExpr(imlParser.CountPixelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code countPixelExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCountPixelExpr(imlParser.CountPixelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code anyPixelExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnyPixelExpr(imlParser.AnyPixelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code anyPixelExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnyPixelExpr(imlParser.AnyPixelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowsExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRowsExpr(imlParser.RowsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowsExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRowsExpr(imlParser.RowsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(imlParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(imlParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnsExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterColumnsExpr(imlParser.ColumnsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnsExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitColumnsExpr(imlParser.ColumnsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code imageArithmeticExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImageArithmeticExpr(imlParser.ImageArithmeticExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code imageArithmeticExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImageArithmeticExpr(imlParser.ImageArithmeticExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(imlParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(imlParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code erodeExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterErodeExpr(imlParser.ErodeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code erodeExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitErodeExpr(imlParser.ErodeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code openExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOpenExpr(imlParser.OpenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code openExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOpenExpr(imlParser.OpenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code closeExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCloseExpr(imlParser.CloseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code closeExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCloseExpr(imlParser.CloseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code topHatExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTopHatExpr(imlParser.TopHatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code topHatExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTopHatExpr(imlParser.TopHatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmeticExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpr(imlParser.ArithmeticExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmeticExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpr(imlParser.ArithmeticExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code runExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRunExpr(imlParser.RunExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code runExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRunExpr(imlParser.RunExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blackHatExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBlackHatExpr(imlParser.BlackHatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blackHatExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBlackHatExpr(imlParser.BlackHatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dilateExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDilateExpr(imlParser.DilateExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dilateExpr}
	 * labeled alternative in {@link imlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDilateExpr(imlParser.DilateExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(imlParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(imlParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(imlParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(imlParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link imlParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(imlParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link imlParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(imlParser.TypeContext ctx);
}