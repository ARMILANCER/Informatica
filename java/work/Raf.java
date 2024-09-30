package work;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
public class Raf {
    private String pathF;
    private Vector<Integer> data = new Vector<>();
    public Raf(String pathF){
        this.pathF = pathF;
    }

    public void gestionFile(int choice){
        try (RandomAccessFile raf = new RandomAccessFile(pathF, "rw")) {
            switch (choice){
                case 1:
                    System.out.print("In: ");
                    Scanner scanner = new Scanner(System.in);
                    String input;
                    while (true) {
                        System.out.print("Inserisci un numero intero (o 'exit' per uscire): ");
                        input = scanner.nextLine();
                        if (input.equalsIgnoreCase("exit")) {
                            break;
                        }
                        try {
                            data.add(Integer.parseInt(input));
                        } catch (NumberFormatException e) {
                            System.out.println("no");
                        }
                    }
                    write(raf,data);
                    break;
                case 2:
                    Vector<Integer> data = read(raf);
                    for (int i = 0; i < data.size(); i++) System.out.println("ID: "+i+" Num: "+data.get(i));
                    break;
                case 3:
                    delete(raf,new Scanner(System.in).nextInt());
                    break;
                default:
                    System.out.println("Really..?");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(RandomAccessFile raf,Vector<Integer>data) throws IOException{
        raf.seek(raf.length());
        for (Integer num : data) raf.writeInt(num);
    }

    private Vector<Integer> read(RandomAccessFile raf) throws IOException{
        data = new Vector<>();
        while(raf.getFilePointer()<raf.length()) data.add(raf.readInt());
        return data;
    }

    private void delete(RandomAccessFile raf, int posizione) throws IOException{
        data = read(raf);
        data.remove(posizione);
        raf.setLength(0);
        write(raf,data);
    }

    public static void main(String[] args){
        // pas the absolute path why the relative is not found.
        Raf raf = new Raf("/Users/christianbrito/Documents/Eli/eli/src/main/java/work/eli.csv");
        boolean stop = false;
        while (!stop){
            System.out.print("Choice: ");
            raf.gestionFile(new Scanner(System.in).nextInt());
        }
    }
}
