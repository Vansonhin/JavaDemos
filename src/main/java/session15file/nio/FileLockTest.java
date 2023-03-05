package session15file.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
    public static void main(String[] args) throws Exception {
        try (FileChannel channel = new FileOutputStream("src/main/java/session15file/nio/a.txt").getChannel()) {
            FileLock lock = channel.tryLock();
            Thread.sleep(10000);
            lock.release();
        }
    }
}
