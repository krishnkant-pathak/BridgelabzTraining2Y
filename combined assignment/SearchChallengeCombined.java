import java.util.Arrays;
import java.util.Scanner;

public class SearchChallengeCombined {

    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n + 2];

        for (int num : nums) {
            if (num > 0 && num <= n + 1) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= n + 1; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return 1;
    }

    public static int binarySearchTarget(int[] sortedNums, int target) {
        int left = 0;
        int right = sortedNums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedNums[mid] == target) {
                return mid;
            } else if (sortedNums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of integers: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.err.println("Size must be positive.");
                return;
            }

            int[] nums = new int[n];
            System.out.println("Enter " + n + " integers (can include positive, negative, and zeros):");
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            int missingPositive = findFirstMissingPositive(nums);
            System.out.println("\n--- Task 1: Linear Search Result ---");
            System.out.println("First Missing Positive Integer: " + missingPositive);

            System.out.print("\nEnter target number to search via Binary Search: ");
            int target = scanner.nextInt();

            int[] sortedNums = nums.clone();
            Arrays.sort(sortedNums);

            System.out.print("Sorted Array: ");
            for (int num : sortedNums) {
                System.out.print(num + " ");
            }
            System.out.println();

            int targetIndex = binarySearchTarget(sortedNums, target);

            System.out.println("\n--- Task 2: Binary Search Result ---");
            if (targetIndex != -1) {
                System.out.println("Target " + target + " found in sorted array at index: " + targetIndex);
            } else {
                System.out.println("Target " + target + " was not found in the array (Result: -1)");
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
