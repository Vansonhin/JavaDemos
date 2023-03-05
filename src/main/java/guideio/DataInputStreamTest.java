package guideio;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamTest {
    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("a.txt"))) {
//            System.out.println(dis.readBoolean());
//            System.out.println(dis.readInt());
//            System.out.println(dis.readByte());
            System.out.println(new String(dis.readAllBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
