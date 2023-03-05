package session14;

import java.lang.annotation.Annotation;

/**
 * @author Vansonhin
 * @since 2023/2/18
 */
public class MyTest {
    @TestTable
    public void info() {
        System.out.println("info");
    }
    @Testable
    public static void m1(){}
    public static void m2(){}
    @Testable
    public static void m3(){
        throw new IllegalArgumentException("参数出错了");
    }
    public static void m4() {}
    @Testable
    public static void m5() {}
    public static void m6() {}
    @Testable
    public static void m7() {
        throw new RuntimeException("程序业务出现异常");
    }
    public static void m8() {}

    public static void main(String[] args) throws ClassNotFoundException {
        ProcessorTest.process("session14.MyTest");
    }
}
