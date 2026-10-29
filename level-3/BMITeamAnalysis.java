import java.util.Scanner;

public class BMITeamAnalysis {

    public static String getWeightStatus(double bmi) {
        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static String[][] computeBMITable(double[][] data) {
        int n = data.length;
        String[][] resultTable = new String[n][4];

        for (int i = 0; i < n; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);
            double roundedBMI = Math.round(bmi * 100.0) / 100.0;
            String status = getWeightStatus(roundedBMI);

            resultTable[i][0] = String.format("%.1f", heightCm);
            resultTable[i][1] = String.format("%.1f", weight);
            resultTable[i][2] = String.format("%.2f", roundedBMI);
            resultTable[i][3] = status;
        }

        return resultTable;
    }

    public static void displayBMITable(String[][] table) {
        System.out.println("\n==================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-15s%n", "Person #", "Height (cm)", "Weight (kg)", "BMI", "Status");
        System.out.println("==================================================================");
        for (int i = 0; i < table.length; i++) {
            System.out.printf("Person %-3d | %-12s | %-12s | %-8s | %-15s%n",
                    (i + 1), table[i][0], table[i][1], table[i][2], table[i][3]);
        }
        System.out.println("==================================================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int numberOfMembers = 10;
            double[][] teamData = new double[numberOfMembers][2];

            System.out.println("Enter details for " + numberOfMembers + " team members:");
            for (int i = 0; i < numberOfMembers; i++) {
                System.out.println("\nPerson " + (i + 1) + ":");
                System.out.print("Enter Weight (kg): ");
                double weight = scanner.nextDouble();

                System.out.print("Enter Height (cm): ");
                double height = scanner.nextDouble();

                if (weight <= 0 || height <= 0) {
                    System.err.println("Weight and Height must be positive numbers. Please re-enter.");
                    i--;
                    continue;
                }

                teamData[i][0] = weight;
                teamData[i][1] = height;
            }

            String[][] bmiTable = computeBMITable(teamData);
            displayBMITable(bmiTable);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
