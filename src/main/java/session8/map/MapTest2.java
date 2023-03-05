package session8.map;

import java.util.HashMap;

public class MapTest2 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("疯狂Java讲义", 109);
        map.put("疯狂IOS讲义", 10);
        map.put("疯狂Ajax讲义", 79);
        map.put("轻量级", 99);
        map.put(null, null);
        // 尝试替换，但由于原map中没有这个key，所以不会有改变
        map.replace("疯狂XML讲义", 66);
        System.out.println(map);
        // 使用原value与传入参数计算出来的结果覆盖原value
        map.merge("疯狂IOS讲义", 10, Integer::sum);
        System.out.println(map);
        // 当key为"Java"对应的value为null(或不存在)时，使用计算的结果作为新value
        map.computeIfAbsent("Java", String::length);
        System.out.println(map); // {Java=4, 疯狂Ajax讲义=79, 疯狂IOS讲义=20, 疯狂Java讲义=109, 轻量级=99}
        map.computeIfPresent("Java", (key, value) -> value * value);
        System.out.println(map); // {Java=16, 疯狂Ajax讲义=79, 疯狂IOS讲义=20, 疯狂Java讲义=109, 轻量级=99}
    }
}
