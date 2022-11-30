package me.pcy.java8to11.completableFuture;

/**
 * Concurrent 소프트웨어란?
 *  동시에 여러 작업을 할 수 있는 소프트웨어
 */
public class CurrentThreadEx {

    public static void main(String[] args) throws InterruptedException {
        // 직접 Thread를 상속는 방법
        MyThread myThread = new MyThread();
        myThread.start();

        // Runnable을 구현하는 방법(람다)
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Thread: " + Thread.currentThread().getName());

                try {
                    // 현재 쓰레드 멈춰두기(sleep)
                    // sleep 실행 시, 다른 스레드에게 우선권이 넘어간다.
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!!");
                    return;
                }
            }
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());

        Thread.sleep(3000L);
        // 다른 쓰레드 깨우기(interrupt)
        // 다른 쓰레드를 깨워 interruptedException을 발생시킨다.
        thread.interrupt();

        myThread.join();
        System.out.println(myThread + " is finished");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }
    }

}
