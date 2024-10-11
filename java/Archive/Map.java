package Archive;
public class Map{
    private String Name;
    private int index;

    public Map(String name, int index) {
        this.Name = name;
        this.index = index;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
