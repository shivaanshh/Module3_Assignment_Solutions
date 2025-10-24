/**
 * Q23: Delete a file using File class.
 */
import java.io.File;

public class Q23_DeleteFile {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java Q23_DeleteFile <path>");
            return;
        }
        File f = new File(args[0]);
        if (!f.exists()) {
            System.err.println("File not found: " + f.getAbsolutePath());
            return;
        }
        if (f.delete()) {
            System.out.println("Deleted: " + f.getAbsolutePath());
        } else {
            System.err.println("Failed to delete: " + f.getAbsolutePath());
        }
    }
}
