package session15file.nio2;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTest {
    public static void main(String[] args) throws Exception {
        Files.walkFileTree(Paths.get("E:", "IdeaProject", "CrazyJavaMaven"), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                System.out.println("正在访问" + file + "文件");
                if (file.endsWith("FileVisitorTest.java")) {
                    System.out.println("--找到文件--");
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                System.out.println("正在访问" + dir + "路径");
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
