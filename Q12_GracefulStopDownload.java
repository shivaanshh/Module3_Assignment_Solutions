/**
 * Q12: Simulate file download; allow graceful stop via flag.
 */
public class Q12_GracefulStopDownload {
    static class Downloader extends Thread {
        private volatile boolean running = true;
        public void stopDownloading() { running = false; this.interrupt(); }
        @Override public void run() {
            int chunk = 1;
            while (running && chunk <= 20) {
                System.out.println("Downloading chunk " + chunk++);
                try { Thread.sleep(200); } catch (InterruptedException e) { /* allow exit */ }
            }
            System.out.println("Downloader finished.");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Downloader d = new Downloader();
        d.start();
        Thread.sleep(1500);
        d.stopDownloading();
    }
}
