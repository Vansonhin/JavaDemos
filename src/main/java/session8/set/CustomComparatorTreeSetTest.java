package session8.set;
import java.util.TreeSet;

class M implements Comparable<M> {
    int age;
    public M(int age) {
        this.age = age;
    }
    public String toString() {
        return "M [age:" + age + "]";
    }

    @Override
    public int compareTo(M m) {
        return m.age - this.age;
    }
}

public class CustomComparatorTreeSetTest {
    public static void main(String[] args) {
//        TreeSet<M> treeSet = new TreeSet<>((m1, m2) -> Integer.compare(m2.age, m1.age));
        TreeSet<M> treeSet = new TreeSet<>();
        treeSet.add(new M(5));
        treeSet.add(new M(-3));
        treeSet.add(new M(9));
        System.out.println(treeSet);
    }
}
