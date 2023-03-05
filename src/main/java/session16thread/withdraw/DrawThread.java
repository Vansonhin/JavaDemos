package session16thread.withdraw;

public class DrawThread extends Thread {
    private final Account account;
    private final double drawAmount;
    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    public void run() {
        account.draw(drawAmount);
    }
}
