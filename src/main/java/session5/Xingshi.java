package session5;

import lombok.Data;

import java.util.Arrays;

public class Xingshi {

    @Data
    static class Datawrap {
        int a;
        int b;
    }
    public static void swap(int a, int b) {
        int temp = b;
        b = a;
        a = temp;
    }

    public static void swap(Datawrap datawrap) {
        int temp = datawrap.b;
        datawrap.b = datawrap.a;
        datawrap.a = temp;
        datawrap = null;
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 9;
        swap(a, b);
        System.out.println("a = " + a + ", b = " + b);
        Datawrap datawrap = new Datawrap();
        datawrap.a = 6;
        datawrap.b = 9;
        swap(datawrap);
        System.out.println(datawrap);
    }
}
