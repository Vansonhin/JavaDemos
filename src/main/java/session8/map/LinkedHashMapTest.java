package session8.map;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("语文", 80);
        map.put("数学", 82);
        map.put("英文", 76);
        map.forEach((key, value) -> System.out.println(key + "-->" + value));
    }
}
