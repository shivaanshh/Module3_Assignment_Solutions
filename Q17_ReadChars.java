/**
 * Q17: Read a file using FileReader and print contents.
 */
import java.io.FileReader;
import java.io.IOException;

public class Q17_ReadChars {
    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : "input.txt";
        try (FileReader fr = new FileReader(path)) {
            char[] buf = new char[4096];
            int n;
            while ((n = fr.read(buf)) != -1) {
                System.out.print(new String(buf, 0, n));
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
