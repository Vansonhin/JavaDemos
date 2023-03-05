package session5;

public class VarArgs {
    public static void test(int num, String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        test(5, "one", "two", "three");
    }
}
