import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderWordCount {

    public static void createSampleFileIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Java is a popular programming language.\n");
                writer.write("Java is object-oriented, secure, and robust.\n");
                writer.write("Many developers love Java because Java has a great ecosystem.\n");
            } catch (IOException e) {
                System.err.println("Could not create sample file: " + e.getMessage());
            }
        }
    }

    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("File not found: " + filePath);
            return 0;
        }

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter file path (or press Enter for 'sample_words.txt'): ");
            String filePath = scanner.nextLine().trim();

            if (filePath.isEmpty()) {
                filePath = "sample_words.txt";
                createSampleFileIfNotExists(filePath);
            }

            System.out.print("Enter the word to search for: ");
            String targetWord = scanner.next();

            int occurrences = countWordOccurrences(filePath, targetWord);

            System.out.println("\n--- Search Result ---");
            System.out.println("The word \"" + targetWord + "\" appeared " + occurrences + " time(s) in " + filePath);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
