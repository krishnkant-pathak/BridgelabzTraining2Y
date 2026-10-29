import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int tableLimit = 10;

        System.out.print("Enter a number to generate its multiplication table: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input! Please enter a valid integer.");
            scanner.close();
            return;
        }
        int number = scanner.nextInt();

        int[] multiplicationResults = new int[tableLimit];

        for (int i = 1; i <= tableLimit; i++) {
            multiplicationResults[i - 1] = number * i;
        }

        System.out.println("\n--- Multiplication Table for " + number + " ---");
        for (int i = 0; i < multiplicationResults.length; i++) {
            int multiplier = i + 1;
            System.out.println(number + " * " + multiplier + " = " + multiplicationResults[i]);
        }

        scanner.close();
    }
}
