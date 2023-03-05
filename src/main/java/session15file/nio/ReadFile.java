package session15file.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class ReadFile {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/main/java/session15file/nio/ReadFile.java");
             FileChannel channel = fis.getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(256);
            // 将FileChannel中的数据放入ByteBuffer中
            while ((channel.read(byteBuffer) != -1)) {
                byteBuffer.flip();
                Charset charset = StandardCharsets.UTF_8;
                CharsetDecoder decoder = charset.newDecoder();
                CharBuffer charBuffer = decoder.decode(byteBuffer);
                System.out.println(charBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
