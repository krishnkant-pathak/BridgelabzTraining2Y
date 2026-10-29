import java.util.Scanner;

public class MergeSortBookPrices {

    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            merge(prices, left, mid, right);
        }
    }

    public static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = prices[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = prices[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void printPrices(double[] prices) {
        for (double price : prices) {
            System.out.printf("$%.2f ", price);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of books: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.err.println("Invalid number of books! Must be greater than 0.");
                return;
            }

            double[] prices = new double[n];
            System.out.println("Enter prices for " + n + " books:");
            for (int i = 0; i < n; i++) {
                System.out.print("Book " + (i + 1) + " price: ");
                prices[i] = scanner.nextDouble();
                if (prices[i] < 0) {
                    System.err.println("Price cannot be negative. Please re-enter.");
                    i--;
                }
            }

            System.out.println("\n--- Before Sorting ---");
            System.out.print("Book Prices: ");
            printPrices(prices);

            mergeSort(prices, 0, prices.length - 1);

            System.out.println("\n--- After Merge Sort (Ascending Order) ---");
            System.out.print("Sorted Book Prices: ");
            printPrices(prices);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
