import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderLineByLine {

    public static void createSampleFileIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Line 1: Java I/O Streams\n");
                writer.write("Line 2: Reading text files efficiently using BufferedReader\n");
                writer.write("Line 3: FileReader is designed for reading character files\n");
                writer.write("Line 4: Always use try-with-resources to close streams\n");
            } catch (IOException e) {
                System.err.println("Failed to create sample file: " + e.getMessage());
            }
        }
    }

    public static void readFileLineByLine(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("File does not exist: " + filePath);
            return;
        }

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int lineNumber = 1;
            System.out.println("\n--- File Contents (" + file.getName() + ") ---");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
            System.out.println("--- End of File ---");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter file path (or press Enter for 'sample.txt'): ");
            String filePath = scanner.nextLine().trim();

            if (filePath.isEmpty()) {
                filePath = "sample.txt";
                createSampleFileIfNotExists(filePath);
            }

            readFileLineByLine(filePath);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
