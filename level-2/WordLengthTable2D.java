import java.util.Scanner;

public class WordLengthTable2D {

    public static int getStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] splitIntoWords(String text) {
        int length = getStringLength(text);
        int wordCount = 0;
        boolean inWord = false;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ') {
                if (!inWord) {
                    wordCount++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        if (wordCount == 0) {
            return new String[0];
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                currentWord.append(ch);
            } else if (currentWord.length() > 0) {
                words[wordIndex++] = currentWord.toString();
                currentWord.setLength(0);
            }
        }
        if (currentWord.length() > 0) {
            words[wordIndex] = currentWord.toString();
        }

        return words;
    }

    public static String[][] getWordLengthArray(String[] words) {
        String[][] wordLength2D = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordLength2D[i][0] = words[i];
            int length = getStringLength(words[i]);
            wordLength2D[i][1] = String.valueOf(length);
        }
        return wordLength2D;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a sentence: ");
            String text = scanner.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println("Empty input provided.");
                return;
            }

            String[] words = splitIntoWords(text);

            String[][] wordTable = getWordLengthArray(words);

            System.out.println("\n-----------------------------");
            System.out.printf("%-15s | %-10s%n", "Word", "Length");
            System.out.println("-----------------------------");
            for (int i = 0; i < wordTable.length; i++) {
                String word = wordTable[i][0];
                int length = Integer.parseInt(wordTable[i][1]);
                System.out.printf("%-15s | %-10d%n", word, length);
            }
            System.out.println("-----------------------------");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
