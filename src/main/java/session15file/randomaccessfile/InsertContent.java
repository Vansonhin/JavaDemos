package session15file.randomaccessfile;

import java.io.*;

public class InsertContent {
    public static void main(String[] args) throws IOException {
        insert("src/main/java/session15file/randomaccessfile/InsertContent.java", 45, "插入的内容\r\n");
    }

    public static void insert(String fileName, long pos, String insertContent) throws IOException {
        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
             FileOutputStream tmpOut = new FileOutputStream(tmp);
             FileInputStream tmpIn = new FileInputStream(tmp)) {
            raf.seek(pos);
            byte[] buffer = new byte[64];
            int hasRead;
            while ((hasRead = raf.read(buffer)) > 0) {
                tmpOut.write(buffer, 0, hasRead);
            }
            raf.seek(pos);
            raf.write(insertContent.getBytes());
            while ((hasRead = tmpIn.read(buffer)) > 0) {
                raf.write(buffer, 0, hasRead);
            }
        }
    }
}
