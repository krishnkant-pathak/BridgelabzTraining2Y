import java.util.Scanner;

public class BubbleSortStudentMarks {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
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
            System.out.print("Enter number of students: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.err.println("Invalid number of students! Must be greater than 0.");
                return;
            }

            int[] marks = new int[n];
            System.out.println("Enter marks for " + n + " students (0-100):");
            for (int i = 0; i < n; i++) {
                System.out.print("Student " + (i + 1) + " mark: ");
                marks[i] = scanner.nextInt();
                if (marks[i] < 0 || marks[i] > 100) {
                    System.err.println("Marks should be between 0 and 100. Please re-enter.");
                    i--;
                }
            }

            System.out.println("\n--- Before Sorting ---");
            System.out.print("Student Marks: ");
            printArray(marks);

            bubbleSort(marks);

            System.out.println("\n--- After Bubble Sort (Ascending Order) ---");
            System.out.print("Sorted Marks: ");
            printArray(marks);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
