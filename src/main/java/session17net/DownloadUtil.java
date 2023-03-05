package session17net;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class DownloadUtil {
    private final String path;
    private final String targetFile;
    private final int threadNum;
    private final DownloadThread[] threads;
    private int fileSize;

    public DownloadUtil(String path, String targetFile, int threadNum) {
        this.path = path;
        this.targetFile = targetFile;
        this.threadNum = threadNum;
        this.threads = new DownloadThread[threadNum];
    }

    public void download() throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept",
                "image/gif, image/jpeg, image/pjpeg, image/jpg");
        conn.setRequestProperty("Accept-language", "zh-CN");
        conn.setRequestProperty("Charset", "UTF-8");
        conn.setRequestProperty("Connection", "Keep-Alive");
        // 得到文件大小
        fileSize = conn.getContentLength();
        Map<String, List<String>> headerFields = conn.getHeaderFields();
        headerFields.entrySet().forEach(entry -> System.out.println(entry.getKey() + " ---> " + entry.getValue()));
        conn.disconnect();
        int currentPartSize = fileSize / threadNum + 1;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
        // 设置本地文件大小
        file.setLength(fileSize);
        file.close();
        for (int i = 0; i < threadNum; i++) {
            int startPos = i * currentPartSize;
            RandomAccessFile currentPart = new RandomAccessFile(targetFile, "rw");
            currentPart.seek(startPos);
            threads[i] = new DownloadThread(startPos, currentPartSize, currentPart);
            threads[i].start();
        }
    }

    public double getCompleteRate() {
        int sumSize = 0;
        for (int i = 0; i < threadNum; i++) {
            sumSize += threads[i].length;
        }
        return sumSize * 1.0 / fileSize;
    }

    @RequiredArgsConstructor
    private class DownloadThread extends Thread {
        @NonNull
        private int startPos;
        @NonNull
        private int currentPartSize;
        @NonNull
        private RandomAccessFile currentPart;
        public int length;

        @Override
        public void run() {
            try {
                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5 * 1000);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept",
                        "image/gif, image/jpeg, image/pjpeg, image/jpg");
                conn.setRequestProperty("Accept-language", "zh-CN");
                conn.setRequestProperty("Charset", "UTF-8");
                InputStream inputStream = conn.getInputStream();
                inputStream.skip(startPos);
                byte[] buffer = new byte[1024];
                int hasRead;
                while (length < currentPartSize && ((hasRead = inputStream.read(buffer)) != -1)) {
                    currentPart.write(buffer, 0, hasRead);
                    length += hasRead;
                }
                currentPart.close();
                inputStream.close();
                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String path = "https://ww3.sinaimg.cn/bmiddle/9150e4e5ly1fk3or4cspxg207307374v.gif";

        final DownloadUtil downloadUtil = new DownloadUtil(path, "aini.jpg", 4);
        downloadUtil.download();
        new Thread(() -> {
            while (downloadUtil.getCompleteRate() < 1) {
                System.out.println("已完成: " + downloadUtil.getCompleteRate());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
