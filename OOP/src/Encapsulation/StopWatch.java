package Encapsulation;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class StopWatch {

    public void time() {
        Timer t = new Timer();
        t.start();

        // ...

        t.stop();

        long time = t.elaspedTime(MILLISECONDS);
    }

    private static class Timer {
        public long startTime;
        public long stopTime;

        public void start() {
            startTime = System.currentTimeMillis();
        }

        public void stop() {
            stopTime = System.currentTimeMillis();
        }

        public long elaspedTime(TimeUnit unit) {
            switch (unit) {
                case MILLISECONDS:
                    return stopTime - startTime;
                default:
                    return 0;
            }
        }
    }

}
