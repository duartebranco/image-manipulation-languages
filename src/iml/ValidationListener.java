import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

@SuppressWarnings("CheckReturnValue")
public class ValidationListener extends imlBaseListener {
    
    private HashMap<String, String> declaredVariables = new HashMap<>();
    private HashMap<String, Function> declaredFunctions = new HashMap<>();
    private HashMap<String, HashMap<String, String>> functionVariables = new HashMap<>();
    private boolean error = false;
    private String currentFunction = "Global Scope";

    private TypeInferenceVisitor typeVisitor = new TypeInferenceVisitor(declaredVariables, declaredFunctions, functionVariables);

    public boolean hasError() {
        return this.error;
    }

    @Override
    public void enterVariableDeclaration(imlParser.VariableDeclarationContext ctx) {

        String declaredType = ctx.type().getText();
        String variableName = ctx.ID().getText();
        String inferredType;

        if (ctx.expression() != null) {
            inferredType = typeVisitor.visit(ctx.expression());
        } else {
            inferredType = declaredType;
        }

        if (inferredType.endsWith("any")) {
            inferredType = declaredType;
        }

        if (!currentFunction.equals("Global Scope")) {
            if (functionVariables.containsKey(currentFunction)) {

                if (functionVariables.get(currentFunction).containsKey(variableName)) {
                    System.err.println("Error: Variable '" + variableName + "' already declared (inside + '" + currentFunction + "').");
                    error = true;
                    return;
                }

                if (!declaredType.equals(inferredType)) {
                    System.err.printf(
                        "Type error: cannot assign %s to variable '%s' of type %s%n",
                        inferredType, variableName, declaredType
                    );
                    error = true;
                    return;
                } else {
                    functionVariables.get(currentFunction).put(variableName, inferredType);    
                }

            } else {
                System.err.println("Error: Non-existent function");
                error = true;
                return;
            }
            return;
        }

        if (declaredVariables.containsKey(variableName)) {
            System.err.println("Error: Variable '" + variableName + "' already declared.");
            error = true;
            return;
        }

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
        String inferredType = typeVisitor.visit(ctx.expression());

        if (!currentFunction.equals("Global Scope")) {
            if (functionVariables.containsKey(currentFunction)) {

                if (!functionVariables.get(currentFunction).containsKey(variableName)) {
                    System.err.println("Error: Variable '" + variableName + "' not declared.");
                    error = true;
                    return;
                }

                String variableType = functionVariables.get(currentFunction).get(variableName);

                if (!variableType.equals(inferredType)) {
                    System.err.printf(
                        "Type error: cannot assign %s to variable '%s' of type %s%n",
                        inferredType, variableName, variableType
                    );
                    error = true;
                    return;
                }

            } else {
                System.err.println("Error: Non-existent function");
                error = true;
                return;
            }
            return;
        }
        
        if (!declaredVariables.containsKey(variableName)) {
            System.err.println("Error: Variable '" + variableName + "' not declared.");
            error = true;
            return;
        }

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

        String inferredType = typeVisitor.visit(ctx.expression());

        if (!inferredType.equals("boolean")) {
            System.err.println("Type error: if statement is invalid");
            error = true;
            return;
        }

    }

    public void enterForStatement(imlParser.ForStatementContext ctx) {
        String type = ctx.type().getText();
        String variable = ctx.ID().getText();
        String iteratableType = typeVisitor.visit(ctx.expression());

        if (!currentFunction.equals("Global Scope")) {
            if (functionVariables.containsKey(currentFunction)) {

                if (functionVariables.get(currentFunction).containsKey(variable)) {
                    System.err.println("Error: Variable '" + variable + "' already declared in outer scope.");
                    error = true;
                    return;
                }

                if (!iteratableType.equals("list of " + type)) {
                    System.err.printf("Type error: 'for' loop expects list of %s but got %s%n", type, iteratableType);
                    error = true;
                } else {
                    functionVariables.get(currentFunction).put(variable, type);
                }

            } else {
                System.err.println("Error: Non-existent function");
                error = true;
                return;
            }
            return;
        }

        if (declaredVariables.containsKey(variable)) {
            System.err.println("Error: Variable '" + variable + "' already declared in outer scope.");
            error = true;
            return;
        }

        if (!iteratableType.equals("list of " + type)) {
            System.err.printf("Type error: 'for' loop expects list of %s but got %s%n", type, iteratableType);
            error = true;
        } else {
            declaredVariables.put(variable, type);
        }
    }

