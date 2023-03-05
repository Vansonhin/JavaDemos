package session6;

@FunctionalInterface
interface Eatable {
    void taste();
}
@FunctionalInterface
interface Flyable {
    void fly(String weather);
}
@FunctionalInterface
interface Addable {
    int add(int a, int b);
}
@FunctionalInterface
interface MyTest {
    String test(String a, int b, int c);
}
@FunctionalInterface
interface YourTest {
    LambdaQs getInstance();
}

public class LambdaQs {
    public void eat(Eatable eatable) {
        System.out.println(eatable);
        eatable.taste();
    }
    public void drive(Flyable flyable) {
        System.out.println("我正在驾驶：" + flyable);
        flyable.fly("【碧空如洗的晴日】");
    }
    public void test(Addable addable) {
        System.out.println("5与3的和为：" + addable.add(5, 3));
    }
    public String test2(MyTest myTest) {
        return myTest.test("Java I love you", 2, 9);
    }
    public static LambdaQs getInstance(YourTest yourTest) {
        return yourTest.getInstance();
    }

    public static void main(String[] args) {
        LambdaQs lqs = LambdaQs.getInstance(LambdaQs::new);
        lqs.eat(() -> System.out.println("苹果味道不错"));
        lqs.drive(weather -> {
            System.out.println("今天天气是：" + weather);
            System.out.println("直升机飞行平稳");
        });
        lqs.test((Integer::sum));
        System.out.println(lqs.test2((String::substring)));
    }
}
