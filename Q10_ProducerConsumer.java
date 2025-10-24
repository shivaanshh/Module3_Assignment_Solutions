/**
 * Q10: Producer-Consumer using wait/notify.
 */
import java.util.LinkedList;
import java.util.Queue;

public class Q10_ProducerConsumer {
    static class Buffer {
        private final Queue<Integer> q = new LinkedList<>();
        private final int capacity;
        Buffer(int capacity) { this.capacity = capacity; }

        public synchronized void produce(int value) throws InterruptedException {
            while (q.size() == capacity) wait();
            q.add(value);
            System.out.println("Produced: " + value);
            notifyAll();
        }
        public synchronized int consume() throws InterruptedException {
            while (q.isEmpty()) wait();
            int v = q.poll();
            System.out.println("Consumed: " + v);
            notifyAll();
            return v;
        }
    }
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        Thread producer = new Thread(() -> {
            try { for (int i=1;i<=20;i++) { buffer.produce(i); Thread.sleep(50);} }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread consumer = new Thread(() -> {
            try { for (int i=1;i<=20;i++) { buffer.consume(); Thread.sleep(100);} }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        producer.start(); consumer.start();
    }
}
