import java.util.Scanner;

public class StringAnalyzer {

    public static int[] findAllIndexes(String text, char ch) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) {
                count++;
            }
        }

        int[] indexes = new int[count];
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ch) {
                indexes[j] = i;
                j++;
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a text: ");
            String text = sc.nextLine();

            System.out.print("Enter a character to find the occurrences: ");
            char ch = sc.next().charAt(0);

            int[] indexes = findAllIndexes(text, ch);

            System.out.println("Total occurrences: " + indexes.length);
            System.out.print("Indexes of the character '" + ch + "': ");
            for (int i = 0; i < indexes.length; i++) {
                System.out.print(indexes[i] + " ");
            }
            System.out.println();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
