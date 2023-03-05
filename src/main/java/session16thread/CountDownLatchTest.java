package session16thread;

import utils.TimeUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CountDownLatchTest {
    private static final int COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        final CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        for (int i = 1; i <= COUNT; i++) {
            int threadNum = i;
            pool.execute(() -> {
                try {
                    test(threadNum);
                    System.out.println(pool.getActiveCount());
                    System.out.println(pool.getCompletedTaskCount());
                    System.out.println(pool.getTaskCount());
                    System.out.println(pool.getLargestPoolSize());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        pool.shutdown();
        System.out.println("finish");
        TimeUtils.timeRuns(start);
    }

    private static void test(int threadNum) throws InterruptedException {
        System.out.println("do something ---> " + threadNum);
        Thread.sleep(threadNum * 1000L);
    }
}
