import java.util.Scanner;

public class StudentMarksGrade {

    public static String calculateGrade(double percentage) {
        if (percentage >= 80) {
            return "A (Level 4, above agency-normalized standards)";
        } else if (percentage >= 70) {
            return "B (Level 3, at agency-normalized standards)";
        } else if (percentage >= 60) {
            return "C (Level 2, below, but approaching agency-normalized standards)";
        } else if (percentage >= 50) {
            return "D (Level 1, well below agency-normalized standards)";
        } else if (percentage >= 40) {
            return "E (Level 1-, too below agency-normalized standards)";
        } else {
            return "R (Remedial standards)";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of students: ");
            int numberOfStudents = scanner.nextInt();

            if (numberOfStudents <= 0) {
                System.err.println("Invalid number of students!");
                return;
            }

            double[] physics = new double[numberOfStudents];
            double[] chemistry = new double[numberOfStudents];
            double[] maths = new double[numberOfStudents];
            double[] percentages = new double[numberOfStudents];
            String[] grades = new String[numberOfStudents];

            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println("\nEnter marks for Student " + (i + 1) + " (0-100):");

                System.out.print("Physics: ");
                double p = scanner.nextDouble();
                System.out.print("Chemistry: ");
                double c = scanner.nextDouble();
                System.out.print("Maths: ");
                double m = scanner.nextDouble();

                if (p < 0 || c < 0 || m < 0 || p > 100 || c > 100 || m > 100) {
                    System.err.println("Marks must be between 0 and 100! Please re-enter.");
                    i--;
                    continue;
                }

                physics[i] = p;
                chemistry[i] = c;
                maths[i] = m;

                double total = p + c + m;
                percentages[i] = Math.round((total / 3.0) * 100.0) / 100.0;
                grades[i] = calculateGrade(percentages[i]);
            }

            System.out.println("\n==========================================================================================================");
            System.out.printf("%-10s | %-8s | %-10s | %-6s | %-12s | %-30s%n",
                    "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade & Remarks");
            System.out.println("==========================================================================================================");
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.printf("Student %-3d | %-8.1f | %-10.1f | %-6.1f | %-11.2f%% | %-30s%n",
                        (i + 1), physics[i], chemistry[i], maths[i], percentages[i], grades[i]);
            }
            System.out.println("==========================================================================================================");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
