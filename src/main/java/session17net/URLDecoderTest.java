package session17net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class URLDecoderTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("疯狂Android讲义", StandardCharsets.UTF_8);
        System.out.println(encode);
        System.out.println(URLDecoder.decode(encode, StandardCharsets.UTF_8));
    }
}
