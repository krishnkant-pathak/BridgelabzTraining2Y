import java.util.Scanner;

public class QuickSortProductPrices {

    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);

            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
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
            System.out.print("Enter number of products: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.err.println("Invalid number of products! Must be greater than 0.");
                return;
            }

            double[] prices = new double[n];
            System.out.println("Enter prices for " + n + " products:");
            for (int i = 0; i < n; i++) {
                System.out.print("Product " + (i + 1) + " price: ");
                prices[i] = scanner.nextDouble();
                if (prices[i] < 0) {
                    System.err.println("Product price cannot be negative. Please re-enter.");
                    i--;
                }
            }

            System.out.println("\n--- Before Sorting ---");
            System.out.print("Product Prices: ");
            printPrices(prices);

            quickSort(prices, 0, prices.length - 1);

            System.out.println("\n--- After Quick Sort (Ascending Order) ---");
            System.out.print("Sorted Product Prices: ");
            printPrices(prices);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
