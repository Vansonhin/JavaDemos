package session15file.nio2;

import java.nio.file.*;

public class WatchServiceTest {
    public static void main(String[] args) throws Exception {
        // 获取文件系统的WatchService对象
        WatchService watchService = FileSystems.getDefault().newWatchService();
        // 为C:盘根路径注册监听
        Paths.get("C:").register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);
        while (true) {
            // 获取下一个事件变化
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.context() + "文件发生了" + event.kind() + "事件");
                // 重设watchKey
                boolean reset = key.reset();
                // 如果重设失败，退出监听
                if (!reset) {
                    break;
                }
            }
        }
    }
}
