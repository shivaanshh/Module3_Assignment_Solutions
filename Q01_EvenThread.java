/**
 * Q01: Create a thread by extending Thread that prints even numbers 2..20 with 500ms delay.
 */
public class Q01_EvenThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 2; i <= 20; i += 2) {
                System.out.println(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted");
        }
    }

    public static void main(String[] args) {
        new Q01_EvenThread().start();
    }
}
