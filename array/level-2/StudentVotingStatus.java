import java.util.Scanner;

public class StudentVotingStatus {

    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = (int) (Math.random() * 80) + 10;
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] votingTable = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            votingTable[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                votingTable[i][1] = "false (Invalid Age)";
            } else if (ages[i] >= 18) {
                votingTable[i][1] = "true";
            } else {
                votingTable[i][1] = "false";
            }
        }
        return votingTable;
    }

    public static void displayVotingTable(String[][] table) {
        System.out.println("\n-------------------------------------------");
        System.out.printf("%-12s | %-10s | %-15s%n", "Student #", "Age", "Can Vote?");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.printf("Student %-4d | %-10s | %-15s%n", (i + 1), table[i][0], table[i][1]);
        }
        System.out.println("-------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int numberOfStudents = 10;
            System.out.println("Generating random ages for " + numberOfStudents + " students...");

            int[] ages = generateRandomAges(numberOfStudents);
            String[][] votingResults = checkVotingEligibility(ages);

            displayVotingTable(votingResults);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
