import java.util.Scanner;

public class SplitWordsCustom {

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
        if (length == 0) {
            return new String[0];
        }

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

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a sentence: ");
            String text = scanner.nextLine().trim();

            String[] customWords = splitIntoWords(text);

            String[] builtInWords = text.isEmpty() ? new String[0] : text.split("\\s+");

            boolean areEqual = compareStringArrays(customWords, builtInWords);

            System.out.println("\n--- Words Split Results ---");
            System.out.print("Custom split words: ");
            for (String w : customWords) {
                System.out.print("[" + w + "] ");
            }
            System.out.println();

            System.out.print("Built-in split words: ");
            for (String w : builtInWords) {
                System.out.print("[" + w + "] ");
            }
            System.out.println();

            System.out.println("Are both split word arrays identical? " + areEqual);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
