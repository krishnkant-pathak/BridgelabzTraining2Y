import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int arraySize = 5;

        int[] numbers = new int[arraySize];

        System.out.println("Enter " + arraySize + " numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            if (!scanner.hasNextInt()) {
                System.err.println("Invalid input! Please enter a valid integer.");
                scanner.close();
                return;
            }
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n--- Number Analysis ---");
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println("Number " + num + " is Positive and Even.");
                } else {
                    System.out.println("Number " + num + " is Positive and Odd.");
                }
            } else if (num < 0) {
                System.out.println("Number " + num + " is Negative.");
            } else {
                System.out.println("Number " + num + " is Zero.");
            }
        }

        int firstElement = numbers[0];
        int lastElement = numbers[numbers.length - 1];

        System.out.println("\n--- First and Last Element Comparison ---");
        System.out.println("First element: " + firstElement + ", Last element: " + lastElement);
        if (firstElement == lastElement) {
            System.out.println("The first and last elements are Equal.");
        } else if (firstElement > lastElement) {
            System.out.println("The first element (" + firstElement + ") is Greater than the last element (" + lastElement + ").");
        } else {
            System.out.println("The first element (" + firstElement + ") is Less than the last element (" + lastElement + ").");
        }

        scanner.close();
    }
}
