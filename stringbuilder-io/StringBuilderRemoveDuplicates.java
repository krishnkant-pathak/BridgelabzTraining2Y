import java.util.HashSet;
import java.util.Scanner;

public class StringBuilderRemoveDuplicates {

    public static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        HashSet<Character> seenCharacters = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!seenCharacters.contains(ch)) {
                seenCharacters.add(ch);
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            String uniqueString = removeDuplicates(input);

            System.out.println("Original String:             \"" + input + "\"");
            System.out.println("String Without Duplicates:   \"" + uniqueString + "\"");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
