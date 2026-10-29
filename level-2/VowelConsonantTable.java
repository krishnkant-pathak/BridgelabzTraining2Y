import java.util.Scanner;

public class VowelConsonantTable {

    public static String checkCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    public static String[][] getCharacterTypes(String text) {
        String[][] charTypeTable = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            charTypeTable[i][0] = String.valueOf(ch);
            charTypeTable[i][1] = checkCharType(ch);
        }
        return charTypeTable;
    }

    public static void displayTable(String[][] table) {
        System.out.println("\n------------------------------------");
        System.out.printf("%-15s | %-18s%n", "Character", "Type");
        System.out.println("------------------------------------");
        for (int i = 0; i < table.length; i++) {
            String displayChar = table[i][0].equals(" ") ? "' '" : table[i][0];
            System.out.printf("%-15s | %-18s%n", displayChar, table[i][1]);
        }
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            String[][] resultTable = getCharacterTypes(text);
            displayTable(resultTable);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
