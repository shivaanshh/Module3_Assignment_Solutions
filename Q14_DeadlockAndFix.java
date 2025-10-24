/**
 * Q14: Two threads acquire lock1 and lock2 in opposite order (deadlock), then a fixed version using tryLock with timeout.
 */
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Q14_DeadlockAndFix {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    static class Deadlocker extends Thread {
        private final Object first, second;
        Deadlocker(String name, Object first, Object second) { super(name); this.first = first; this.second = second; }
        @Override public void run() {
            synchronized (first) {
                System.out.println(getName() + " acquired first");
                try { Thread.sleep(100); } catch (InterruptedException e) { interrupt(); }
                synchronized (second) {
                    System.out.println(getName() + " acquired second");
                }
            }
        }
    }

    static class FixedWorker extends Thread {
        private final ReentrantLock a, b;
        FixedWorker(String name, ReentrantLock a, ReentrantLock b) { super(name); this.a = a; this.b = b; }
        @Override public void run() {
            try {
                while (true) {
                    if (a.tryLock(200, TimeUnit.MILLISECONDS)) {
                        try {
                            if (b.tryLock(200, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println(getName() + " acquired both safely");
                                    break;
                                } finally { b.unlock(); }
                            }
                        } finally { a.unlock(); }
                    }
                    Thread.sleep(50); // back off and retry
                }
            } catch (InterruptedException e) { interrupt(); }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Demonstrating potential deadlock (may hang for a moment):");
        Thread d1 = new Deadlocker("D1", lock1, lock2);
        Thread d2 = new Deadlocker("D2", lock2, lock1);
        d1.start(); d2.start();
        d1.join(500); d2.join(500);
        System.out.println("Now demonstrating fixed version:");
        ReentrantLock A = new ReentrantLock();
        ReentrantLock B = new ReentrantLock();
        Thread f1 = new FixedWorker("F1", A, B);
        Thread f2 = new FixedWorker("F2", B, A);
        f1.start(); f2.start();
        f1.join(); f2.join();
    }
}
