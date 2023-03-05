package guideio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamTest {
    public static void main(String[] args) {
        // 一般在项目中不会直接用FileInputStream
        /*try (FileInputStream fis = new FileInputStream("a.txt")) {
            System.out.println("Number of remaining bytes: " + fis.available());
            long skip = fis.skip(2);
            System.out.println("The actual number of bytes skipped: " + skip);
            byte[] bytes = new byte[32];
            while (fis.read(bytes) != -1) {
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        // 会结合字节缓冲输入流BufferedInputStream使用
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.txt"))) {
            String result = new String(bis.readAllBytes());
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
