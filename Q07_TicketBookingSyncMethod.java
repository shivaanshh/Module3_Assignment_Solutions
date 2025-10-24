/**
 * Q07: Ticket booking with synchronized method to prevent overselling.
 */
public class Q07_TicketBookingSyncMethod {
    static class TicketCounter {
        private int available;
        public TicketCounter(int available) { this.available = available; }

        public synchronized boolean book(String who, int qty) {
            if (qty <= 0) return false;
            if (available >= qty) {
                System.out.println(who + " booking " + qty + " ticket(s)...");
                available -= qty;
                System.out.println("Booked for " + who + ". Remaining: " + available);
                return true;
            } else {
                System.out.println("Not enough tickets for " + who + ". Requested: " + qty + ", Remaining: " + available);
                return false;
            }
        }
    }

    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter(5);
        Runnable r = () -> counter.book(Thread.currentThread().getName(), 3);
        Thread t1 = new Thread(r, "Alice");
        Thread t2 = new Thread(r, "Bob");
        t1.start(); t2.start();
    }
}
