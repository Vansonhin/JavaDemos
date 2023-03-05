package session15file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("src/main/java/session15file/test.txt");
             PrintStream ps = new PrintStream(fos)) {
            ps.println("普通字符串");
            ps.println(new PrintStreamTest());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
