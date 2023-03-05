package session15file.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

public class FileChannelTest {
    public static void main(String[] args) {
        File file = new File("src/main/java/session15file/nio/FileChannelTest.java");
        try (FileChannel inChannel = new FileInputStream(file).getChannel(); // read only
             FileChannel outChannel = new FileOutputStream("src/main/java/session15file/nio/a.txt").getChannel()) { // write only
            // 将FileChannel里的全部数据映射成ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            // 使用GBK字符集来创建解码器
            Charset charset = StandardCharsets.UTF_8;
            outChannel.write(buffer); // 将整个ByteBuffer的全部数据写入一个输出FileChannel里，这就完成了文件的复制
            buffer.clear();
            CharsetDecoder decoder = charset.newDecoder();
            // 使用解码器将ByteBuffer转换成CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println(charBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
