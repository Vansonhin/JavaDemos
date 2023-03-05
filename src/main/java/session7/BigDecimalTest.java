package session7;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal big1 = new BigDecimal("0.05");
        BigDecimal big2 = new BigDecimal(0.05); // Unpredictable 'new BigDecimal()' call，会存在精度丢失，要用就用上下两种方式
        BigDecimal big3 = BigDecimal.valueOf(0.01);
        printCal(big1, big3);
        System.out.println("============================");
        printCal(big2, big3);
    }

    public static void printCal(BigDecimal big1, BigDecimal big2) {
        System.out.println("0.05 + 0.01 = " + big1.add(big2));
        System.out.println("0.05 - 0.01 = " + big1.subtract(big2));
        System.out.println("0.05 * 0.01 = " + big1.multiply(big2));
        System.out.println("0.05 / 0.01 = " + big1.divide(big2));
    }
}
