package session8.map;

import java.util.TreeMap;

class R implements Comparable<Object> {
    int count;
    public R(int count) {
        this.count = count;
    }
    public String toString() {
        return "R[count:" + count + "]";
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == R.class) {
            R r = (R) obj;
            return r.count == this.count;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        R r = (R) o;
        return Integer.compare(count, r.count);
    }
}

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<R, String> tm = new TreeMap<>();
        tm.put(new R(3), "轻量级");
        tm.put(new R(-5), "疯狂Java讲义");
        tm.put(new R(9), "疯狂Android讲义");
        System.out.println(tm);
        System.out.println(tm.firstEntry()); // R[count:-5]=疯狂Java讲义
        System.out.println(tm.lastKey()); // R[count:9]
        System.out.println(tm.higherKey(new R(2))); // 3
        System.out.println(tm.lowerEntry(new R(2))); // -5
        System.out.println(tm.subMap(new R(-1), new R(4))); // 3
    }
}
