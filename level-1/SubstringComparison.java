import java.util.Scanner;

public class SubstringComparison {

    public static String createSubstring(String text, int startIndex, int endIndex) {
        StringBuilder substringBuilder = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            substringBuilder.append(text.charAt(i));
        }
        return substringBuilder.toString();
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String text = scanner.next();

            System.out.print("Enter start index: ");
            int startIndex = scanner.nextInt();

            System.out.print("Enter end index: ");
            int endIndex = scanner.nextInt();

            if (startIndex < 0 || endIndex > text.length() || startIndex > endIndex) {
                System.err.println("Invalid indices! Ensure 0 <= start <= end <= length.");
                return;
            }

            String customSubstring = createSubstring(text, startIndex, endIndex);

            String builtInSubstring = text.substring(startIndex, endIndex);

            boolean areEqual = compareStrings(customSubstring, builtInSubstring);

            System.out.println("\n--- Substring Results ---");
            System.out.println("Custom substring: \"" + customSubstring + "\"");
            System.out.println("Built-in substring: \"" + builtInSubstring + "\"");
            System.out.println("Are both substrings equal? " + areEqual);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
