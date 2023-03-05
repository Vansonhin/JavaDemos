package guideio;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamTest {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.txt");
             DataOutputStream dos = new DataOutputStream(fos)) {
//            byte[] bytes = "Vansonhin".getBytes();
//            fos.write(bytes);
            dos.writeBoolean(true);
            dos.writeInt(1234);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
