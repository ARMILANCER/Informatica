package Music;

public class Attribute  <T>{
    private  String name;
    private String type;
    private Object value;
    private int length;

    private DataInput dataInput = new DataInput();

    public Attribute(String name, String type,int length) {
        this.name = name;
        this.length = length;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue() {
        value =  dataInput.read(type);
    }

    public int getLengthBytes() {
        return length;
    }

    public void setLengthButes(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}