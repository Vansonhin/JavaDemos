package session8;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {
    public static void main(String[] args) {
        Set<String> books = new HashSet<>();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂IOS讲义");
        books.add("疯狂Ajax讲义");
        books.add("疯狂Android讲义");
        System.out.println(books.stream()
                .filter(book -> book.contains("疯狂"))
                .count());
        System.out.println(count(books, book -> book.contains("疯狂")));
        System.out.println("========================================");
        System.out.println(books.stream()
                .filter(book -> book.contains("Java"))
                .count());
        System.out.println(count(books, book -> book.contains("Java")));
        System.out.println("========================================");
        System.out.println(books.stream()
                .filter(book -> book.length() > 10)
                .count());
        System.out.println(count(books, book -> book.length() > 10));

        books.stream().mapToInt(String::length)
                .forEach(System.out::println);
        books.stream().map(book -> book + "书").forEach(System.out::println);
        System.out.println(books);
        Set<String> collect = books.stream().map(book -> book + "书").collect(Collectors.toSet());
        System.out.println(collect);
        System.out.println(collect.stream().anyMatch(book -> book.endsWith("书")));
        System.out.println(collect.stream().allMatch(book -> book.endsWith("书")));
    }

    public static <T> int count(Collection<T> books, Predicate<T> p) {
        int total = 0;
        for (T book : books) {
            if (p.test(book)) {
                total++;
            }
        }
        return total;
    }
}
