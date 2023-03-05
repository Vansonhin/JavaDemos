package session6.枚举;

public class GenderTest {
    public static void main(String[] args) {
        for (Gender gender : Gender.values()) {
            System.out.println(gender + "代表" + gender.getName());
            gender.info();
        }
    }
}
