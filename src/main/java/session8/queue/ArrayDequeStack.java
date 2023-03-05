package session8.queue;

import java.util.ArrayDeque;

/**
 * 把ArrayDeque当成栈来用
 */
public class ArrayDequeStack {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("疯狂Java讲义");
        stack.push("疯狂Ajax讲义");
        stack.push("疯狂Android讲义");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
