import java.util.Scanner;

public class LinearSearchWordInSentences {

    public static String findSentenceWithWord(String[] sentences, String targetWord) {
        if (sentences == null || targetWord == null) {
            return "Not Found";
        }

        for (String sentence : sentences) {
            String[] words = sentence.split("\\W+");
            for (String word : words) {
                if (word.equalsIgnoreCase(targetWord)) {
                    return sentence;
                }
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of sentences: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            String[] sentences = new String[n];
            System.out.println("Enter " + n + " sentences:");
            for (int i = 0; i < n; i++) {
                System.out.print("Sentence " + (i + 1) + ": ");
                sentences[i] = scanner.nextLine();
            }

            System.out.print("\nEnter target word to search: ");
            String targetWord = scanner.next();

            String result = findSentenceWithWord(sentences, targetWord);

            System.out.println("\n--- Search Result ---");
            if (!result.equals("Not Found")) {
                System.out.println("Found in sentence: \"" + result + "\"");
            } else {
                System.out.println("Result: Not Found");
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
