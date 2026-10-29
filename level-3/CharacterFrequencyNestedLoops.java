import java.util.Scanner;

public class CharacterFrequencyNestedLoops {

    public static String[] findFrequenciesWithNestedLoops(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
            if (chars[i] == '0') {
                continue;
            }

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                count++;
            }
        }

        String[] results = new String[count];
        int resultIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                String charDisplay = chars[i] == ' ' ? "Space" : String.valueOf(chars[i]);
                results[resultIndex++] = charDisplay + " : " + freq[i];
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String text = scanner.nextLine();

            String[] frequencies = findFrequenciesWithNestedLoops(text);

            System.out.println("\n--- Character Frequencies (Nested Loops Approach) ---");
            for (String entry : frequencies) {
                System.out.println(entry);
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
