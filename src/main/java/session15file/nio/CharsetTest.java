package session15file.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {
    public static void main(String[] args) {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + "-->" + entry.getValue()));
    }
}
