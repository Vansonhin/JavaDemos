package session18reflect;

class Tester {
    static {
        System.out.println("类类我啊，被初始化了呢");
    }
}

public class LoadTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // 这里并不会初始化Tester类
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        loader.loadClass("session18reflect.Tester");
        System.out.println("系统加载LoadTest类");
        // 这里才会
        Class.forName("session18reflect.Tester");
    }
}
