package session17net;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressTest {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println(ip.isReachable(5000));
        System.out.println(ip.getHostAddress());

        InetAddress byAddress = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        System.out.println(byAddress.getHostName());
        System.out.println(byAddress.getCanonicalHostName());
    }
}
