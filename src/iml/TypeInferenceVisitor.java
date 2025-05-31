import java.util.Map;
import java.util.HashMap;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

@SuppressWarnings("CheckReturnValue")
public class TypeInferenceVisitor extends imlBaseVisitor<String> {

    private final HashMap<String, String> symbolTable;
    private final HashMap<String, Function> functionTable;
    private final HashMap<String, HashMap<String, String>> functionVariables;
    private String function;

    public TypeInferenceVisitor(HashMap<String, String> symbolTable, HashMap<String, Function> functionTable, HashMap<String, HashMap<String, String>> functionVariables) {
        this.symbolTable = symbolTable;
        this.functionTable = functionTable;
        this.functionVariables = functionVariables;
        this.function = "Global Scope";
    }

    public void changeScope(String function) {
        this.function = function;
    }

    @Override
    public String visitPrimaryExpr(imlParser.PrimaryExprContext ctx) {
        return visit(ctx.primary());
    }

    @Override
    public String visitPrimary(imlParser.PrimaryContext ctx) {
        if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            if (function.equals("Global Scope")) {
                return symbolTable.getOrDefault(id, "unknown");
            } else {
                return functionVariables.get(function).getOrDefault(id, "unknown");
            }
        } else if (ctx.NUMBER() != null) {
            return "number";
        } else if (ctx.PERCENTAGE() != null) {
            return "percentage";
        } else if (ctx.STRING() != null) {
            return "string";
        } else if (ctx.list() != null) {
            return visit(ctx.list());
        } else if (ctx.primary() != null) {
            return visit(ctx.primary());
        }
        return "unknown";
    }

    @Override
    public String visitList(imlParser.ListContext ctx) {
        if (ctx.expression().isEmpty()) return "list of any";

        // Infer the type of the first element and assume homogeneity
        String elementType = visit(ctx.expression(0));
        return "list of " + elementType;
    }

    @Override
    public String visitLoadExpr(imlParser.LoadExprContext ctx) {
        return "image";
    }

    @Override
    public String visitStringConversionExpr(imlParser.StringConversionExprContext ctx) {
        return "string";
    }

    @Override
    public String visitCountPixelExpr(imlParser.CountPixelExprContext ctx) {
        return "number";
    }

    @Override
    public String visitComparisonExpr(imlParser.ComparisonExprContext ctx) {
        return "boolean";
    }

    @Override
    public String visitAnyPixelExpr(imlParser.AnyPixelExprContext ctx) {
        return "boolean";
    }

    @Override
    public String visitAllPixelExpr(imlParser.AllPixelExprContext ctx) {
        return "boolean";
    }

    @Override
    public String visitTopHatExpr(imlParser.TopHatExprContext ctx) {
        return "image";
    }

    @Override
    public String visitBlackHatExpr(imlParser.BlackHatExprContext ctx) {
        return "image";
    }

    @Override
    public String visitOpenExpr(imlParser.OpenExprContext ctx) {
        return "image";
    }

    @Override
    public String visitCloseExpr(imlParser.CloseExprContext ctx) {
        return "image";
    }

    @Override
    public String visitDilateExpr(imlParser.DilateExprContext ctx) {
        return "image";
    }

    @Override
    public String visitErodeExpr(imlParser.ErodeExprContext ctx) {
        return "image";
    }

    @Override
    public String visitRunExpr(imlParser.RunExprContext ctx) {
        return "image";
    }

    @Override
    public String visitReadExpr(imlParser.ReadExprContext ctx) {
        return "string";
    }

    @Override
    public String visitColumnsExpr(imlParser.ColumnsExprContext ctx) {
        return "number";
    }

    @Override
    public String visitRowsExpr(imlParser.RowsExprContext ctx) {
        return "number";
    }

    @Override
    public String visitParenExpr(imlParser.ParenExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public String visitFlipExpr(imlParser.FlipExprContext ctx) {
        return "image";
    }

    @Override
    public String visitScaleExpr(imlParser.ScaleExprContext ctx) {
        return "image";
    }

    @Override
    public String visitPixelOperationExpr(imlParser.PixelOperationExprContext ctx) {
        return "image";
    }

    @Override
    public String visitUnaryPixelOperationExpr(imlParser.UnaryPixelOperationExprContext ctx) {
        return "image";
    }

    @Override
    public String visitArithmeticExpr(imlParser.ArithmeticExprContext ctx) {
        return "number";
    }

    @Override
    public String visitPixelBoolOperationExpr(imlParser.PixelBoolOperationExprContext ctx) {
        return "image";
    }

    @Override
    public String visitUnaryPixelBoolOperationExpr(imlParser.UnaryPixelBoolOperationExprContext ctx) {
        return "image";
    }

    @Override
    public String visitFunctionCallExpr(imlParser.FunctionCallExprContext ctx) {
        String functionName = ctx.ID().getText();
        String returnType = "unknown";

        for (String name : functionTable.keySet()) {
            if (name.equals(functionName)) {
                returnType = functionTable.get(name).getReturnType();
            }
        }

        return returnType;
    }

}
