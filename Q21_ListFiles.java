/**
 * Q21: List all files in a user-specified directory; handle exceptions.
 */
import java.io.File;

public class Q21_ListFiles {
    public static void main(String[] args) {
        String dirPath = args.length > 0 ? args[0] : ".";
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Invalid directory: " + dirPath);
            return;
        }
        File[] files = dir.listFiles();
        if (files == null) {
            System.err.println("Unable to list files.");
            return;
        }
        for (File f : files) {
            System.out.println((f.isDirectory() ? "[DIR] " : "[FILE] ") + f.getName());
        }
    }
}
