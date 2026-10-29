import java.util.Scanner;

public class StringToUpperCase {

    public static String convertToUpperCase(String text) {
        StringBuilder upperText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                upperText.append((char) (ch - 32));
            } else {
                upperText.append(ch);
            }
        }
        return upperText.toString();
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

            String customUpperCase = convertToUpperCase(text);

            String builtInUpperCase = text.toUpperCase();

            boolean areEqual = compareStrings(customUpperCase, builtInUpperCase);

            System.out.println("\n--- Uppercase Conversion Results ---");
            System.out.println("Original text: " + text);
            System.out.println("Custom uppercase: " + customUpperCase);
            System.out.println("Built-in uppercase: " + builtInUpperCase);
            System.out.println("Are both uppercase strings identical? " + areEqual);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
