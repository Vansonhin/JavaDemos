package session9;

interface Foo<T> {
    void test(T t);
}

public class AnonymousDiamond {
    public static void main(String[] args) {
        Foo<String> f = s -> System.out.println("test方法的s参数为：" + s);
        Foo<?> fo = (Foo<Object>) o -> System.out.println("test方法的Object参数为：" + o);
        Foo<? extends Number> fn = num -> System.out.println("test方法的Number参数为：" + num);

    }
}
