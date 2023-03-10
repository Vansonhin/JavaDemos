package session17net.proxy;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProxySelectorTest {
    public void init() throws IOException {
        String proxyAddr = "139.92.12.188";
        int proxyPort = 3124;
        String urlStr = "http://www.crazyit.org";
        ProxySelector.setDefault(new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                List<Proxy> result = new ArrayList<>();
                result.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyAddr, proxyPort)));
                return result;
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                System.out.println("无法连接到指定代理服务器！");
            }
        });
        URL url = new URL(urlStr);
        URLConnection conn = url.openConnection();
        conn.setConnectTimeout(3000);
        try (Scanner scanner = new Scanner(conn.getInputStream());
             PrintStream ps = new PrintStream("index.htm")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                ps.println(line);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ProxySelectorTest().init();
    }
}
