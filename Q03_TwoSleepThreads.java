/**
 * Q03: Two threads. T1 prints "Thread 1" every 1s, T2 prints "Thread 2" every 2s.
 */
public class Q03_TwoSleepThreads {
    static class Printer extends Thread {
        private final String label;
        private final long periodMs;
        Printer(String label, long periodMs) { this.label = label; this.periodMs = periodMs; }
        @Override public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(label);
                    Thread.sleep(periodMs);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public static void main(String[] args) {
        new Printer("Thread 1", 1000).start();
        new Printer("Thread 2", 2000).start();
    }
}
