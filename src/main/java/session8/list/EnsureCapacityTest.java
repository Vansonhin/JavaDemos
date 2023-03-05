package session8.list;

import utils.TimeUtils;

import java.util.ArrayList;

public class EnsureCapacityTest {
    public static void main(String[] args) {
        final int length = 10000000;
        long start1 = System.currentTimeMillis();
        ArrayList<Integer> list1 = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list1.add(i);
        }
        TimeUtils.timeRuns(start1);
        long start2 = System.currentTimeMillis();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list2.add(i);
        }
        TimeUtils.timeRuns(start2);
        long start3 = System.currentTimeMillis();
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.ensureCapacity(length);
        for (int i = 0; i < length; i++) {
            list3.add(i);
        }
        TimeUtils.timeRuns(start3);
    }
}
