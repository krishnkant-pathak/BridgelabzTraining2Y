import java.util.Scanner;

public class StringBuilderReverse {

    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(input);

        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string to reverse: ");
            String input = scanner.nextLine();

            String reversed = reverseString(input);

            System.out.println("Original String: \"" + input + "\"");
            System.out.println("Reversed String: \"" + reversed + "\"");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
