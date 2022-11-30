package me.pcy.java8to11.completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Callable
 *  Runnable과 유사하지만 Return 값을 가질 수 있다.
 * Future
 *  비동기적인 작업의 현재 상태를 조회하거나 결과를 가져올 수 있다.
 */
public class CallableAndFutureEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);

        // 작업 상태 확인
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

        // 작업 취소하기
//        helloFuture.cancel(true);  // true: 현재 진행중인 쓰레드를 Interrupt
                                   // false: 현재 진행중인 작업이 끝날때까지 기다림

        // 결과 가져오기
        String str = helloFuture.get();  // 블로킹 콜
        System.out.println("str = " + str);

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> pcy = () -> {
            Thread.sleep(1000L);
            return "pcy";
        };

        // 여러 작업 동시에 실행하기
        // 동시에 실행한 작업 중에 제일 오래 걸리는 작업만큼 시간이 걸린다.
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(java, pcy));
        for (Future<String> future : futures) {
            System.out.println("future = " + future.get());
        }

        // 여러 작업 중 하나라도 먼저 응답이 오면 끝내기
        // 동시에 실행한 작업 중 제일 짧게 걸리는 작업 만큼 시간이 걸린다.
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        String any = threadPool.invokeAny(Arrays.asList(java, pcy));
        System.out.println("any = " + any);

        System.out.println("End!");
        executorService.shutdown();
    }
}
