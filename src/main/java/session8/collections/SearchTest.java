package session8.collections;

import java.util.ArrayList;
import java.util.Collections;

public class SearchTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(4);
        list.add(2);
        list.add(-5);
        list.add(3);
        list.add(0);
        System.out.println(list);
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        System.out.println(Collections.replaceAll(list, 0, 1));
        System.out.println(Collections.frequency(list, -5));
        Collections.sort(list);
        System.out.println(list);
        System.out.println(Collections.binarySearch(list, 3));
    }
}
