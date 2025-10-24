/**
 * Q25: Demonstrate Math.random(), Math.abs(), Math.pow().
 */
public class Q25_JavaLangMathDemo {
    public static void main(String[] args) {
        double r = Math.random();
        int absVal = Math.abs(-42);
        double powVal = Math.pow(2, 10);
        System.out.println("random(): " + r);
        System.out.println("abs(-42): " + absVal);
        System.out.println("pow(2,10): " + powVal);
    }
}
