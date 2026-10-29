import java.util.Scanner;

public class MatrixToSingleDimensionArray {
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
            System.err.println("Rows and columns must be greater than zero.");
            scanner.close();
            return;
        }

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter the elements of the " + rows + "x" + columns + " matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!scanner.hasNextInt()) {
                    System.err.println("Invalid input at position [" + i + "][" + j + "].");
                    scanner.close();
                    return;
                }
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] singleDimensionArray = new int[rows * columns];
        int index = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                singleDimensionArray[index] = matrix[i][j];
                index++;
            }
        }

        System.out.println("\n--- Original 2D Matrix ---");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\n--- Flattened 1D Array ---");
        for (int i = 0; i < singleDimensionArray.length; i++) {
            System.out.print(singleDimensionArray[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
