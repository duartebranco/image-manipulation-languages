import java.awt.image.BufferedImage;
import java.util.List;

public class Value {
    public enum Type { NUMBER, PERCENTAGE, STRING, IMAGE, LIST }
    
    private final Type type;
    private Double numberValue;
    private String stringValue;
    private BufferedImage imageValue;
    private List<Value> listValue;
    
    // Number constructor
    public Value(double value) {
        this.type = Type.NUMBER;
        this.numberValue = value;
    }
    
    // Percentage constructor
    public Value(double value, boolean isPercentage) {
        this.type = Type.PERCENTAGE;
        this.numberValue = isPercentage ? value / 100.0 : value;
    }
    
    // String constructor
    public Value(String value) {
        this.type = Type.STRING;
        this.stringValue = value;
    }
    
    // Image constructor
    public Value(BufferedImage image) {
        this.type = Type.IMAGE;
        this.imageValue = image;
    }
    
    // List constructor
    public Value(List<Value> list) {
        this.type = Type.LIST;
        this.listValue = list;
    }
    
    public Type getType() {
        return type;
    }
    
    public double asNumber() {
        if (type != Type.NUMBER && type != Type.PERCENTAGE) {
            throw new RuntimeException("Type error: Cannot convert to number");
        }
        return numberValue;
    }
    
    public String asString() {
        switch (type) {
            case STRING:
                return stringValue;
            case NUMBER:
            case PERCENTAGE:
                return String.valueOf(numberValue);
            default:
                throw new RuntimeException("Type error: Cannot convert to string");
        }
    }
    
    public BufferedImage asImage() {
        if (type != Type.IMAGE) {
            throw new RuntimeException("Type error: Not an image");
        }
        return imageValue;
    }
    
    public List<Value> asList() {
        if (type != Type.LIST) {
            throw new RuntimeException("Type error: Not a list");
        }
        return listValue;
    }
    
    @Override
    public String toString() {
        switch (type) {
            case NUMBER:
                return String.valueOf(numberValue);
            case PERCENTAGE:
                return String.valueOf(numberValue * 100) + "%";
            case STRING:
                return stringValue;
            case IMAGE:
                return "Image[" + imageValue.getWidth() + "x" + imageValue.getHeight() + "]";
            case LIST:
                return listValue.toString();
            default:
                return "Unknown";
        }
    }
}