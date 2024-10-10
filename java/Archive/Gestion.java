package Archive;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Gestion {
    private StringBuilder tupla = new StringBuilder();
    private Album album;
    private Map map;
    private Scanner scanner=new Scanner(System.in);
    public void gestionFile(int choice) {
        try (RandomAccessFile raf = new RandomAccessFile("../example.csv", "rw")) {
            switch (choice) {
                case 1:
                    boolean stop = false;
                    while(!scanner.nextLine().equals("exit")){
                        album = new Album("album","artist",0000);
                        indexingFile(raf,album);
                    }
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

    public void indexingFile(RandomAccessFile raf, Album album) throws IOException {
        map.addElement();
    }

    private void filling() {
        tupla.setLength(0);
        while (tupla.length() < 120) {
            tupla.append(' ');
        }
    }

    private void write(RandomAccessFile raf,Album album) throws IOException {
        filling();
        tupla.replace(0, text.length(), text);
        tupla.replace(60, 60 + text.length(), text);
        //tupla.replace(120,120+4,"4234");
        raf.seek(raf.length());
        raf.writeBytes(tupla.toString());
        raf.writeInt(9910);
        System.out.println(raf.length());
    }

    private void read(RandomAccessFile raf) throws IOException {
        List<byte[]> tuple = new ArrayList<>();
        // cycle for || by function
        tuple.add(new byte[60]);
        tuple.add(new byte[60]);
        tuple.add(new byte[4]);
        for(int i=0;raf.getFilePointer()!=raf.length(); i = (i +1) % tuple.size()){
            raf.readFully(tuple.get(i));
            if(i==tuple.size()-1){
                byte[] byteArray = (byte[]) tuple.get(0); // Supponendo che tuple.get(0) sia un array di byte
                System.out.println(Arrays.toString(byteArray));
                System.out.println(tuple.get(i).toString().replaceAll("\\s", ""));

                System.out.println(new String(tuple.get(1)));
                System.out.println(ByteBuffer.wrap(tuple.get(2)).getInt());
            }
        }
    }
    public void parse(){

    }
    public static void main(String[] args) {
        Gestion gestion = new Gestion();
        gestion.gestionFile(1);
        gestion.gestionFile(2);
    }
}