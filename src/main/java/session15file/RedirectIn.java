package session15file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 将系统的输入重定向到文件输入流，所以程序没有等待用户输入，而是直接输出文件内容
 */
public class RedirectIn {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/main/java/session15file/RedirectIn.java")) {
            System.setIn(fis);
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                System.out.println("键盘输入的内容：" + sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
