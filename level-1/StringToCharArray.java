import java.util.Scanner;

public class StringToCharArray {

    public static char[] getCharacters(String text) {
        char[] charArray = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            charArray[i] = text.charAt(i);
        }
        return charArray;
    }

    public static boolean compareCharArrays(char[] array1, char[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
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

            char[] customCharArray = getCharacters(text);

            char[] builtInCharArray = text.toCharArray();

            boolean areEqual = compareCharArrays(customCharArray, builtInCharArray);

            System.out.println("\n--- Character Array Results ---");
            System.out.print("User-defined char array: ");
            for (char ch : customCharArray) {
                System.out.print(ch + " ");
            }
            System.out.println();

            System.out.print("Built-in toCharArray(): ");
            for (char ch : builtInCharArray) {
                System.out.print(ch + " ");
            }
            System.out.println();

            System.out.println("Are both character arrays identical? " + areEqual);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
