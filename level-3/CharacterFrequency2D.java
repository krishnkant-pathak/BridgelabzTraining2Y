import java.util.Scanner;

public class CharacterFrequency2D {

    public static String[][] getCharacterFrequencies(String text) {
        int[] frequencies = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequencies[(int) text.charAt(i)]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (frequencies[i] > 0) {
                uniqueCount++;
            }
        }

        String[][] frequencyTable = new String[uniqueCount][2];
        boolean[] visited = new boolean[256];
        int tableIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!visited[(int) ch]) {
                visited[(int) ch] = true;
                frequencyTable[tableIndex][0] = String.valueOf(ch);
                frequencyTable[tableIndex][1] = String.valueOf(frequencies[(int) ch]);
                tableIndex++;
            }
        }

        return frequencyTable;
    }

    public static void displayFrequencyTable(String[][] table) {
        System.out.println("\n-----------------------------");
        System.out.printf("%-12s | %-12s%n", "Character", "Frequency");
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

            String[][] frequencies = getCharacterFrequencies(text);
            displayFrequencyTable(frequencies);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
