package session8.collections;

import java.util.*;

public class UnmodifiableTest {
    public static void main(String[] args) {
        // 空的，不可改变的List对象
        List<Object> list = Collections.emptyList();
        // 只有一个元素，不可改变的Set对象
        Set<String> set = Collections.singleton("疯狂Java讲义");
        // 普通Map对象
        HashMap<String, Integer> map = new HashMap<>();
        map.put("语文", 82);
        map.put("Java", 80);
        // 对应的不可变版本
        Map<String, Integer> map1 = Collections.unmodifiableMap(map);
//        list.add(1); // UnsupportedOperationException

        // Java9以后创建含多个元素的不可变对象
        List<Integer> nums = List.of(1, 2, 3, 4);
//        nums.add(5); // UnsupportedOperationException
    }
}
