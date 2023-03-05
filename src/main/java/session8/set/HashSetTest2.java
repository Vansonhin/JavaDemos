package session8.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class R {
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
            return this.count == r.count;
        }
        return false;
    }
    public int hashCode() {
        return this.count;
    }
}

public class HashSetTest2 {
    public static void main(String[] args) {
        Set<R> hs = new HashSet<>();
        hs.add(new R(5));
        hs.add(new R(-3));
        hs.add(new R(9));
        hs.add(new R(-2));
        System.out.println(hs);
        Iterator<R> iterator = hs.iterator();
        R first = iterator.next();
        first.count = -3;
        System.out.println(hs);
        // 删除了第二个count为-3的R对象
        hs.remove(new R(-3));
        System.out.println(hs);
        System.out.println(hs.size());
        System.out.println("===================================");
        hs.forEach(r -> System.out.println(r.hashCode()));
        hs.forEach(r -> System.out.println(r.equals(new R(-3))));
        System.out.println("===================================");
        // 下面返回false
        // 因为这个count为-3的R对象保存在了count为-2的R对象对应的位置上，但使用equals方法跟count为-2的R对象比较又返回false
        // 这将导致HashSet不可能准确访问该元素
        // 因此，不要去修改集合元素中参与计算hashCode()和equals()的实例变量
        System.out.println(hs.contains(new R(-3)));
        System.out.println(hs.contains(new R(-2)));
    }
}
