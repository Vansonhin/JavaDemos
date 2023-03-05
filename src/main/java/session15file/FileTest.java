package session15file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileTest {
    public static void main(String[] args) throws IOException {
        // 以当前路径创建一个File对象
        File file = new File("."); // directory
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsoluteFile().getParent());
        File tmpFile = File.createTempFile("aaa", ".txt", file);
        tmpFile.deleteOnExit();
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println("newFile对象是否存在: " + newFile.exists());
//        System.out.println(newFile.createNewFile());
        System.out.println(newFile.mkdir());
        String[] fileList = file.list();
        System.out.println("====当前路径下所有的文件和路径如下====");
        for (String s : fileList) {
            System.out.println(s);
        }
        File[] roots = File.listRoots();
        System.out.println("====系统所有根路径如下====");
        for (File root : roots) {
            System.out.println(root);
        }
    }
}
