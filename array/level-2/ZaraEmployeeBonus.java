import java.util.Scanner;

public class ZaraEmployeeBonus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = 10;

        double[] salaries = new double[numberOfEmployees];
        double[] yearsOfService = new double[numberOfEmployees];
        double[] bonuses = new double[numberOfEmployees];
        double[] newSalaries = new double[numberOfEmployees];

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        System.out.println("Enter salary and years of service for " + numberOfEmployees + " employees:");

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            System.out.print("Enter Salary: ");
            if (!scanner.hasNextDouble()) {
                System.err.println("Invalid input! Please enter a valid number for salary.");
                scanner.next();
                i--;
                continue;
            }
            double salary = scanner.nextDouble();

            System.out.print("Enter Years of Service: ");
            if (!scanner.hasNextDouble()) {
                System.err.println("Invalid input! Please enter a valid number for years of service.");
                scanner.next();
                i--;
                continue;
            }
            double service = scanner.nextDouble();

            if (salary <= 0 || service < 0) {
                System.err.println("Salary must be > 0 and Years of Service must be >= 0. Please re-enter.");
                i--;
                continue;
            }

            salaries[i] = salary;
            yearsOfService[i] = service;
        }

        for (int i = 0; i < numberOfEmployees; i++) {
            double bonusPercentage = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusPercentage;
            newSalaries[i] = salaries[i] + bonuses[i];

            totalOldSalary += salaries[i];
            totalBonus += bonuses[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("\n==========================================================================");
        System.out.printf("%-12s | %-12s | %-16s | %-12s | %-12s%n", "Employee #", "Old Salary", "Years of Service", "Bonus Amount", "New Salary");
        System.out.println("==========================================================================");
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.printf("Employee %-3d | %-12.2f | %-16.1f | %-12.2f | %-12.2f%n",
                    (i + 1), salaries[i], yearsOfService[i], bonuses[i], newSalaries[i]);
        }
        System.out.println("==========================================================================");
        System.out.printf("Total Old Salary Payout: %.2f%n", totalOldSalary);
        System.out.printf("Total Bonus Payout:      %.2f%n", totalBonus);
        System.out.printf("Total New Salary Payout: %.2f%n", totalNewSalary);

        scanner.close();
    }
}
