/**
 * Q05: Create three threads Worker-1/2/3 with different priorities and print messages.
 * Note: Priority is a hint; JVM may not strictly order by it.
 */
public class Q05_NamingAndPriority {
    static class Worker extends Thread {
        Worker(String name, int priority) { super(name); setPriority(priority); }
        @Override public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Running " + getName() + " (priority=" + getPriority() + ") step " + i);
                try { Thread.sleep(100); } catch (InterruptedException e) { interrupt(); }
            }
        }
    }
    public static void main(String[] args) {
        Thread w1 = new Worker("Worker-1", Thread.MIN_PRIORITY);
        Thread w2 = new Worker("Worker-2", Thread.NORM_PRIORITY);
        Thread w3 = new Worker("Worker-3", Thread.MAX_PRIORITY);
        w1.start(); w2.start(); w3.start();
    }
}
