package session16thread.withdraw;

public class DrawTest {
    public static void main(String[] args) {
        Account account = new Account("6866", 1000);
        new DrawThread("甲", account, 800).start();
        new DrawThread("乙", account, 800).start();
    }
}
