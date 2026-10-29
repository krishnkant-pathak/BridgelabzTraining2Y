import java.util.Scanner;

public class StringToLowerCase {

    public static String convertToLowerCase(String text) {
        StringBuilder lowerText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                lowerText.append((char) (ch + 32));
            } else {
                lowerText.append(ch);
            }
        }
        return lowerText.toString();
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
            System.out.print("Enter complete text: ");
            String text = scanner.nextLine();

            String customLowerCase = convertToLowerCase(text);

            String builtInLowerCase = text.toLowerCase();

            boolean areEqual = compareStrings(customLowerCase, builtInLowerCase);

            System.out.println("\n--- Lowercase Conversion Results ---");
            System.out.println("Original text: " + text);
            System.out.println("Custom lowercase: " + customLowerCase);
            System.out.println("Built-in lowercase: " + builtInLowerCase);
            System.out.println("Are both lowercase strings identical? " + areEqual);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
