package session15file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/main/java/session15file/FileOutputStreamTest.java");
             FileOutputStream fos = new FileOutputStream("src/main/java/session15file/output.txt")) {
            byte[] buffer = new byte[32];
            int hasRead;
            while ((hasRead = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, hasRead);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
