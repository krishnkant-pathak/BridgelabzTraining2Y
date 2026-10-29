import java.util.Scanner;

public class OddEvenArraySeparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive natural number: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input! Please enter a valid integer.");
            scanner.close();
            return;
        }
        int number = scanner.nextInt();

        if (number <= 0) {
            System.err.println("Error: " + number + " is not a natural number. Natural numbers must be greater than 0.");
            scanner.close();
            return;
        }

        int arrayCapacity = (number / 2) + 1;
        int[] evenNumbers = new int[arrayCapacity];
        int[] oddNumbers = new int[arrayCapacity];

        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        System.out.println("\n--- Odd Numbers Array (Count: " + oddIndex + ") ---");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        System.out.println();

        System.out.println("\n--- Even Numbers Array (Count: " + evenIndex + ") ---");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
