import java.util.Scanner;

public class LinearSearchFirstNegative {

    public static int findFirstNegativeIndex(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();

            int[] array = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            int index = findFirstNegativeIndex(array);

            System.out.println("\n--- Search Results ---");
            if (index != -1) {
                System.out.println("First negative number is " + array[index] + " found at index: " + index);
            } else {
                System.out.println("No negative number found in the array (Result: -1)");
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
