import java.util.Map;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

@SuppressWarnings("CheckReturnValue")
public class TypeInferenceVisitor extends imlBaseVisitor<String> {

    private final Map<String, String> symbolTable;

    public TypeInferenceVisitor(Map<String, String> symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public String visitPrimaryExpr(imlParser.PrimaryExprContext ctx) {
        return visit(ctx.primary());
    }

    @Override
    public String visitPrimary(imlParser.PrimaryContext ctx) {
        if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            return symbolTable.getOrDefault(id, "unknown");
        } else if (ctx.NUMBER() != null) {
            return "number";
        } else if (ctx.PERCENTAGE() != null) {
            return "percentage";
        } else if (ctx.STRING() != null) {
            return "string";
        } else if (ctx.list() != null) {
            return visit(ctx.list());
        }
        return "unknown";
    }

    @Override
    public String visitList(imlParser.ListContext ctx) {
        if (ctx.expression().isEmpty()) return "list of unknown";

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
}
