package session8.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class A {
    public boolean equals(Object obj) {
        return true;
    }
}
class B {
    public int hashCode() {
        return 1;
    }
    public boolean equals(Object obj) {
        return false;
    }
}
class C {
    public int hashCode() {
        return 2;
    }
    public boolean equals(Object obj) {
        return true;
    }
}

public class HashSetTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new A());
        set.add(new A());
        set.add(new B());
        set.add(new B());
        set.add(new C());
        set.add(new C());
        System.out.println(set);
    }
}
