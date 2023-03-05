package session15file.nio;

import java.nio.CharBuffer;

public class BufferTest {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(8);
        System.out.println("capacity: " + buffer.capacity()); // 8
        System.out.println("limit: " + buffer.limit()); // 8
        System.out.println("position: " + buffer.position()); // 0
        // 放入元素
        buffer.put('a');
        buffer.put('b');
        buffer.put('c');
        System.out.println("加入三个元素后position: " + buffer.position()); // 3
        buffer.flip();
        System.out.println("执行flip后，limit: " + buffer.limit()); // 3
        System.out.println("position: " + buffer.position()); // 0
        // 取元素
        System.out.println("第一个元素(position==0): " + buffer.get()); // a
        System.out.println("取出第一个元素后position: " + buffer.position()); // 1
        buffer.clear();
        System.out.println("执行clear后limit: " + buffer.limit()); // 8
        System.out.println("执行clear后position: " + buffer.position()); // 0
        System.out.println("执行clear后，缓冲区内容并没有被清除，第三个元素为: " + buffer.get(2)); // c
        System.out.println("执行绝对读取后，position: " + buffer.position()); // 0
    }
}
