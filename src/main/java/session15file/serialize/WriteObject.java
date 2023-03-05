package session15file.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;

public class WriteObject {
    public static void main(String[] args) {
        try (ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream("src/main/java/session15file/serialize/object.txt"))) {
            Person p = new Person("vanson", 26);
            oop.writeObject(p);
            Charset charset = Charset.defaultCharset();
            System.out.println(charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
