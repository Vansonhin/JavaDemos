package session15file.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get(".");
        System.out.println("path里包含的路径数量：" + path.getNameCount());
        System.out.println("path的根路径：" + path.getRoot()); // 相对路径的根路径 null
        Path absolutePath = path.toAbsolutePath();
        System.out.println(absolutePath);
        System.out.println("absolutePath的根路径：" + absolutePath.getRoot());
        System.out.println("absolutePath里包含的路径数量：" + absolutePath.getNameCount());
        for (Path value : absolutePath) {
            System.out.println(value);
        }
        Path path1 = Paths.get("g:", "publish", "codes");
        System.out.println(path1.getNameCount());
    }
}
