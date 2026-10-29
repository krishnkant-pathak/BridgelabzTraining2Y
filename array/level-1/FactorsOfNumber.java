import java.util.Scanner;

public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input! Please enter a valid integer.");
            scanner.close();
            return;
        }
        int number = scanner.nextInt();

        if (number <= 0) {
            System.err.println("Invalid number! Please enter a positive integer greater than 0.");
            scanner.close();
            return;
        }

        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (index == maxFactor) {
                    maxFactor = maxFactor * 2;
                    int[] tempArray = new int[maxFactor];

                    for (int j = 0; j < factors.length; j++) {
                        tempArray[j] = factors[j];
                    }

                    factors = tempArray;
                }

                factors[index] = i;
                index++;
            }
        }

        System.out.println("\n--- Factors of " + number + " (Total: " + index + ") ---");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
