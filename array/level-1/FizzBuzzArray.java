import java.util.Scanner;

public class FizzBuzzArray {
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
            System.err.println("Invalid input! Please enter a positive integer greater than 0.");
            scanner.close();
            return;
        }

        String[] fizzBuzzResults = new String[number + 1];

        for (int i = 0; i <= number; i++) {
            if (i == 0) {
                fizzBuzzResults[i] = "0";
            } else if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzResults[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                fizzBuzzResults[i] = "Fizz";
            } else if (i % 5 == 0) {
                fizzBuzzResults[i] = "Buzz";
            } else {
                fizzBuzzResults[i] = String.valueOf(i);
            }
        }

        System.out.println("\n--- FizzBuzz Results ---");
        for (int i = 0; i < fizzBuzzResults.length; i++) {
            System.out.println("Position " + i + " = " + fizzBuzzResults[i]);
        }

        scanner.close();
    }
}
