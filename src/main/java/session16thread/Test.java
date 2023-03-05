package session16thread;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> test("abc", false));
        t1.start();
        t1.join();
        System.out.println("-------gc后--------");
        Thread t2 = new Thread(() -> test("def", true));
        t2.start();
        t2.join();
    }

    private static void test(String s, boolean isGC) {
        try {
            ThreadLocal<Object> threadLocal = new ThreadLocal<>();
            threadLocal.set(s);
            if (isGC) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> threadClass = t.getClass();
            Field threadLocals = threadClass.getDeclaredField("threadLocals");
            threadLocals.setAccessible(true);
            Object threadLocalMap = threadLocals.get(t);
            Class<?> threadLocalMapClass = threadLocalMap.getClass();
            Field tableField = threadLocalMapClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] entries = (Object[]) tableField.get(threadLocalMap);
            for (Object o : entries) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referentField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referentField.setAccessible(true);
                    System.out.printf("弱引用key: %s, 值: %s%n", referentField.get(o), valueField.get(o));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
