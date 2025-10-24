/**
 * Q22: Copy contents of one file to another using byte streams.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q22_CopyFile {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java Q22_CopyFile <source> <dest>");
            return;
        }
        String src = args[0], dst = args[1];
        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) != -1) {
                out.write(buf, 0, n);
            }
            System.out.println("Copied " + src + " -> " + dst);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
