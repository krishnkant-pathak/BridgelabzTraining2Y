import java.util.Scanner;

public class MultiplicationTableRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int startMultiplier = 6;
        final int endMultiplier = 9;
        final int rangeSize = endMultiplier - startMultiplier + 1;

        System.out.print("Enter a number: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input! Please enter a valid integer.");
            scanner.close();
            return;
        }
        int number = scanner.nextInt();

        int[] multiplicationResult = new int[rangeSize];

        for (int i = startMultiplier; i <= endMultiplier; i++) {
            int arrayIndex = i - startMultiplier;
            multiplicationResult[arrayIndex] = number * i;
        }

        System.out.println("\n--- Multiplication Table (" + startMultiplier + " to " + endMultiplier + ") for " + number + " ---");
        for (int i = 0; i < multiplicationResult.length; i++) {
            int multiplier = startMultiplier + i;
            System.out.println(number + " * " + multiplier + " = " + multiplicationResult[i]);
        }

        scanner.close();
    }
}
