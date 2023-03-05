package session7.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewFormatterParse {
    public static void main(String[] args) {
        String str1 = "2014==04==12 01时06分09秒";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
        LocalDateTime parse = LocalDateTime.parse(str1, formatter);
        System.out.println(parse);

        // 4月 MMM
        String str2 = "2014$$$4月$$$13 20小时";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy$$$MMM$$$dd HH小时");
        LocalDateTime parse1 = LocalDateTime.parse(str2, formatter1);
        System.out.println(parse1);
    }
}
