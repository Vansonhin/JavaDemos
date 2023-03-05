package session7.regextest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaaaaaab");
        System.out.println(m.matches());

        System.out.println(Pattern.matches("a*b", "aaaaaaaaaaaaab"));
    }
}
