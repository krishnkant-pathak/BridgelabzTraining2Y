import java.util.Scanner;

public class PalindromeCheck {

    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static char[] reverseString(String text) {
        int length = text.length();
        char[] reversed = new char[length];
        for (int i = 0; i < length; i++) {
            reversed[i] = text.charAt(length - 1 - i);
        }
        return reversed;
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            boolean result1 = isPalindromeIterative(text);
            boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);
            boolean result3 = isPalindromeArrayReversal(text);

            System.out.println("\n--- Palindrome Check Results ---");
            System.out.println("Input Text: \"" + text + "\"");
            System.out.println("Logic 1 (Iterative Two-Pointer):   " + (result1 ? "PALINDROME" : "NOT A PALINDROME"));
            System.out.println("Logic 2 (Recursive Method):        " + (result2 ? "PALINDROME" : "NOT A PALINDROME"));
            System.out.println("Logic 3 (Array Reversal Method):   " + (result3 ? "PALINDROME" : "NOT A PALINDROME"));

            if (result1 && result2 && result3) {
                System.out.println("\nConclusion: The text is a valid Palindrome!");
            } else {
                System.out.println("\nConclusion: The text is NOT a Palindrome.");
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
