import java.util.Scanner;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input! Please enter an integer.");
            scanner.close();
            return;
        }
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input! Please enter an integer.");
            scanner.close();
            return;
        }
        int columns = scanner.nextInt();

        if (rows <= 0 || columns <= 0) {
            System.err.println("Invalid dimensions! Rows and columns must be greater than zero.");
            scanner.close();
            return;
        }

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter the elements of the " + rows + "x" + columns + " matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!scanner.hasNextInt()) {
                    System.err.println("Invalid input for element at [" + i + "][" + j + "].");
                    scanner.close();
                    return;
                }
                matrix[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;
        System.out.println("\nThe elements of the 2D Array are:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
                sum += matrix[i][j];
            }
            System.out.println();
        }

        System.out.println("\nThe sum of all elements in the 2D Array is: " + sum);

        scanner.close();
    }
}
