package session15file.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;

public class CharsetTransform {
    public static void main(String[] args) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        CharBuffer buffer = CharBuffer.allocate(8);
        buffer.put('郑');
        buffer.put('文');
        buffer.put('轩');
        buffer.flip();
        ByteBuffer byteBuffer = charset.encode(buffer);
        System.out.println("\n" + charset.decode(byteBuffer));
    }
}
