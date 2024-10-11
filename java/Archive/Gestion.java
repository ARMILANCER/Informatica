package Archive;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.*;
public class Gestion {
    private StringBuilder tupla = new StringBuilder();
    private Album album;
    private LinkedList<Map> indexing = new LinkedList<>();
    private String path;
    private int counter = 0;

    public Gestion(String path) {
        this.path = path;
        try(RandomAccessFile raf = new RandomAccessFile(path, "rw")){
            formatCounter(raf);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void formatCounter(RandomAccessFile raf) throws IOException {
        raf.seek(raf.length()-128);
    }

    public void gestionFile(int choice) {
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
            switch (choice) {
                case 1:
                    album = new Album("album della signa","Umanita ",2);
                    write(raf, album);
                    break;
                case 2:
                    read(raf);
                    break;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void indexingFile(Album album){
        indexing.add(new Map(album.getName(),counter));
    }

    private void filling() {
        tupla.setLength(0);
        while (tupla.length() < 120) {
            tupla.append(' ');
        }
    }

    private void write(RandomAccessFile raf,Album album) throws IOException {
        filling();
        tupla.replace(0, album.getName().length(), album.getName());
        tupla.replace(60, 60 + album.getArtist().length(), album.getArtist());
        //tupla.replace(120,120+4,"4234");
        raf.seek(raf.length());
        raf.writeInt(counter);
        raf.writeBytes(tupla.toString());
        raf.writeInt(album.getYear());
        System.out.println(raf.length());
    }

    private void read(RandomAccessFile raf) throws IOException {
        List<byte[]> tuple = new ArrayList<>();
        // cycle for || by function
        tuple.add(new byte[4]);
        tuple.add(new byte[60]);
        tuple.add(new byte[60]);
        tuple.add(new byte[4]);
        for(int i=0;raf.getFilePointer()!=raf.length(); i = (i +1) % tuple.size()){
            raf.readFully(tuple.get(i));
            if(i==tuple.size()-1){
                System.out.print(new String(tuple.get(0))+" ");
                System.out.print(new String(tuple.get(1))+" ");
                System.out.println(ByteBuffer.wrap(tuple.get(2)).getInt());
            }
        }
    }
    public static void main(String[] args) {
        Gestion gestion = new Gestion("../example.csv");
        gestion.gestionFile(1);
        gestion.gestionFile(2);
    }
}
