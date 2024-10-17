package Music;
import java.util.Scanner;
public class DataInput  {
    Scanner scanner = new Scanner(System.in);
    public Object read(String type) {
        Object object = switch (type) {
            case "String" -> scanner.nextLine();
            case "int" -> scanner.nextInt();
            // case "" -> scanner.next()
            default -> null;
        };
        return object;
    }
}
