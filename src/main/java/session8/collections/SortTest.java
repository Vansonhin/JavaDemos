package session8.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(-5);
        list.add(3);
        list.add(0);
        System.out.println(list); // 2, -5, 3, 0
        Collections.reverse(list);
        System.out.println(list); // 0, 3, -5, 2
        Collections.sort(list);
        System.out.println(list); // -5, 0, 2, 3
        Collections.shuffle(list);
        System.out.println(list);
    }
}
