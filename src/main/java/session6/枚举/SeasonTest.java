package session6.枚举;

public class SeasonTest {
    public void judge(Season season) {
        switch (season) {
            case SPRING: {
                System.out.println("春暖花开");
                break;
            }
            case SUMMER: {
                System.out.println("夏日炎炎");
                break;
            }
            case FALL: {
                System.out.println("秋高气爽");
                break;
            }
            case WINTER: {
                System.out.println("好撚冻啊");
                break;
            }
        }
    }

    public static void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.println(season.ordinal() + ": " + season);
        }
        new SeasonTest().judge(Season.SPRING);
        System.out.println(Season.valueOf("SPRING"));
        Season season = Enum.valueOf(Season.class, "SUMMER"); // 枚举类这样创建对象
        System.out.println(season);
    }
}
