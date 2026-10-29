import java.util.Scanner;

public class BinarySearch2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / cols;
            int col = mid % cols;
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of rows: ");
            int rows = scanner.nextInt();

            System.out.print("Enter number of columns: ");
            int cols = scanner.nextInt();

            if (rows <= 0 || cols <= 0) {
                System.err.println("Dimensions must be positive.");
                return;
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("Enter matrix elements in row-major sorted order:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.print("Enter target value to search: ");
            int target = scanner.nextInt();

            boolean found = searchMatrix(matrix, target);

            System.out.println("\n--- Search Result ---");
            System.out.println("Is " + target + " present in the matrix? " + found);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
