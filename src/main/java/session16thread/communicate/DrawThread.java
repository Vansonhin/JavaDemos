package session16thread.communicate;

public class DrawThread extends Thread {
    private final Account account;
    private final double drawAmount;
    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " --> " + i);
            account.draw(drawAmount);
        }
    }
}
