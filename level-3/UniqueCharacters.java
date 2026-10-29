import java.util.Scanner;

public class UniqueCharacters {

    public static int getStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static char[] findUniqueCharacters(String text) {
        int length = getStringLength(text);
        char[] tempUnique = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isDuplicate = false;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                tempUnique[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        char[] uniqueArray = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueArray[i] = tempUnique[i];
        }

        return uniqueArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            char[] uniqueChars = findUniqueCharacters(text);

            System.out.println("\n--- Unique Characters Result ---");
            System.out.println("Original text: \"" + text + "\"");
            System.out.println("Total Unique Characters: " + uniqueChars.length);
            System.out.print("Unique Characters: ");
            for (char ch : uniqueChars) {
                System.out.print("'" + ch + "' ");
            }
            System.out.println();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
