package Music;
import java.util.Vector;

public class Album {
    private Vector <Attribute> attributes = new Vector<>();
    private int maxLength;
    public Album() {}
    public Album(Album albumInstance) {
        this.maxLength = albumInstance.maxLength;
        this.attributes.addAll(albumInstance.attributes);
        setValue();
    }
    public void addAttribute(String name,String type,int value) {
        attributes.add(new Attribute(name,type,value));
        maxLength += value;
    }
    public void setValue() {
        for (Attribute e : attributes) {
            System.out.print(e.getName() + ": ");
            e.setValue();
        }
    }
    public Vector<Attribute> getAttributes() {
        return attributes;
    }

}
