import java.util.Scanner;

public class StringLengthWithoutLength {

    public static int findStringLength(String text) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String text = scanner.next();

            int customLength = findStringLength(text);

            int builtInLength = text.length();

            System.out.println("\n--- String Length Results ---");
            System.out.println("Custom calculated length: " + customLength);
            System.out.println("Built-in length() result: " + builtInLength);
            System.out.println("Do both lengths match? " + (customLength == builtInLength));
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
