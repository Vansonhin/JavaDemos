package session7.regextest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTest {
    public static void main(String[] args) {
        String str = "我是我，你是你";
        Matcher matcher = Pattern.compile("我").matcher(str);
        System.out.println(matcher.replaceFirst("郑文轩").replaceAll("你", "李梓莹"));
    }
}
