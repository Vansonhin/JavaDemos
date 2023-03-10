package session16thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // runAsync 需要异步操作且不关心返回值
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> System.out.println("hello!"));
        future1.get();

        // supplyAsync 关心返回值
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "hello!").thenApply(s -> s + "world");
        System.out.println(future2.get());

        // thenAccept 不需要从回调函数中获取返回结果
        // thenRun 不能访问异步计算的结果
        // thenApply 接受一个Function实例，用它来处理结果
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
