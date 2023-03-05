package session7.regextest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchesTest {
    public static void main(String[] args) {
        String[] mails = {"ko@163.com", "13411980447@163.com", "vansonhin@gmail.com", "porn.com"};
        String regex = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;
        for (String mail : mails) {
            if (matcher == null) {
                matcher = pattern.matcher(mail);
            } else {
                matcher.reset(mail);
            }
            String result = mail + (matcher.matches() ? "是" : "不是") + "一个有效的邮件地址";
            System.out.println();
        }
    }
}
