package session7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerKeyboardTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/session6/GcTest.java"));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            System.out.println(sb.append("键盘的输入内容是：").append(scanner.nextLine()));
            sb.setLength(0);
        }
    }
}
