package session7.regextest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEnd {
    public static void main(String[] args) {
        String str = "Java is very easy!";
        Matcher matcher = Pattern.compile("\\w+").matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            System.out.println(sb.append(matcher.group()).append("子串的起始位置：").append(matcher.start()).append("，结束位置：").append(matcher.end()));
            sb.setLength(0);
        }
    }
}
