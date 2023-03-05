package session8;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        Set<String> books = new HashSet<>();
        books.add("轻量级");
        books.add("原理");
        books.add("疯狂java");
        books.removeIf("轻量级"::equals);
        System.out.println(books);
    }
}
