/**
 * Q26: Use Date and Calendar to display current date/time.
 */
import java.util.Date;
import java.util.Calendar;

public class Q26_DateCalendarDemo {
    public static void main(String[] args) {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        System.out.println("Date: " + now);
        System.out.printf("Calendar: %04d-%02d-%02d %02d:%02d:%02d%n",
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
    }
}
