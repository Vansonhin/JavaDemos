package session8.map;

import java.util.EnumMap;

enum Season {
    SPRING, SUMMER, FALL, WINTER
}

public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap<Season, String> map = new EnumMap<>(Season.class);
        map.put(Season.SUMMER, "夏日炎炎");
        map.put(Season.SPRING, "春暖花开");
        // 按照Enum的顺序来维护key-value对的顺序
        System.out.println(map); // {SPRING=春暖花开, SUMMER=夏日炎炎}
    }
}
