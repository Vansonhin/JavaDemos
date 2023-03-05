package utils;

public class TimeUtils {
    public static void timeRuns(long startTime) {
        System.out.println("用时" + (System.currentTimeMillis() - startTime) + "毫秒");
    }
}
