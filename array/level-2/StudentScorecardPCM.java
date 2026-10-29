import java.util.Scanner;

public class StudentScorecardPCM {

    public static int[][] generateRandomScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3];
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = (int) (Math.random() * 70) + 30;
            scores[i][1] = (int) (Math.random() * 70) + 30;
            scores[i][2] = (int) (Math.random() * 70) + 30;
        }
        return scores;
    }

    public static double[][] calculateMetrics(int[][] scores) {
        int n = scores.length;
        double[][] metrics = new double[n][3];
        for (int i = 0; i < n; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100.0;

            double roundedAverage = Math.round(average * 100.0) / 100.0;
            double roundedPercentage = Math.round(percentage * 100.0) / 100.0;

            metrics[i][0] = total;
            metrics[i][1] = roundedAverage;
            metrics[i][2] = roundedPercentage;
        }
        return metrics;
    }

    public static String[][] calculateGrades(double[][] metrics) {
        int n = metrics.length;
        String[][] grades = new String[n][2];
        for (int i = 0; i < n; i++) {
            double percentage = metrics[i][2];
            if (percentage >= 80) {
                grades[i][0] = "A";
                grades[i][1] = "Level 4, above agency-normalized standards";
            } else if (percentage >= 70) {
                grades[i][0] = "B";
                grades[i][1] = "Level 3, at agency-normalized standards";
            } else if (percentage >= 60) {
                grades[i][0] = "C";
                grades[i][1] = "Level 2, below, but approaching agency-normalized standards";
            } else if (percentage >= 50) {
                grades[i][0] = "D";
                grades[i][1] = "Level 1, well below agency-normalized standards";
            } else if (percentage >= 40) {
                grades[i][0] = "E";
                grades[i][1] = "Level 1-, too below agency-normalized standards";
            } else {
                grades[i][0] = "R";
                grades[i][1] = "Remedial standards";
            }
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] metrics, String[][] grades) {
        System.out.println("\n==========================================================================================================");
        System.out.printf("%-10s | %-7s | %-9s | %-6s | %-6s | %-8s | %-11s | %-6s | %-30s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade", "Remarks");
        System.out.println("==========================================================================================================");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %-3d | %-7d | %-9d | %-6d | %-6.0f | %-8.2f | %-10.2f%% | %-6s | %-30s%n",
                    (i + 1), scores[i][0], scores[i][1], scores[i][2],
                    metrics[i][0], metrics[i][1], metrics[i][2],
                    grades[i][0], grades[i][1]);
        }
        System.out.println("==========================================================================================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of students: ");
            int numberOfStudents = scanner.nextInt();

            if (numberOfStudents <= 0) {
                System.err.println("Invalid number of students!");
                return;
            }

            int[][] scores = generateRandomScores(numberOfStudents);
            double[][] metrics = calculateMetrics(scores);
            String[][] grades = calculateGrades(metrics);

            displayScorecard(scores, metrics, grades);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
