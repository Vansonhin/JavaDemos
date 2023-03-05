package utils;

import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.SEPTEMBER, 20);
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
    }
}
