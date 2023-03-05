package session16thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // runAsync
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> System.out.println("hello!"));
        future1.get();

        // supplyAsync
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "hello!").thenApply(s -> s + "world");
        System.out.println(future2.get());

        // thenAccept & thenRun
        CompletableFuture.completedFuture("hello").thenAccept(System.out::println);
        CompletableFuture.completedFuture("hello").thenApply(s -> s + " world").thenRun(() -> System.out.println("fuck no"));

        // handle
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Computation error!");
            }
            return "hello";
        }).handle((res, ex) -> {
            System.out.println(ex);
            return res != null ? res : "world";
        });
        System.out.println(future3.get());

        // 组合 CompletableFuture
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> "hello!")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "world!"));
        System.out.println(future4.get());
    }
}
