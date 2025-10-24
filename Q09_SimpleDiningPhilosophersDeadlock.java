/**
 * Q09: Deadlock with two philosophers and two chopsticks.
 * WARNING: This intentionally may deadlock.
 */
public class Q09_SimpleDiningPhilosophersDeadlock {
    static class Chopstick { }
    static class Philosopher extends Thread {
        private final Chopstick left, right;
        Philosopher(String name, Chopstick left, Chopstick right) { super(name); this.left = left; this.right = right; }
        @Override public void run() {
            synchronized (left) {
                System.out.println(getName() + " picked LEFT");
                try { Thread.sleep(200); } catch (InterruptedException e) { interrupt(); }
                synchronized (right) {
                    System.out.println(getName() + " picked RIGHT");
                    System.out.println(getName() + " eating");
                }
            }
        }
    }
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick();
        Chopstick c2 = new Chopstick();
        new Philosopher("P1", c1, c2).start();
        new Philosopher("P2", c2, c1).start(); // Opposite order -> potential deadlock
    }
}
