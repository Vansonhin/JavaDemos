package session6;

public class NewMethodTest {
    public static void main(String[] args) {
        System.out.println(Integer.toUnsignedString(10, 2));
        System.out.println(Integer.parseUnsignedInt("1010", 2));
        final String s1 = "疯狂";
        final String s2 = "Java";
        String s3 = "疯狂" + "Java";
        System.out.println(s1 + s2 == s3);

        Integer i1 = Integer.parseInt("1");
        Integer i2 = Integer.parseInt("1");
        System.out.println(i1 == i2);
    }
}
