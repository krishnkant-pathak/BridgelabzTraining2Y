import java.util.Scanner;

public class CharacterFrequencyUnique {

    public static char[] getUniqueCharacters(String text) {
        int length = text.length();
        char[] temp = new char[length];
        int count = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean exists = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                temp[count++] = currentChar;
            }
        }

        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }

    public static String[][] getFrequencyByUniqueChars(String text) {
        int[] frequencies = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequencies[(int) text.charAt(i)]++;
        }

        char[] uniqueChars = getUniqueCharacters(text);

        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(frequencies[(int) ch]);
        }

        return result;
    }

    public static void displayTable(String[][] table) {
        System.out.println("\n-----------------------------");
        System.out.printf("%-12s | %-12s%n", "Unique Char", "Frequency");
        System.out.println("-----------------------------");
        for (String[] row : table) {
            String displayChar = row[0].equals(" ") ? "' '" : "'" + row[0] + "'";
            System.out.printf("%-12s | %-12s%n", displayChar, row[1]);
        }
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            String[][] freqTable = getFrequencyByUniqueChars(text);
            displayTable(freqTable);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
