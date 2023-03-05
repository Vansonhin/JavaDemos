package session8.map;

import java.util.IdentityHashMap;

public class IdentityHashMapTest {
    public static void main(String[] args) {
        IdentityHashMap<String, Integer> map = new IdentityHashMap<>();
        // 都能加进去，因为key虽然equals返回true，但是==返回false，这就是与HashMap的不同点
        map.put(new String("语文"), 89);
        map.put(new String("语文"), 78);
        // 只能加一个
        map.put("java", 95);
        map.put("java", 98);
        System.out.println(map); // {java=98, 语文=78, 语文=89}
    }
}
