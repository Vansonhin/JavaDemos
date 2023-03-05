package session5;

public class OrderTest {
    {
        System.out.println("实例初始化块");
    }
    static {
        System.out.println("类初始化块");
    }
    public OrderTest() {
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        OrderTest ot = new OrderTest();
    }
}
