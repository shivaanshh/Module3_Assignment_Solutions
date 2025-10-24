/**
 * Q06: Daemon thread prints "Auto-Save in progress..." every 3s while main simulates file processing.
 */
public class Q06_DaemonAutoSave {
    public static void main(String[] args) {
        Thread autoSave = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Auto-Save in progress...");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "AutoSaver");
        autoSave.setDaemon(true);
        autoSave.start();

        // Simulate file processing
        for (int i = 1; i <= 5; i++) {
            System.out.println("Processing file chunk " + i + "/5");
            try { Thread.sleep(1500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        System.out.println("Main work finished.");
    }
}
