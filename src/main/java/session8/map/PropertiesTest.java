package session8.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.setProperty("username", "vanson");
        props.setProperty("password", "123456");
        props.store(new FileOutputStream("a.ini"), "comment line");

        Properties props1 = new Properties();
        props1.setProperty("gender", "male");
        props1.load(new FileInputStream("a.ini"));
        System.out.println(props1);
    }
}
