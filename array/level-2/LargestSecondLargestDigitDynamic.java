import java.util.Scanner;

public class LargestSecondLargestDigitDynamic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a positive integer: ");
            String numberStr = scanner.next();

            for (int i = 0; i < numberStr.length(); i++) {
                if (!Character.isDigit(numberStr.charAt(i))) {
                    System.err.println("Invalid number! Please enter only digits.");
                    return;
                }
            }

            int maxDigit = 10;
            int[] digits = new int[maxDigit];
            int index = 0;

            for (int i = 0; i < numberStr.length(); i++) {
                if (index == maxDigit) {
                    maxDigit += 10;
                    int[] temp = new int[maxDigit];
                    for (int j = 0; j < digits.length; j++) {
                        temp[j] = digits[j];
                    }
                    digits = temp;
                }

                digits[index++] = numberStr.charAt(i) - '0';
            }

            System.out.print("\nAll digits stored in dynamic array (total: " + index + "): ");
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
                System.out.println("No distinct second largest digit found.");
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
