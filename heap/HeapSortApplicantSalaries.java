import java.util.Scanner;

public class HeapSortApplicantSalaries {

    public static void heapSort(double[] salaries) {
        int n = salaries.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            heapify(salaries, i, 0);
        }
    }

    public static void heapify(double[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        if (largest != i) {
            double swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            heapify(salaries, n, largest);
        }
    }

    public static void printSalaries(double[] salaries) {
        for (double salary : salaries) {
            System.out.printf("$%.2f ", salary);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of applicants: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.err.println("Invalid number of applicants! Must be greater than 0.");
                return;
            }

            double[] salaries = new double[n];
            System.out.println("Enter expected salaries for " + n + " applicants:");
            for (int i = 0; i < n; i++) {
                System.out.print("Applicant " + (i + 1) + " expected salary: ");
                salaries[i] = scanner.nextDouble();
                if (salaries[i] < 0) {
                    System.err.println("Salary cannot be negative. Please re-enter.");
                    i--;
                }
            }

            System.out.println("\n--- Before Sorting ---");
            System.out.print("Applicant Salaries: ");
            printSalaries(salaries);

            heapSort(salaries);

            System.out.println("\n--- After Heap Sort (Ascending Order) ---");
            System.out.print("Sorted Applicant Salaries: ");
            printSalaries(salaries);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
