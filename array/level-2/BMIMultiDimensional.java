import java.util.Scanner;

public class BMIMultiDimensional {

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of persons: ");
            int number = scanner.nextInt();

            if (number <= 0) {
                System.err.println("Invalid number of persons!");
                return;
            }

            double[][] personData = new double[number][3];
            String[] weightStatus = new String[number];

            for (int i = 0; i < number; i++) {
                System.out.println("\nPerson " + (i + 1) + ":");
                System.out.print("Enter Weight (kg): ");
                double weight = scanner.nextDouble();

                System.out.print("Enter Height (m or cm): ");
                double height = scanner.nextDouble();

                if (height > 3.0) {
                    height = height / 100.0;
                }

                if (weight <= 0 || height <= 0) {
                    System.err.println("Negative or zero values are not allowed! Please enter positive values.");
                    i--;
                    continue;
                }

                personData[i][0] = weight;
                personData[i][1] = height;

                double bmi = weight / (height * height);
                personData[i][2] = Math.round(bmi * 100.0) / 100.0;
                weightStatus[i] = getWeightStatus(personData[i][2]);
            }

            System.out.println("\n==================================================================");
            System.out.printf("%-10s | %-12s | %-12s | %-8s | %-15s%n", "Person #", "Weight (kg)", "Height (m)", "BMI", "Status");
            System.out.println("==================================================================");
            for (int i = 0; i < number; i++) {
                System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-15s%n",
                        (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
            }
            System.out.println("==================================================================");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
