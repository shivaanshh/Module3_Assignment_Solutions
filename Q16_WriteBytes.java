/**
 * Q16: Write "Java I/O Streams Example" to output.txt using FileOutputStream.
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Q16_WriteBytes {
    public static void main(String[] args) {
        String path = "output.txt";
        String text = "Java I/O Streams Example";
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(text.getBytes(StandardCharsets.UTF_8));
            System.out.println("Wrote to " + path);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
