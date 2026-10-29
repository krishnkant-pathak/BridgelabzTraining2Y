import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ByteToCharStreamConverter {

    public static void createSampleFileIfNotExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                String content = "Hello World!\nUTF-8 Encoded Characters: α, β, γ, δ, €\nByte streams converted to character streams seamlessly.\n";
                fos.write(content.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                System.err.println("Could not create sample byte file: " + e.getMessage());
            }
        }
    }

    public static void readByteStreamAsChars(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("File not found: " + filePath);
            return;
        }

        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isr)) {

            System.out.println("\n--- Reading Character Stream using InputStreamReader (" + isr.getEncoding() + ") ---");
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
            System.out.println("--- End of Stream ---");

        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter file path (or press Enter for 'sample_bytes.txt'): ");
            String filePath = scanner.nextLine().trim();

            if (filePath.isEmpty()) {
                filePath = "sample_bytes.txt";
                createSampleFileIfNotExists(filePath);
            }

            readByteStreamAsChars(filePath);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
