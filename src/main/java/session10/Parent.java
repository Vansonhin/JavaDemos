package session10;

import java.io.IOException;

/**
 * 书上说“子类方法声明抛出的异常不允许比父类方法声明抛出的异常多”
 * 我之前读的时候写了句“没有吧”
 * 现在第二次读，来测试一下
 * 确实没有啊，不能全信书
 */

public class Parent {
    public void print() throws IOException {
        System.out.println("parent do something");
    }
}

class Child extends Parent {
    @Override
    public void print() throws IOException, NullPointerException, ArithmeticException {
        System.out.println("child do something");
    }

    public static void main(String[] args) throws Exception {
        Child child = new Child();
        child.print();
    }

}
