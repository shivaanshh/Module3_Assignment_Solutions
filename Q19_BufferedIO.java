/**
 * Q19: Use BufferedReader and BufferedWriter for improved performance.
 */
import java.io.*;

public class Q19_BufferedIO {
    public static void main(String[] args) {
        String inPath = args.length > 0 ? args[0] : "input.txt";
        String outPath = args.length > 1 ? args[1] : "buffered_output.txt";

        // Write using BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {
            bw.write("Line 1\n");
            bw.write("Line 2\n");
            bw.write("Line 3\n");
        } catch (IOException e) {
            System.err.println("Write error: " + e.getMessage());
        }

        // Read using BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(inPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Read error: " + e.getMessage());
        }
    }
}
