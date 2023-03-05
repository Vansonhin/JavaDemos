package session7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalDoubleUtils {
    private static final int DEF_DIV_SCALE = 10;

    private CalDoubleUtils () {}

    public static double add(double d1, double d2) {
        return BigDecimal.valueOf(d1).add(BigDecimal.valueOf(d2)).doubleValue();
    }
    public static double subtract(double d1, double d2) {
        return BigDecimal.valueOf(d1).subtract(BigDecimal.valueOf(d2)).doubleValue();
    }
    public static double multiply(double d1, double d2) {
        return BigDecimal.valueOf(d1).multiply(BigDecimal.valueOf(d2)).doubleValue();
    }
    public static double divide(double d1, double d2) {
        BigDecimal b1 = BigDecimal.valueOf(d1);
        BigDecimal b2 = BigDecimal.valueOf(d2);
        return b1.divide(b2, DEF_DIV_SCALE, RoundingMode.HALF_UP).doubleValue(); // RoundingMode.HALF_UP四舍五入
    }
}
