import java.util.HashMap;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

@SuppressWarnings("CheckReturnValue")
public class ValidationListener extends imlBaseListener {
    
    private HashMap<String, String> declaredVariables = new HashMap<>();
    private boolean error = false;

    public boolean hasError() {
        return this.error;
    }

    @Override
    public void enterVariableDeclaration(imlParser.VariableDeclarationContext ctx) {

        String declaredType = ctx.type().getText();
        String variableName = ctx.ID().getText();

        if (declaredVariables.containsKey(variableName)) {
            System.err.println("Error: Variable '" + variableName + "' already declared.");
            error = true;
            return;
        }

        TypeInferenceVisitor typeVisitor = new TypeInferenceVisitor(declaredVariables);
        String inferredType = typeVisitor.visit(ctx.expression());

        if (!declaredType.equals(inferredType)) {
            System.err.printf(
                "Type error: cannot assign %s to variable '%s' of type %s%n",
                inferredType, variableName, declaredType
            );
            error = true;
            return;
        } else {
            declaredVariables.put(variableName, declaredType);
        }

    }




}