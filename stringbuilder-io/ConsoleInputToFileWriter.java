import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputToFileWriter {

    public static void main(String[] args) {
        String outputFilePath = "user_output.txt";

        System.out.println("=== Console Input to File Writer ===");
        System.out.println("Enter text line by line. Type 'exit' to finish writing to " + outputFilePath + ":\n");

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fileWriter = new FileWriter(outputFilePath)) {

            String inputLine;
            int lineCount = 0;

            while (true) {
                System.out.print("> ");
                inputLine = consoleReader.readLine();

                if (inputLine == null || inputLine.trim().equalsIgnoreCase("exit")) {
                    break;
                }

                fileWriter.write(inputLine + System.lineSeparator());
                lineCount++;
            }

            fileWriter.flush();
            System.out.println("\nSuccessfully wrote " + lineCount + " lines to " + outputFilePath);

        } catch (IOException e) {
            System.err.println("I/O Error occurred: " + e.getMessage());
        }
    }
}
