import java.util.Scanner;

public class StudentVotingEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int numberOfStudents = 10;
        final int votingAgeThreshold = 18;

        int[] studentAges = new int[numberOfStudents];

        System.out.println("Enter the age of " + numberOfStudents + " students:");
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            if (!scanner.hasNextInt()) {
                System.err.println("Invalid input! Please enter a valid integer for age.");
                scanner.close();
                return;
            }
            studentAges[i] = scanner.nextInt();
        }

        System.out.println("\n--- Voting Eligibility Results ---");
        for (int i = 0; i < studentAges.length; i++) {
            int age = studentAges[i];
            if (age < 0) {
                System.out.println("Student " + (i + 1) + " (Age: " + age + "): Invalid age entered.");
            } else if (age >= votingAgeThreshold) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }

        scanner.close();
    }
}
