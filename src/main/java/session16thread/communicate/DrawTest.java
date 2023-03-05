package session16thread.communicate;

public class DrawTest {
    public static void main(String[] args) {
        Account account = new Account("1234567", 0);
        new DrawThread("取钱者", account, 800).start();
        new DepositThread("存款者", account, 800).start();
    }
}
