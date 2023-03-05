package session15file.nio2;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("src/main/java/session15file/nio2/FilesTest.java");
        Files.copy(path, new FileOutputStream("src/main/java/session15file/nio2/a.txt"));
        System.out.println("FilesTest.java是否为隐藏文件：" + Files.isHidden(path));
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println(lines);
        System.out.println("FilesTest.java的大小为：" + Files.size(path));
        List<String> poem = new ArrayList<>(2) {{
            add("水晶");
            add("清风");
        }};
        Files.write(Paths.get("src/main/java/session15file/nio2/poem.txt"), poem, StandardCharsets.UTF_8);
        Files.list(Paths.get(".")).forEach(System.out::println);
        Files.lines(path, StandardCharsets.UTF_8).forEach(System.out::println);
        FileStore store = Files.getFileStore(Paths.get("C:"));
        // 判断c盘的总空间和可用空间
        System.out.println("c盘总空间:" + store.getTotalSpace());
        System.out.println("c盘可用空间:" + store.getUsableSpace());
    }
}
