package session15file.nio2;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.List;

public class AttributeViewTest {
    public static void main(String[] args) throws Exception {
        Path testPath = Paths.get("src/main/java/session15file/nio2/AttributeViewTest.java");
        BasicFileAttributeView basicView = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = basicView.readAttributes();
        System.out.println("创建时间：" + basicFileAttributes.creationTime().toMillis());
        System.out.println("最后访问时间：" + basicFileAttributes.lastAccessTime().toMillis());
        System.out.println("最后修改时间: " + basicFileAttributes.lastModifiedTime().toMillis());
        System.out.println("文件大小：" + basicFileAttributes.size());
        // 获取访问文件属主信息的
        FileOwnerAttributeView ownerView = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);
        System.out.println(ownerView.getOwner());
//        UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("guest");
        // 修改用户
//        ownerView.setOwner(user);
        // 获取访问自定义属性的
        UserDefinedFileAttributeView userView = Files.getFileAttributeView(testPath, UserDefinedFileAttributeView.class);
        List<String> list = userView.list();
        for (String s : list) {
            ByteBuffer buffer = ByteBuffer.allocate(userView.size(s));
            userView.read(s, buffer);
            buffer.flip();
            String value = Charset.defaultCharset().decode(buffer).toString();
            System.out.println(s + "-->" + value);
        }
        userView.write("发行者", Charset.defaultCharset().encode("郑文轩牛逼"));
        // 获取访问DOS属性的
        DosFileAttributeView dosView = Files.getFileAttributeView(testPath, DosFileAttributeView.class);
//        dosView.setHidden(true);
//        dosView.setReadOnly(true);
    }
}
