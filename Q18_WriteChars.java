/**
 * Q18: Write a string to example.txt using FileWriter.
 */
import java.io.FileWriter;
import java.io.IOException;

public class Q18_WriteChars {
    public static void main(String[] args) {
        String path = "example.txt";
        String text = "Writing to a file using FileWriter.";
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(text);
            System.out.println("Wrote to " + path);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
