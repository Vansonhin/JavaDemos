package session17net.proxy;


import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class ProxyTest {
    public void init() throws IOException {
        String URL_STR = "http://www.crazyit.org";
        URL url = new URL(URL_STR);
        String PROXY_ADDR = "129.82.12.188";
        int PROXY_PORT = 3124;
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_ADDR, PROXY_PORT));
        URLConnection conn = url.openConnection(proxy);
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
        new ProxyTest().init();
    }
}
