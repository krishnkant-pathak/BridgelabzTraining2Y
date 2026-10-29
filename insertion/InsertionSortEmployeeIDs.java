import java.util.Scanner;

public class InsertionSortEmployeeIDs {

    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;

            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j = j - 1;
            }
            employeeIDs[j + 1] = key;
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of employees: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.err.println("Invalid number of employees! Must be greater than 0.");
                return;
            }

            int[] employeeIDs = new int[n];
            System.out.println("Enter " + n + " Employee IDs:");
            for (int i = 0; i < n; i++) {
                System.out.print("Employee " + (i + 1) + " ID: ");
                employeeIDs[i] = scanner.nextInt();
                if (employeeIDs[i] <= 0) {
                    System.err.println("Employee ID should be positive. Please re-enter.");
                    i--;
                }
            }

            System.out.println("\n--- Before Sorting ---");
            System.out.print("Employee IDs: ");
            printArray(employeeIDs);

            insertionSort(employeeIDs);

            System.out.println("\n--- After Insertion Sort (Ascending Order) ---");
            System.out.print("Sorted Employee IDs: ");
            printArray(employeeIDs);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
