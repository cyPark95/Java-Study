package encapsulation;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class StopWatch {

    public void time() {
        Timer t = new Timer();
        t.start();

        // ...

        t.stop();

        long time = t.elaspedTime(NANOSECONDS);
    }

    private static class Timer {
        public long startTime;
        public long stopTime;

        public void start() {
            startTime = System.nanoTime();
        }

        public void stop() {
            stopTime = System.nanoTime();
        }

        public long elaspedTime(TimeUnit unit) {
            switch (unit) {
                case MILLISECONDS:
                    return (stopTime - startTime) / 10;
                case NANOSECONDS:
                    return (stopTime - startTime);
                default:
                    return 0;
            }
        }
    }

}
