public class Album {
    private int nameDim, authorDim, yearDim;
    private String name, author;
    private int year;
    public Album(String name, String author, int year){
        this.name = name;
        this.author = author;
        this.year = year;
        nameDim = 100;
        authorDim = 140;
        yearDim = 4;
    }

    public Album() {
    };

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
