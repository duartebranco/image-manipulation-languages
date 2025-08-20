import java.util.List;

public class Function {

    private String returnType;
    private List<String> parametersType;

    public Function(String returnType, List<String> parametersType) {
        this.returnType = returnType;
        this.parametersType = parametersType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void changeReturnType(String type) {
        this.returnType = type;
    }

    public List<String> getParametersType() {
        return parametersType;
    }

    public String toString() {
        return returnType + "-" + parametersType.toString();
    }
}
