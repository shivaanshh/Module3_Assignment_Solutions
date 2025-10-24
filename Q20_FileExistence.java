/**
 * Q20: Check if a file exists; if not, create it.
 */
import java.io.File;
import java.io.IOException;

public class Q20_FileExistence {
    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : "newfile.txt";
        File f = new File(path);
        if (f.exists()) {
            System.out.println("File exists: " + f.getAbsolutePath());
        } else {
            try {
                if (f.createNewFile()) {
                    System.out.println("Created: " + f.getAbsolutePath());
                } else {
                    System.out.println("Could not create file.");
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
