import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");

        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input! Please enter a valid integer.");
            scanner.close();
            return;
        }

        int number = scanner.nextInt();

        if (number < 0) {
            System.err.println("Invalid Number. Please enter a positive number.");
            scanner.close();
            return;
        }

        if (number == 0) {
            System.out.println("\nSum of Digits: 0");
            scanner.close();
            return;
        }

        int count = 0;
        int tempNumber = number;
        while (tempNumber > 0) {
            count++;
            tempNumber /= 10;
        }

        int[] digits = new int[count];
        tempNumber = number;

        for (int i = 0; i < digits.length; i++) {
            digits[i] = tempNumber % 10;
            tempNumber /= 10;
        }

        int sumOfDigits = 0;
        for (int i = 0; i < digits.length; i++) {
            sumOfDigits += digits[i];
        }

        System.out.println("\nSum of Digits: " + sumOfDigits);

        scanner.close();
    }
}
