/**
 * Q15: Read a text file using FileInputStream and print contents.
 */
import java.io.FileInputStream;
import java.io.IOException;

public class Q15_ReadBytes {
    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : "input.txt";
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] buf = new byte[4096];
            int n;
            while ((n = fis.read(buf)) != -1) {
                System.out.print(new String(buf, 0, n));
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
