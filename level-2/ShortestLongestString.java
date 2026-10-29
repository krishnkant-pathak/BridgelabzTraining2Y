import java.util.Scanner;

public class ShortestLongestString {

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
            wordLength2D[i][1] = String.valueOf(getStringLength(words[i]));
        }
        return wordLength2D;
    }

    public static int[] findShortestAndLongestIndices(String[][] wordLength2D) {
        if (wordLength2D.length == 0) {
            return new int[]{-1, -1};
        }

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 0; i < wordLength2D.length; i++) {
            int len = Integer.parseInt(wordLength2D[i][1]);
            if (len < minLength) {
                minLength = len;
                shortestIndex = i;
            }
            if (len > maxLength) {
                maxLength = len;
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a text: ");
            String text = scanner.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println("Empty string entered.");
                return;
            }

            String[] words = splitIntoWords(text);
            String[][] wordLength2D = getWordLengthArray(words);
            int[] resultIndices = findShortestAndLongestIndices(wordLength2D);

            int shortestIdx = resultIndices[0];
            int longestIdx = resultIndices[1];

            System.out.println("\n--- Shortest and Longest Words ---");
            System.out.println("Shortest word: \"" + wordLength2D[shortestIdx][0] + "\" (Length: " + wordLength2D[shortestIdx][1] + ")");
            System.out.println("Longest word: \"" + wordLength2D[longestIdx][0] + "\" (Length: " + wordLength2D[longestIdx][1] + ")");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
