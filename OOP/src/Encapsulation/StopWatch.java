package Encapsulation;

public class StopWatch {

    public void time() {
        Timer t = new Timer();
        t.startTime = System.currentTimeMillis();

        // ...

        t.stopTime = System.currentTimeMillis();

        long elaspedTime = t.stopTime - t.startTime;
    }

    private static class Timer {
        public long startTime;
        public long stopTime;
    }

}
