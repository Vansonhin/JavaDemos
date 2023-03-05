package session7.regextest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroup {
    public static void main(String[] args) {
        String str = "我想求购一本《疯狂Java讲义》，尽快联系我13500006666" + "交朋友，电话号码是13611125565" + "出售二手电脑，联系方式15899903312";
        // 抓取13x和15x号段的手机号码
        Matcher matcher = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
