/**
 * Q13: Counter increment with and without ReentrantLock.
 */
import java.util.concurrent.locks.ReentrantLock;

public class Q13_ReentrantLockCounter {
    static class CounterNoLock {
        int value = 0;
        void inc() { value++; }
    }
    static class CounterWithLock {
        int value = 0;
        private final ReentrantLock lock = new ReentrantLock();
        void inc() {
            lock.lock();
            try { value++; } finally { lock.unlock(); }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CounterNoLock a = new CounterNoLock();
        CounterWithLock b = new CounterWithLock();

        Runnable r1 = () -> { for (int i=0;i<100000;i++) a.inc(); };
        Runnable r2 = () -> { for (int i=0;i<100000;i++) b.inc(); };

        Thread[] t1 = { new Thread(r1), new Thread(r1), new Thread(r1), new Thread(r1) };
        Thread[] t2 = { new Thread(r2), new Thread(r2), new Thread(r2), new Thread(r2) };
        for (Thread t : t1) t.start();
        for (Thread t : t2) t.start();
        for (Thread t : t1) t.join();
        for (Thread t : t2) t.join();

        System.out.println("NoLock value (expected < 400000 due to race): " + a.value);
        System.out.println("WithLock value (expected 400000): " + b.value);
    }
}
