package session7.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("Gyyyy年中第D天");
        String dateStr = sdf.format(date);
        System.out.println(dateStr);
        String str = "14###3月##21";
        SimpleDateFormat sdf1 = new SimpleDateFormat("y###MMM##d");
        System.out.println(sdf1.parse(str));
    }
}
