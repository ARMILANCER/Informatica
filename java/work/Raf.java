package work;
import javafx.beans.binding.IntegerBinding;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

public class Raf {
    private StringBuilder strBdr;
    private String pathF;
    public Raf(String pathF,int length){
        this.pathF = pathF;
    }

    public void gestionFile(int choice){
        try (RandomAccessFile raf = new RandomAccessFile(pathF, "rw")) {
            switch (choice){
                case 1:
                    System.out.printf("In: ");
                    write(raf,new Scanner(System.in).nextInt());
                    break;
                case 2:
                    read(raf);
                    break;
                default:
                    System.out.println("Really..?");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(RandomAccessFile raf,Integer num) throws IOException{
        raf.seek(raf.length());
        raf.writeInt(num);
    }

    private void read(RandomAccessFile raf) throws IOException{
        System.out.print("Numbers: ");
        while(raf.getFilePointer()<raf.length()){
            System.out.print(raf.readInt()+", ");
        }
        System.out.println();
    }

    private void delete(RandomAccessFile raf, int posizione) throws IOException{
    }

    public static void main(String[] args){
        // pas the absolute path why the relative is not found.
        Raf raf = new Raf("/Users/christianbrito/Documents/Eli/eli/src/main/java/work/eli.csv",10);
        boolean stop = false;
        while (!stop){
            System.out.print("Choice: ");
            raf.gestionFile(new Scanner(System.in).nextInt());
        }

    }
}