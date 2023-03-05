package session6;

public class GcTest {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new GcTest();
            System.gc();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("系统正在清理");
    }
}
