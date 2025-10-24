/**
 * Q02: Create a thread by implementing Runnable that reverses "MULTITHREADING" and prints chars one by one.
 */
public class Q02_ReverseRunnable implements Runnable {
    private final String text = "MULTITHREADING";

    @Override
    public void run() {
        for (int i = text.length() - 1; i >= 0; i--) {
            System.out.println(text.charAt(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Q02_ReverseRunnable());
        t.start();
    }
}
