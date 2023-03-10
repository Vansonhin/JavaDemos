package session17net.httpclient;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class AsyncTest {
    public static void main(String[] args) throws InterruptedException {
        CookieHandler.setDefault(new CookieManager());
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .cookieHandler(CookieHandler.getDefault())
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080"))
                .GET()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(resp -> new Object[] {resp.statusCode(), resp.body()})
                .thenAccept(rt -> {
                    System.out.println("statusCode: " + rt[0]);
                    System.out.println("body: " + rt[1]);
                });
        System.out.println("--程序结束--");
        Thread.sleep(1000);
    }
}
