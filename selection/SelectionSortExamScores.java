import java.util.Scanner;

public class SelectionSortExamScores {

    public static void selectionSort(double[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                double temp = scores[minIndex];
                scores[minIndex] = scores[i];
                scores[i] = temp;
            }
        }
    }

    public static void printScores(double[] scores) {
        for (double score : scores) {
            System.out.print(score + " ");
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

            double[] scores = new double[n];
            System.out.println("Enter exam scores for " + n + " students (0-100):");
            for (int i = 0; i < n; i++) {
                System.out.print("Student " + (i + 1) + " score: ");
                scores[i] = scanner.nextDouble();
                if (scores[i] < 0 || scores[i] > 100) {
                    System.err.println("Score should be between 0 and 100. Please re-enter.");
                    i--;
                }
            }

            System.out.println("\n--- Before Sorting ---");
            System.out.print("Exam Scores: ");
            printScores(scores);

            selectionSort(scores);

            System.out.println("\n--- After Selection Sort (Ascending Order) ---");
            System.out.print("Sorted Exam Scores: ");
            printScores(scores);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
