/**
 * Q24: Use RandomAccessFile to write at beginning, then overwrite part.
 */
import java.io.IOException;
import java.io.RandomAccessFile;

public class Q24_RandomAccessFileDemo {
    public static void main(String[] args) {
        String path = "raf_demo.dat";
        try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
            raf.setLength(0);
            raf.writeUTF("HelloWorld");
            // Overwrite "World" with "Java"
            raf.seek(2); // move near beginning just to demonstrate
            raf.writeUTF("JAVA");
            raf.seek(0);
            // Read content (note: UTF uses length-prefix; we read what we wrote)
            raf.seek(0);
            String first = raf.readUTF();
            System.out.println("Read back: " + first);
        } catch (IOException e) {
            System.err.println("IO error: " + e.getMessage());
        }
    }
}
