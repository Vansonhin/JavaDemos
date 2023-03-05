package session15file.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {
    public static void main(String[] args) {
        File f = new File("src/main/java/session15file/nio/a.txt");
        try (RandomAccessFile raf = new RandomAccessFile(f, "rw");
             FileChannel randomChannel = raf.getChannel()) {
            MappedByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            randomChannel.position(f.length());
            randomChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
