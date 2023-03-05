package session7;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {
    public static void main(String[] args) {
        // Math.random()返回[0.0, 1.0)的伪随机数
        System.out.println(Math.random());
        // 为什么叫伪随机数？看下面代码
        int seed1 = 50;
        int seed2 = 50;
        int seed3 = 100;
        // 给定相等的种子，而且方法的调用顺序也一致，那么出来的数序是一样的，所以并不是真正的随机，叫伪随机数
        printRandom(seed1);
        printRandom(seed2);
        printRandom(seed3);
        // 为了避免这种情况发生，通常用当前时间作为种子
        Random random = new Random(System.currentTimeMillis());
        // 另外提供了ThreadLocalRandom减少多线程资源竞争，最终保证系统具有更好的线程安全性
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        byte[] buffer = new byte[16];
        threadLocalRandom.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
    }

    public static void printRandom(int seed) {
        Random random = new Random(seed);
        System.out.println(random.nextBoolean());
        // 返回int范围的伪随机整数
        System.out.println(random.nextInt());
        // float和double都是[0.0, 1.0)范围的伪随机数
        System.out.println(random.nextFloat());
        System.out.println(random.nextDouble());
        System.out.println(random.nextGaussian());
        System.out.println("===============================");
    }
}
