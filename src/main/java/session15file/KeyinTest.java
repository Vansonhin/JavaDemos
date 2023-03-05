package session15file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyinTest {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = br.readLine()) != null) {
                if ("exit".equals(line)) {
                    System.exit(1);
                }
                System.out.println("输入内容为：" + line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
