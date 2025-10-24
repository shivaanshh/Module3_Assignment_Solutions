/**
 * Q27: Validate email using Pattern and Matcher.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q27_EmailRegex {
    private static final Pattern EMAIL = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    public static void main(String[] args) {
        String email = args.length > 0 ? args[0] : "user@example.com";
        Matcher m = EMAIL.matcher(email);
        System.out.println(email + " is " + (m.matches() ? "VALID" : "INVALID"));
    }
}
