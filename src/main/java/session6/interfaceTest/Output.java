package session6.interfaceTest;

public interface Output {
    int MAX_CACHE_LINE = 50; // 接口中的成员变量会默认用public static final来修饰

    void out();
    void getData(String msg); // 接口中的普通方法默认用public abstract来修饰

    // 接口中定义默认方法，需要用default修饰，默认用public修饰
    default void print(String... msgs) {
        for (String msg : msgs) {
            System.out.println(msg);
        }
    }

    // 接口中定义类方法
    static String staticTest() {
        return "接口中的类方法";
    }

    // 定义私有方法(Java9 新增)
    private void foo() {
        System.out.println("foo");
    }

    private static void bar() {
        System.out.println("bar");
    }
}
