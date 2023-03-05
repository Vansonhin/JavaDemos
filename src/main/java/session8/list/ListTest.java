package session8.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        books.add(1, "疯狂Ajax讲义");
        for (String book : books) {
            System.out.println(book);
        }
        books.remove(2);
        System.out.println(books.indexOf("疯狂Ajax讲义"));
        System.out.println(books.set(1, "疯狂Java讲义"));

        System.out.println(books);
        books.sort(Comparator.comparingInt(String::length));
        System.out.println(books);
        books.replaceAll(book -> String.valueOf(book.length()));
        System.out.println(books);
    }
}
