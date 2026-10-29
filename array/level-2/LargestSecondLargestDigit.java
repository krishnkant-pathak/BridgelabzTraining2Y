import java.util.Scanner;

public class LargestSecondLargestDigit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a positive integer: ");
            long number = scanner.nextLong();

            if (number < 0) {
                System.err.println("Invalid input! Number must be non-negative.");
                return;
            }

            int maxDigit = 10;
            int[] digits = new int[maxDigit];
            int index = 0;

            long tempNumber = number;
            if (tempNumber == 0) {
                digits[index++] = 0;
            } else {
                while (tempNumber != 0) {
                    if (index == maxDigit) {
                        System.out.println("Reached maximum capacity of " + maxDigit + " digits. Stopping extraction.");
                        break;
                    }
                    int digit = (int) (tempNumber % 10);
                    digits[index] = digit;
                    index++;
                    tempNumber /= 10;
                }
            }

            System.out.print("\nDigits stored in array: ");
            for (int i = 0; i < index; i++) {
                System.out.print(digits[i] + " ");
            }
            System.out.println();

            int largest = -1;
            int secondLargest = -1;

            for (int i = 0; i < index; i++) {
                if (digits[i] > largest) {
                    secondLargest = largest;
                    largest = digits[i];
                } else if (digits[i] > secondLargest && digits[i] != largest) {
                    secondLargest = digits[i];
                }
            }

            System.out.println("Largest digit: " + largest);
            if (secondLargest != -1) {
                System.out.println("Second largest digit: " + secondLargest);
            } else {
                System.out.println("No distinct second largest digit found (all digits may be identical).");
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
