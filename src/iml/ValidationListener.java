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
            declaredVariables.put(variableName, inferredType);
        }

    }

    public void enterAssignment(imlParser.AssignmentContext ctx) {

        String variableName = ctx.ID().getText();
        
        if (!declaredVariables.containsKey(variableName)) {
            System.err.println("Error: Variable '" + variableName + "' not declared.");
            error = true;
            return;
        }

        TypeInferenceVisitor typeVisitor = new TypeInferenceVisitor(declaredVariables);
        String inferredType = typeVisitor.visit(ctx.expression());
        String variableType = declaredVariables.get(variableName);

        if (!variableType.equals(inferredType)) {
            System.err.printf(
                "Type error: cannot assign %s to variable '%s' of type %s%n",
                inferredType, variableName, variableType
            );
            error = true;
            return;
        }

    }

    public void enterIfStatement(imlParser.IfStatementContext ctx) {

        TypeInferenceVisitor typeVisitor = new TypeInferenceVisitor(declaredVariables);
        String inferredType = typeVisitor.visit(ctx.expression());

        if (!inferredType.equals("boolean")) {
            System.err.println("Type error: if statement is invalid");
        }

    }

    public void enterForStatement(imlParser.ForStatementContext ctx) {

    }

    public void enterUntilStatement(imlParser.UntilStatementContext ctx) {

    }

    public void enterOutputStatement(imlParser.OutputStatementContext ctx) {

    }

    public void enterDrawStatement(imlParser.DrawStatementContext ctx) {

    }

    public void enterStoreStatement(imlParser.StoreStatementContext ctx) {

    }


}