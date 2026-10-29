import java.util.Scanner;

public class ReverseNumberArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a positive number: ");
            long number = scanner.nextLong();

            if (number < 0) {
                System.err.println("Invalid input! Number must be non-negative.");
                return;
            }

            int count = 0;
            long temp = number;
            if (temp == 0) {
                count = 1;
            } else {
                while (temp > 0) {
                    count++;
                    temp /= 10;
                }
            }

            int[] digits = new int[count];
            temp = number;
            for (int i = count - 1; i >= 0; i--) {
                digits[i] = (int) (temp % 10);
                temp /= 10;
            }

            int[] reversedDigits = new int[count];
            for (int i = 0; i < count; i++) {
                reversedDigits[i] = digits[count - 1 - i];
            }

            System.out.print("\nOriginal Digits Array: ");
            for (int d : digits) {
                System.out.print(d + " ");
            }
            System.out.println();

            System.out.print("Reversed Digits Array: ");
            for (int d : reversedDigits) {
                System.out.print(d + " ");
            }
            System.out.println();

            System.out.print("Reversed Number: ");
            for (int d : reversedDigits) {
                System.out.print(d);
            }
            System.out.println();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
