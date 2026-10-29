import java.util.Scanner;

public class StringTrimCustom {

    public static int[] findTrimIndices(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1};
    }

    public static String createSubstring(String text, int start, int end) {
        if (start >= end) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
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
            System.out.print("Enter a string with leading/trailing spaces: ");
            String text = scanner.nextLine();

            int[] indices = findTrimIndices(text);
            String customTrimmed = createSubstring(text, indices[0], indices[1]);

            String builtInTrimmed = text.trim();

            boolean areEqual = compareStrings(customTrimmed, builtInTrimmed);

            System.out.println("\n--- String Trim Results ---");
            System.out.println("Original text:        \"" + text + "\"");
            System.out.println("Custom trimmed text:  \"" + customTrimmed + "\"");
            System.out.println("Built-in trimmed text:\"" + builtInTrimmed + "\"");
            System.out.println("Are both trimmed strings identical? " + areEqual);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
