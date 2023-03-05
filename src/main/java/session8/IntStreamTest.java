package session8;

import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        IntStream is = IntStream.builder()
                .add(20)
                .add(13)
                .add(-2)
                .add(18)
                .build();
        System.out.println(is.max().getAsInt());
        System.out.println(is.min().getAsInt());
    }
}
