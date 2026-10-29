import java.util.Scanner;

public class BinarySearchFirstLastOccurrence {

    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int firstIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                firstIndex = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstIndex;
    }

    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                lastIndex = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of elements in sorted array: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.err.println("Size must be positive.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " sorted integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.print("Enter target element: ");
            int target = scanner.nextInt();

            int first = findFirstOccurrence(arr, target);
            int last = findLastOccurrence(arr, target);

            System.out.println("\n--- Search Results ---");
            if (first != -1) {
                System.out.println("First Occurrence of " + target + ": Index " + first);
                System.out.println("Last Occurrence of " + target + ":  Index " + last);
                System.out.println("Total Count of " + target + ":      " + (last - first + 1));
            } else {
                System.out.println("Target " + target + " not found in array (Indices: -1, -1)");
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
