/**
 * Q11: Two threads print numbers 1..20 alternately using wait/notify.
 */
public class Q11_AlternateOddEven {
    static class Coordinator {
        private int current = 1;
        public synchronized void printOdd() throws InterruptedException {
            while (current <= 20) {
                while (current % 2 == 0) wait();
                System.out.println("Odd: " + current++);
                notifyAll();
            }
        }
        public synchronized void printEven() throws InterruptedException {
            while (current <= 20) {
                while (current % 2 == 1) wait();
                System.out.println("Even: " + current++);
                notifyAll();
            }
        }
    }
    public static void main(String[] args) {
        Coordinator c = new Coordinator();
        Thread odd = new Thread(() -> { try { c.printOdd(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        Thread even = new Thread(() -> { try { c.printEven(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); } });
        odd.start(); even.start();
    }
}
