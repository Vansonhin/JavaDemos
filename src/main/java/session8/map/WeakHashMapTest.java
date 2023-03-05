package session8.map;

import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        WeakHashMap<String, String> whm = new WeakHashMap<>();
        // 如果需要使用WeakHashMap的key来保留对象的弱引用，则不要让该key所引用的对象具有任何强引用，否则将失去使用WeakHashMap的意义
        whm.put(new String("语文"), new String("良好")); // 匿名的字符串对象，WeakHashMap只保留了它们的弱引用
        whm.put("数学", new String("还行")); // 匿名的字符串对象，WeakHashMap只保留了它们的弱引用
        whm.put(new String("英语"), "可牛了");
        whm.put("java", "中等"); // key是字符串直接量，系统会使用缓冲池保留对该字符串对象的强引用，所以垃圾回收时不会回收它
        System.out.println(whm);
        System.gc();
        System.runFinalization();
        System.out.println(whm);
    }
}
