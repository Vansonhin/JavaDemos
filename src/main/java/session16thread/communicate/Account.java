package session16thread.communicate;

import lombok.Getter;
import lombok.Setter;


public class Account {
    @Getter
    @Setter
    private String accountNo;
    @Getter
    private double balance;
    private boolean hasMoney = false;

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public synchronized void draw(double drawAmount) {
        try {
            if (!hasMoney) {
                wait();
            } else {
                System.out.print(Thread.currentThread().getName() + "取钱: " + drawAmount);
                balance -= drawAmount;
                System.out.println(", 账户余额为: " + balance);
                hasMoney = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {
        try {
            if (hasMoney) {
                wait();
            } else {
                System.out.print(Thread.currentThread().getName() + "存钱: " + depositAmount);
                balance += depositAmount;
                System.out.println(", 账户余额为: " + balance);
                hasMoney = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
