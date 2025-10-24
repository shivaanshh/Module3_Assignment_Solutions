/**
 * Q08: Inventory decrement using synchronized block.
 */
public class Q08_InventorySyncBlock {
    static class Inventory {
        private int stock;
        private final Object lock = new Object();
        public Inventory(int stock) { this.stock = stock; }
        public void purchase(int qty) {
            if (qty <= 0) return;
            synchronized (lock) {
                if (stock >= qty) {
                    stock -= qty;
                    System.out.println(Thread.currentThread().getName() + " purchased " + qty + ", left: " + stock);
                } else {
                    System.out.println("Insufficient stock for " + Thread.currentThread().getName() + ". left: " + stock);
                }
            }
        }
    }
    public static void main(String[] args) {
        Inventory inv = new Inventory(10);
        Runnable r = () -> { for (int i=0;i<5;i++) inv.purchase(3); };
        new Thread(r, "T1").start();
        new Thread(r, "T2").start();
    }
}
