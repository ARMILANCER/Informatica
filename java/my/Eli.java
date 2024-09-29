package my;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;
public class Eli {
    private static LinkedHashMap download(){
        LinkedHashMap<String, Vector<String>> data = new LinkedHashMap<>();;
        String line;
        Vector<String> camp;
        try( RandomAccessFile raf = new RandomAccessFile("/Users/christianbrito/Documents/Eli/eli/src/main/java/my/eli.csv","r")){
            while((line = raf.readLine())!=null){
                camp = new Vector<>();
                camp.addAll(List.of(line.split("\\,")));
                data.put(camp.lastElement(),camp);
            }
            return data;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String search(String toSearch){
        LinkedHashMap<String, Vector<String>> data = download();
        StringBuilder found = new StringBuilder();
        if (data != null) {
            data.forEach((k,v)->{
                if(v.contains(toSearch)){
                    found.append(v+"\n");
                }
            });
        }
        return found.toString();
    }

    public static void main(String[] args){
        System.out.print(search("3210987654"));
    }
}
