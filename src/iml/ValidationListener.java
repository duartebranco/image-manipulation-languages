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

        if (!inferredType.equals("boolean ")) {
            System.err.println("Type error: if statement is invalid");
        }

    }

    public void enterForStatement(imlParser.ForStatementContext ctx) {
        String type = ctx.type().getText();
        String variable = ctx.ID().getText();

        if (declaredVariables.containsKey(variable)) {
            System.err.println("Error: Variable '" + variable + "' already declared in outer scope.");
            error = true;
            return;
        }

        TypeInferenceVisitor typeVisitor = new TypeInferenceVisitor(declaredVariables);
        String iterableType = typeVisitor.visit(ctx.expression());

        if (!iterableType.equals("list of " + type)) {
            System.err.printf("Type error: 'for' loop expects list of %s but got %s%n", type, iterableType);
            error = true;
        } else {
            declaredVariables.put(variable, type);
        }
    }

    public void enterUntilStatement(imlParser.UntilStatementContext ctx) {
        TypeInferenceVisitor typeVisitor = new TypeInferenceVisitor(declaredVariables);
        String inferredType = typeVisitor.visit(ctx.expression());

        if (!inferredType.equals("boolean")) {
            System.err.println("Type error: 'until' condition must be boolean");
            error = true;
        }
    }

    public void enterOutputStatement(imlParser.OutputStatementContext ctx) {
        TypeInferenceVisitor typeVisitor = new TypeInferenceVisitor(declaredVariables);
        String exprType = typeVisitor.visit(ctx.expression());

        if (!(exprType.equals("string") || exprType.equals("number") || exprType.equals("boolean"))) {
            System.err.printf("Type error: cannot output type '%s'%n", exprType);
            error = true;
        }
    }

    public void enterDrawStatement(imlParser.DrawStatementContext ctx) {
        TypeInferenceVisitor typeVisitor = new TypeInferenceVisitor(declaredVariables);
        String exprType = typeVisitor.visit(ctx.expression());

        if (!exprType.equals("image")) {
            System.err.printf("Type error: cannot draw type '%s'%n", exprType);
            error = true;
        }
    }

    public void enterStoreStatement(imlParser.StoreStatementContext ctx) {
        TypeInferenceVisitor typeVisitor = new TypeInferenceVisitor(declaredVariables);
        String exprType = typeVisitor.visit(ctx.expression());

        if (!exprType.equals("image")) {
            System.err.printf("Type error: only images can be stored, got %s%n", exprType);
            error = true;
        }
    }

    public void enterAppendStatement(imlParser.AppendStatementContext ctx) {
        String listVar = ctx.ID().getText();
    
        if (!declaredVariables.containsKey(listVar)) {
            System.err.println("Error: Variable '" + listVar + "' not declared.");
            error = true;
            return;
        }

        TypeInferenceVisitor typeVisitor = new TypeInferenceVisitor(declaredVariables);
        String listType = declaredVariables.get(listVar);
        String exprType = typeVisitor.visit(ctx.expression());

        if (!listType.startsWith("list of ")) {
            System.err.printf("Type error: '%s' is not a list%n", listVar);
            error = true;
            return;
        }

        String elementType = listType.substring("list of ".length());
        if (!elementType.equals(exprType)) {
            System.err.printf("Type error: cannot append %s to %s%n", exprType, listType);
            error = true;
            return;
        }
    }

}