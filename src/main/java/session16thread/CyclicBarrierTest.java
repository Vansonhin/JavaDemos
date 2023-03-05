package session16thread;

import java.util.concurrent.*;

public class CyclicBarrierTest {
    private static final int THREAD_COUNT = 550;
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
        System.out.println("做完一批啦！！！");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            pool.execute(() -> {
                try {
                    test(threadNum);
                } catch (BrokenBarrierException | InterruptedException | TimeoutException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
    }

    private static void test(int threadNum) throws BrokenBarrierException, InterruptedException, TimeoutException {
        System.out.println("threadNum: " + threadNum + " is ready");
        cyclicBarrier.await(60, TimeUnit.SECONDS);
        System.out.println("threadNum: " + threadNum + " is finished");
    }
}