    public void enterUntilStatement(imlParser.UntilStatementContext ctx) {
        String inferredType = typeVisitor.visit(ctx.expression());

        if (!inferredType.equals("boolean")) {
            System.err.println("Type error: 'until' condition must be boolean");
            error = true;
        }
    }

    public void enterOutputStatement(imlParser.OutputStatementContext ctx) {
        String exprType = typeVisitor.visit(ctx.expression());

        if (!(exprType.equals("string") || exprType.equals("number") || exprType.equals("boolean")  || exprType.equals("image"))) {
            System.err.printf("Type error: cannot output type '%s'%n", exprType);
            error = true;
        }
    }

    public void enterDrawStatement(imlParser.DrawStatementContext ctx) {
        String exprType = typeVisitor.visit(ctx.expression());

        if (!exprType.equals("image")) {
            System.err.printf("Type error: cannot draw type '%s'%n", exprType);
            error = true;
        }
    }

    public void enterStoreStatement(imlParser.StoreStatementContext ctx) {
        String exprType = typeVisitor.visit(ctx.expression());

        if (!exprType.endsWith("image")) {
            System.err.printf("Type error: only images can be stored, got %s%n", exprType);
            error = true;
        }
    }

    public void enterAppendStatement(imlParser.AppendStatementContext ctx) {
        String listVar = ctx.ID().getText();
        String exprType = typeVisitor.visit(ctx.expression());

        if (!currentFunction.equals("Global Scope")) {
            if (functionVariables.containsKey(currentFunction)) {

                if (!functionVariables.get(currentFunction).containsKey(listVar)) {
                    System.err.println("Error: Variable '" + listVar + "' not declared.");
                    error = true;
                    return;
                }

                String listType = functionVariables.get(currentFunction).get(listVar);

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

            } else {
                System.err.println("Error: Non-existent function");
                error = true;
                return;
            }
            return;
        }
    
        if (!declaredVariables.containsKey(listVar)) {
            System.err.println("Error: Variable '" + listVar + "' not declared.");
            error = true;
            return;
        }

        String listType = declaredVariables.get(listVar);

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

    public void enterFunctionDecl(imlParser.FunctionDeclContext ctx) {

        String functionName = ctx.ID().getText();
        String returnType = ctx.type() != null ? ctx.type().getText() : "void";

        List<String> parameterTypes = ctx.paramList() == null ? new ArrayList<>()
            : ctx.paramList().param().stream()
                .map(p -> p.type().getText())
                .collect(Collectors.toList());

        if (declaredFunctions.containsKey(functionName)) {
            if (declaredFunctions.get(functionName).getParametersType().toString().equals(parameterTypes.toString())) {
                System.err.printf("Function error: Function %s has already been declared\n", functionName);
                error = true;
                return;
            }
        }

        functionVariables.put(functionName, new HashMap<>());

        currentFunction = functionName;
        typeVisitor.changeScope(functionName);

        declaredFunctions.put(functionName, new Function(returnType, parameterTypes));

    }

    @Override
    public void exitFunctionDecl(imlParser.FunctionDeclContext ctx) {

        if (ctx.expression() != null) {
            declaredFunctions.get(currentFunction).changeReturnType(typeVisitor.visit(ctx.expression()));
        }

        currentFunction = "Global Scope";
        typeVisitor.changeScope("Global Scope");
    }
}