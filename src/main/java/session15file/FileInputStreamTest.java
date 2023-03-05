package session15file;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/main/java/session15file/a.txt")) {
            byte[] buffer = new byte[1024];
            int hasRead;
            while ((hasRead = fis.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, hasRead));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
