package session15file.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/session15file/serialize/object.txt"))) {
            Person p = (Person) ois.readObject();
            System.out.println(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
