package Music;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormatData {
    private StringBuilder camp = new StringBuilder();
    // fill "camp" with '\0' of length of the variable in input
    private void filling(int dim) {
        camp.setLength(0);
        char[] chars = new char[dim];
        Arrays.fill(chars, '\0');
        camp.append(chars);
    }
    public String streamBuilder(String format, int length) {
        filling(length);
        return camp.replace(0, format.length(), format).toString();
    }

    public byte[] byteArray(){
        List<byte[]> bytes = new ArrayList<>(): <
    }
}
