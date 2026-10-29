import java.util.Scanner;

public class YoungestTallestFriends {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] friendNames = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        try {
            for (int i = 0; i < friendNames.length; i++) {
                System.out.println("\nEnter details for " + friendNames[i] + ":");
                System.out.print("Age (years): ");
                ages[i] = scanner.nextInt();

                System.out.print("Height (cm): ");
                heights[i] = scanner.nextDouble();
            }

            int minAge = ages[0];
            int youngestIndex = 0;
            for (int i = 1; i < ages.length; i++) {
                if (ages[i] < minAge) {
                    minAge = ages[i];
                    youngestIndex = i;
                }
            }

            double maxHeight = heights[0];
            int tallestIndex = 0;
            for (int i = 1; i < heights.length; i++) {
                if (heights[i] > maxHeight) {
                    maxHeight = heights[i];
                    tallestIndex = i;
                }
            }

            System.out.println("\n--- Summary ---");
            for (int i = 0; i < friendNames.length; i++) {
                System.out.println(friendNames[i] + " -> Age: " + ages[i] + " years, Height: " + heights[i] + " cm");
            }
            System.out.println("\nYoungest Friend: " + friendNames[youngestIndex] + " (" + minAge + " years)");
            System.out.println("Tallest Friend:  " + friendNames[tallestIndex] + " (" + maxHeight + " cm)");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
