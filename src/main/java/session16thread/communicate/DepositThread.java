package session16thread.communicate;

public class DepositThread extends Thread {
    private final Account account;
    private final double depositAmount;
    public DepositThread(String name, Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " --> " + i);
            account.deposit(depositAmount);
        }
    }
}
