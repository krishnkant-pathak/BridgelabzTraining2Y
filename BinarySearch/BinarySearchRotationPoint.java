import java.util.Scanner;

public class BinarySearchRotationPoint {

    public static int findRotationPointIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of elements in rotated sorted array: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.err.println("Invalid size! Must be greater than 0.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements (e.g., 4 5 6 7 0 1 2):");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int rotationIndex = findRotationPointIndex(arr);

            System.out.println("\n--- Rotation Point Result ---");
            System.out.println("Rotation Point Index: " + rotationIndex);
            System.out.println("Smallest Element (Value at Rotation Point): " + arr[rotationIndex]);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
