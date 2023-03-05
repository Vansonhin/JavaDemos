package session7.handle;

import utils.TimeUtils;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class MethodHandleTest {
    private static void hello() {
        System.out.println("hello");
    }
    private String hello(String name) {
        System.out.println("hello with name");
        return name + ", hello";
    }

    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            MethodType type = MethodType.methodType(void.class);
            MethodHandle hello = MethodHandles.lookup().findStatic(MethodHandleTest.class, "hello", type);
            hello.invoke();

            MethodHandle helloWithName = MethodHandles.lookup().findVirtual(MethodHandleTest.class, "hello", MethodType.methodType(String.class, String.class));
            System.out.println(helloWithName.invoke(new MethodHandleTest(), "vanson"));
            TimeUtils.timeRuns(start);

            System.out.println("==============================================================");

            long start1 = System.currentTimeMillis();
            Class<?> methodHandleTest = Class.forName("session7.handle.MethodHandleTest");
            Method hello1 = methodHandleTest.getDeclaredMethod("hello");
            hello1.invoke(methodHandleTest);
            Method hello2 = methodHandleTest.getDeclaredMethod("hello", String.class);
            System.out.println(hello2.invoke(methodHandleTest.getConstructor().newInstance(), "elena"));
            TimeUtils.timeRuns(start1);
        } catch (Throwable e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
