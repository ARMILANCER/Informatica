import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.Vector;

public class MyAlbum {
    /*
     DEF
     Str 50, Str 50, Int 1
     total bytes: 204 bytes x camp
     */
    private final String path;

    public MyAlbum(String path){
        this.path = path;
    }

    public void gestionFile(int choice){
        try(RandomAccessFile raf = new RandomAccessFile(path,"rw")){
            Album album;
            switch (choice){
                case 1:
                    // write

                    // while
                    album = new Album(" name","date",1253);
                    write(raf,album);
                    break;
                case 2:
                    //read
                    album = read(raf);
                    break;
                case 3:
                    // to define
                    break;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void write(RandomAccessFile raf,Album album)throws IOException{
        raf.seek(raf.length());
        for (int i=0;i<3;i++){
            raf.writeChars(album.getName());
            raf.writeChars(album.getAuthor());
            raf.writeInt(album.getYear());
        }
    }

    private Album read(RandomAccessFile raf){
        Album album = new Album();



        return album;
    }

    public static void main(String[] args){
        MyAlbum album = new MyAlbum("../collection.bin");



    }
}
