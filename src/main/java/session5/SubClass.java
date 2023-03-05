package session5;

class BaseClass {
    public int book = 6;
    public void base() {
        System.out.println("父类的普通方法");
    }
    public void test() {
        System.out.println("父类的被覆盖的方法");
    }
}

public class SubClass extends BaseClass {
    public String book = "轻量级Java";

    @Override
    public void test() {
        System.out.println("子类的覆盖父类的方法");
    }
    public void sub() {
        System.out.println("子类的普通方法");
    }

    public static void main(String[] args) {
        BaseClass polymorphicBc = new SubClass();
        // 相同类型的变量，调用同一个方法时呈现多种不同的行为特征，这就是多态
        // 对象的实例变量不具备多态性
        System.out.println(polymorphicBc.book); // 6
        polymorphicBc.base(); // 父类的普通方法
        polymorphicBc.test(); // 子类的覆盖父类的方法
//        polymorphicBc.sub()
    }
}
