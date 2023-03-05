package session8.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
    public static void main(String[] args) {
        String[] arr = {"aaa", "bbb", "ccc"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(list);
        ListIterator<String> iterator = list.listIterator();
        // 从前向后遍历
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.add("-----------------------------");
        }
        // 从后往前
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
