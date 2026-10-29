import java.util.Scanner;

public class FootballTeamMeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int numberOfPlayers = 11;

        double[] heights = new double[numberOfPlayers];

        System.out.println("Enter the height (in cm or meters) of " + numberOfPlayers + " players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            if (!scanner.hasNextDouble()) {
                System.err.println("Invalid input! Please enter a numerical value for height.");
                scanner.close();
                return;
            }
            double inputHeight = scanner.nextDouble();
            if (inputHeight <= 0) {
                System.err.println("Height must be a positive number.");
                scanner.close();
                return;
            }
            heights[i] = inputHeight;
        }

        double sumOfHeights = 0.0;
        for (int i = 0; i < heights.length; i++) {
            sumOfHeights += heights[i];
        }

        double meanHeight = sumOfHeights / heights.length;

        System.out.println("\n--- Football Team Heights ---");
        for (int i = 0; i < heights.length; i++) {
            System.out.println("Player " + (i + 1) + " Height: " + heights[i]);
        }
        System.out.printf("\nMean Height of Football Team: %.2f\n", meanHeight);

        scanner.close();
    }
}
