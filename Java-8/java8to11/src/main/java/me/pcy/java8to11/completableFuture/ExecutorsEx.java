package me.pcy.java8to11.completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executors
 *  쓰레드처럼 저수준(Low-Level) API를 직접 다루는게 아니라
 *  쓰레드를 만들고 관리하는 작업을 고수준(High-Level) API에게 위임한다.
 */
public class ExecutorsEx {
    
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(getRunnable("Hello: "));
        executorService.submit(getRunnable("pcy: "));
        executorService.submit(getRunnable("The: "));
        executorService.submit(getRunnable("Java: "));
        executorService.submit(getRunnable("8: "));

        executorService.shutdown();     // 처리중인 작업 기다렸다 종료
//        executorService.shutdownNow();  // 즉시 종료

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(getRunnable("Hello Schedule"), 3, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
