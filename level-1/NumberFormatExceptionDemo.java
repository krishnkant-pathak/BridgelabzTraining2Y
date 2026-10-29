import java.util.Scanner;

public class NumberFormatExceptionDemo {

    public static void generateException(String text) {
        int parsedNumber = Integer.parseInt(text);
        System.out.println("Parsed number: " + parsedNumber);
    }

    public static void handleException(String text) {
        try {
            System.out.println("Attempting to parse \"" + text + "\" to an integer...");
            int parsedNumber = Integer.parseInt(text);
            System.out.println("Successfully parsed number: " + parsedNumber);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
            System.out.println("The input text is not a valid integer format.");
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter text (e.g. non-numeric string like 'abc' or '123a'): ");
            String text = scanner.next();

            System.out.println("\n=== Demonstrating NumberFormatException Handling ===");
            handleException(text);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
