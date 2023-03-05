package session16thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread {
    private BlockingQueue<String> bq;
    public Producer(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        String[] strArr = new String[]{"Java", "Structs"};
        for (int i = 0; i < 99999999; i++) {
            System.out.println(getName() + "生产者准备生产集合元素");
            try {
                Thread.sleep(200);
                System.out.println(getName() + "生产前" + bq);
                bq.put(strArr[i % 2]);
                System.out.println(getName() + "生产后" + bq);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "生产完成" + bq);
        }
    }
}

class Consumer extends Thread {
    private BlockingQueue<String> bq;
    public Consumer(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName() + "消费者准备消费集合元素");
            try {
                Thread.sleep(200);
                System.out.println(getName() + "消费前" + bq);
                bq.take();
                System.out.println(getName() + "消费后" + bq);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "消费完成" + bq);
        }
    }
}

public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        new Producer(bq).start();
        new Producer(bq).start();
        new Consumer(bq).start();
    }
}
