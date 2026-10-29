import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    public static String customSubstring(String text, int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Start index (" + start + ") cannot be greater than End index (" + end + ").");
        }
        return text.substring(start, end);
    }

    public static void generateException(String text) {
        int start = 4;
        int end = 1;
        System.out.println("Substring: " + customSubstring(text, start, end));
    }

    public static void handleException(String text) {
        int start = 4;
        int end = 1;
        try {
            System.out.println("Attempting to get substring with start index (" + start + ") > end index (" + end + ")...");
            System.out.println("Substring: " + customSubstring(text, start, end));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String text = scanner.next();

            System.out.println("\n=== Demonstrating IllegalArgumentException Handling ===");
            handleException(text);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
