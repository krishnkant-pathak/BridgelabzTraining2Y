import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {

    public static void generateException(String text) {
        int invalidIndex = text.length() + 5;
        System.out.println("Character at index " + invalidIndex + ": " + text.charAt(invalidIndex));
    }

    public static void handleException(String text) {
        try {
            int invalidIndex = text.length() + 5;
            System.out.println("Attempting to access character at index " + invalidIndex + " (length: " + text.length() + ")...");
            System.out.println("Character at index " + invalidIndex + ": " + text.charAt(invalidIndex));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.toString());
            System.out.println("Index is outside the valid range (0 to " + (text.length() - 1) + ").");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String text = scanner.next();

            System.out.println("\n=== Demonstrating StringIndexOutOfBoundsException Handling ===");
            handleException(text);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
