package session8.queue;

import java.util.ArrayDeque;

public class ArrayDequeQueue {
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("疯狂Java讲义");
        queue.offer("疯狂Ajax讲义");
        queue.offer("疯狂Android讲义");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
