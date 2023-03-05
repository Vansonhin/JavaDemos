package session8.map;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("疯狂Java讲义", 109);
        map.put("疯狂IOS讲义", 10);
        map.put("疯狂Ajax讲义", 79);
        map.put("轻量级", 99);
        System.out.println(map.put("疯狂IOS讲义", 99));
        System.out.println(map);
        System.out.println(map.containsKey("疯狂IOS讲义"));
        System.out.println(map.containsValue(99));
        for (String s : map.keySet()) {
            System.out.println(s + "-->" + map.get(s));
        }
        map.remove("疯狂Ajax讲义");
        System.out.println(map);
    }
}
