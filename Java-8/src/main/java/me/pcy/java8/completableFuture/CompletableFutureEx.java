package me.pcy.java8.completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * CompletableFuture
 *  - Future는 get() 메서드를 호출하기고, 완료되기 전까지 아무것도 할 수 없는 블로킹 콜이다.
 *  - 외부에서 명시적으로 완료시킬 수 있다.
 *  - CompletableFuture를 사용하면, 명시적으로 Executor를 만들어서 사용하지 않아도 된다.
 */
public class CompletableFutureEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = new CompletableFuture<>();
        future1.complete("future1");
        System.out.println("future1 = " + future1.get());

        CompletableFuture<String> future2 = CompletableFuture.completedFuture("future2");
        System.out.println("future2 = " + future2.get());

        // 리턴타입이 없는경우
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println("Hello runAsync " + Thread.currentThread().getName());
        }).thenRun(() -> {  // Consumer
            System.out.println("thenRun");
        });
        runAsync.get();


        // 리턴타입이 있는경우
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello supplyAsync " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply(s -> {  // Function
            System.out.println("thenApply: String Upper Case");
            return s.toUpperCase();
        });
        System.out.println("supplyAsync = " + supplyAsync.get());


        // 두 작업 조합하기
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        // 두 Future간에 의존성이 있는 경우
        // hello 먼저 실행 후 world가 이어서 실행
        CompletableFuture<String> future = hello.thenCompose(CompletableFutureEx::getWorld);
        System.out.println("future = " + future.get());

        // 서로 연관관계가 없는 경우
        // hello와 future 모두 독립적으로 실행하고, 둘 다 종료했을 때 콜백 실행
        CompletableFuture<String> combine = hello.thenCombine(future, (h, f) -> h + " " + f);
        System.out.println("combine = " + combine.get());

        // hello와 future 모두 실행하고 각 작업 결과에 콜백 실행
        List<CompletableFuture> futures = Arrays.asList(hello, future);
        CompletableFuture[] futureArray = futures.toArray(new CompletableFuture[futures.size()]);

        CompletableFuture<List<Object>> results = CompletableFuture.allOf(futureArray)
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)  // join과 get은 결과는 동일하지만 UnCheckedException 발생
                        .collect(Collectors.toList()));

        results.get().forEach(System.out::println);

        // hello와 future 중 가장 빨리 끝난 하나의 결과에 콜백 실행
        CompletableFuture<Void> anyOf = CompletableFuture.anyOf(hello, future).thenAccept(System.out::println);
        anyOf.get();


        // 예외처리
        boolean throwError = true;
        CompletableFuture<String> exceptionally = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalStateException();
            }

            System.out.println("throwError = " + throwError);
            return "Exception";
        }).exceptionally(ex -> {
            System.out.println("ex = " + ex);
            return "Error!";
        });
        System.out.println("exceptionally = " + exceptionally.get());

        CompletableFuture<String> handle = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalStateException();
            }

            System.out.println("throwError = " + throwError);
            return "Exception";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "Error";
            }

            return result;
        });
        System.out.println("handle = " + handle.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }
}
