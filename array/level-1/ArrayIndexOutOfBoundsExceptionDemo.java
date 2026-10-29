import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {

    public static void generateException(String[] names) {
        int invalidIndex = names.length + 2;
        System.out.println("Name at index " + invalidIndex + ": " + names[invalidIndex]);
    }

    public static void handleException(String[] names) {
        try {
            int invalidIndex = names.length + 2;
            System.out.println("Attempting to access index " + invalidIndex + " in array of size " + names.length + "...");
            System.out.println("Name at index " + invalidIndex + ": " + names[invalidIndex]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Index is out of range for the array (valid indices: 0 to " + (names.length - 1) + ").");
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of names: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.err.println("Size must be greater than 0.");
                return;
            }

            String[] names = new String[size];
            System.out.println("Enter " + size + " names:");
            for (int i = 0; i < size; i++) {
                System.out.print("Name " + (i + 1) + ": ");
                names[i] = scanner.next();
            }

            System.out.println("\n=== Demonstrating ArrayIndexOutOfBoundsException Handling ===");
            handleException(names);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
