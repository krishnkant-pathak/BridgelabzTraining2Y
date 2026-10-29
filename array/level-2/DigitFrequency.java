import java.util.Scanner;

public class DigitFrequency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            long number = scanner.nextLong();

            if (number < 0) {
                number = Math.abs(number);
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

            int[] frequency = new int[10];
            for (int i = 0; i < digits.length; i++) {
                frequency[digits[i]]++;
            }

            System.out.println("\n-----------------------------");
            System.out.printf("%-10s | %-12s%n", "Digit", "Frequency");
            System.out.println("-----------------------------");
            for (int d = 0; d < 10; d++) {
                if (frequency[d] > 0) {
                    System.out.printf("%-10d | %-12d%n", d, frequency[d]);
                }
            }
            System.out.println("-----------------------------");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
