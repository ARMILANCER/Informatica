package WS;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class ReadS {
    private String path;
    private StringBuilder sb;
    public ReadS(int numChar, String path) {
        this.path = path;
        filling(numChar);
    }
    public void gestionFile(){
        int choice;
        boolean stop = false;
            while(!stop){
                choice = new Scanner(System.in).nextInt();
                try(RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
                    switch (choice) {
                        case 1:
                           // raf = new RandomAccessFile(path,"r");
                            write(raf);
                            break;
                        case 2:
                          //  raf = new RandomAccessFile(path,"rw");
                            read(raf);
                            break;
                        case 3:
                            System.out.print("exit");
                            stop = true;
                            break;
                        default:
                            System.out.println("No");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
    }
    public void filling(int numChar){
        sb = new StringBuilder();
        for(int i=0;i<numChar;i++){
            sb.append('\0');
        }
    }
    public void write(RandomAccessFile raf) throws IOException{
        String text;
        System.out.print("Inserisce un testo");
        text = new Scanner(System.in).nextLine();
        raf.seek(raf.length());
        raf.writeChars(text+sb.substring(0,sb.length()-text.length()));
    }
    public void read(RandomAccessFile raf) throws IOException {
        StringBuilder text = new StringBuilder();
        char c;
        while (raf.getFilePointer()<raf.length()){
            c = raf.readChar();
            if(c!='\0'){
                text.append(c);
            }
            if(raf.getFilePointer()%100==0){
                System.out.printf("TEXT: "+text+ " Lenght: "+text.length()+"\n");
                text.setLength(0);
            }
        }
    }

    public static void main(String[] args){
        ReadS readS = new ReadS(50,"/Users/christianbrito/Documents/Eli/eli/src/main/java/WS/readString.csv");
        readS.gestionFile();
    }
}
