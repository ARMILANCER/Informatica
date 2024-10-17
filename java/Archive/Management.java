package Music;
import java.io.*;
public class Management {
    private StringBuilder tupla = new StringBuilder();
    private final Album preInstance;
    private Map map;
    FormatData formatData = new FormatData();
    Management (Album album) {
        this.preInstance = album;
    }
    public void managementFile(int choice) {
        try (RandomAccessFile raf = new RandomAccessFile("../example.csv", "rw")) {
            switch (choice) {
                case 1:
                    Album album = new Album(preInstance);
                    //TODO: Indexing ->
                    write(raf, album);
                    break;
                case 2:
                    read(raf);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void indexingFile(RandomAccessFile raf, Album album) throws IOException {
    }
    private void write(RandomAccessFile raf, Album album) throws IOException {
        for(Attribute attribute : album.getAttributes()) {
            switch (attribute.getType()){
                case "int" -> raf.writeInt((int)attribute.getValue());
                case "String" -> raf.writeChars(formatData.streamBuilder((String)attribute.getValue(),attribute.getLengthBytes()));
            }
        }
    }
    private void read(RandomAccessFile raf) throws IOException {
        raf.readChar();
        raf.readInt();
    }
    public static void main(String[] args) {
        Album album = new Album();
        album.addAttribute("Name","String",30*2);
        album.addAttribute("Artist","String",60*2);
        album.addAttribute("Year","int",4);
        Management management = new Management(album);
        management.managementFile(1);
        management.managementFile(2);
    }
}