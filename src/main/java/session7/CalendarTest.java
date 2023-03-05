package session7;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2023, Calendar.JANUARY, 31);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DATE, 5);
        System.out.println(cal.getTime()); // Sun Feb 05 10:33:42 CST 2023
    }
}
