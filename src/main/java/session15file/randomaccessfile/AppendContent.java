package session15file.randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("src/main/java/session15file/out.txt", "rw")) {
            raf.seek(raf.length());
            raf.write("追加的内容\r\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
