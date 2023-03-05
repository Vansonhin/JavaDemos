package session16thread;

public class DaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + "=================>" + getPriority());
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "------------------->" + Thread.currentThread().getPriority());
        DaemonThread d = new DaemonThread();
        d.setDaemon(true);
        d.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
