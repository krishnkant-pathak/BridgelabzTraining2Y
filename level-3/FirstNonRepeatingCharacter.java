import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingCharacter(String text) {
        int[] frequencies = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequencies[(int) ch]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequencies[(int) ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            char firstNonRepeating = findFirstNonRepeatingCharacter(text);

            System.out.println("\n--- First Non-Repeating Character Result ---");
            if (firstNonRepeating != '\0') {
                System.out.println("First non-repeating character in \"" + text + "\" is: '" + firstNonRepeating + "'");
            } else {
                System.out.println("No non-repeating character found in \"" + text + "\".");
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
