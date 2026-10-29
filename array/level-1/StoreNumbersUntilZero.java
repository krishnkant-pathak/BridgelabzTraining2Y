import java.util.Scanner;

public class StoreNumbersUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int maxCapacity = 10;

        double[] numbers = new double[maxCapacity];
        double total = 0.0;
        int index = 0;

        System.out.println("Enter positive numbers (Enter 0 or a negative number to stop, max 10 numbers):");

        while (true) {
            if (index == numbers.length) {
                System.out.println("Maximum limit of " + maxCapacity + " numbers reached.");
                break;
            }

            System.out.print("Enter number " + (index + 1) + ": ");
            if (!scanner.hasNextDouble()) {
                System.err.println("Invalid input! Please enter a valid number.");
                scanner.next();
                continue;
            }

            double userInput = scanner.nextDouble();

            if (userInput <= 0) {
                System.out.println("Non-positive number (" + userInput + ") entered. Stopping input.");
                break;
            }

            numbers[index] = userInput;
            index++;
        }

        System.out.println("\n--- Stored Numbers ---");
        if (index == 0) {
            System.out.println("No valid positive numbers were entered.");
        } else {
            for (int i = 0; i < index; i++) {
                System.out.println("Element " + (i + 1) + ": " + numbers[i]);
                total += numbers[i];
            }
            System.out.println("\nTotal Sum: " + total);
        }

        scanner.close();
    }
}
