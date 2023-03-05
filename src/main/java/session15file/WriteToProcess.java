package session15file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 实现在Java程序中启动Java虚拟机运行另一个Java程序，并向另一个Java程序中输入数据
 */
public class WriteToProcess {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("java ReadStandard");
        try (PrintStream ps = new PrintStream(p.getOutputStream())) {
            ps.println("普通字符串");
            ps.println(new WriteToProcess());
        }
    }
}

class ReadStandard {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             PrintStream ps = new PrintStream(new FileOutputStream("src/main/java/session15file/out.txt"))) {
            sc.useDelimiter("\n");
            while (sc.hasNext()) {
                ps.println(sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}