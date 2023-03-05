package guideio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderTest {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("nihao.txt")) {
            System.out.println(reader.getEncoding());
            long skip = reader.skip(3);
            System.out.println("The actual number of characters skipped: " + skip);
            char[] chars = new char[32];
            while ((reader.read(chars)) != -1) {
                System.out.println(new String(chars));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
