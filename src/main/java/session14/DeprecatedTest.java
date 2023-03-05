package session14;

class Apple {
    @Deprecated(since = "9", forRemoval = true)
    public void info() {
        System.out.println("Apple info");
    }
}

public class DeprecatedTest {
    public static void main(String[] args) {
        new Apple().info();
    }
}
