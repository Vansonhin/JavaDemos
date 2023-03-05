package session15file.randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("src/main/java/session15file/RandomAccessTest.java", "r")) {
            System.out.println("RandomAccessFile的文件指针的初始位置：" + raf.getFilePointer());
            raf.seek(300);
            byte[] bbuf = new byte[1024];
            int hasRead;
            while ((hasRead = raf.read(bbuf)) > 0) {
                System.out.println(new String(bbuf, 0, hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
