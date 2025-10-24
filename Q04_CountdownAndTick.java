/**
 * Q04: One thread prints countdown 10..1 (1s delay); another prints "Tick..." every 500ms simultaneously.
 */
public class Q04_CountdownAndTick {
    public static void main(String[] args) {
        Thread countdown = new Thread(() -> {
            try {
                for (int i = 10; i >= 1; i--) {
                    System.out.println("Countdown: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread ticker = new Thread(() -> {
            try {
                for (int i = 0; i < 22; i++) {
                    System.out.println("Tick...");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        countdown.start();
        ticker.setDaemon(true); // so program can exit after countdown completes
        ticker.start();
    }
}
