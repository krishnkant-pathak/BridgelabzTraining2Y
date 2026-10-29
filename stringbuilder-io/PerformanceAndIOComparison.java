import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PerformanceAndIOComparison {

    public static void generateTestFile(String filePath, int lineCount) {
        File file = new File(filePath);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                for (int i = 0; i < lineCount; i++) {
                    writer.write("Java Data Structures and Algorithms performance benchmark line number " + i + "\n");
                }
            } catch (IOException e) {
                System.err.println("Error generating test file: " + e.getMessage());
            }
        }
    }

    public static void compareStringConcatenation(int iterations) {
        System.out.println("--- Part 1: String Concatenation Benchmark (" + iterations + " iterations) ---");
        String sample = "benchmark";

        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(sample);
        }
        long endBuilder = System.nanoTime();
        double builderMs = (endBuilder - startBuilder) / 1_000_000.0;

        long startBuffer = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append(sample);
        }
        long endBuffer = System.nanoTime();
        double bufferMs = (endBuffer - startBuffer) / 1_000_000.0;

        System.out.printf("StringBuilder Time: %.2f ms%n", builderMs);
        System.out.printf("StringBuffer Time:  %.2f ms%n", bufferMs);
        System.out.println("Result: StringBuilder is faster due to lack of thread synchronization overhead.\n");
    }

    public static void compareFileReading(String filePath) {
        System.out.println("--- Part 2: File Reading Benchmark (" + filePath + ") ---");

        long startFR = System.nanoTime();
        long wordsFR = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordsFR += words.length;
            }
        } catch (IOException e) {
            System.err.println("FileReader error: " + e.getMessage());
        }
        long endFR = System.nanoTime();
        double frMs = (endFR - startFR) / 1_000_000.0;

        long startISR = System.nanoTime();
        long wordsISR = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                wordsISR += words.length;
            }
        } catch (IOException e) {
            System.err.println("InputStreamReader error: " + e.getMessage());
        }
        long endISR = System.nanoTime();
        double isrMs = (endISR - startISR) / 1_000_000.0;

        System.out.printf("FileReader:        Words Counted = %d | Time = %.2f ms%n", wordsFR, frMs);
        System.out.printf("InputStreamReader: Words Counted = %d | Time = %.2f ms%n", wordsISR, isrMs);
        System.out.println("Result: Both perform buffered reads efficiently; InputStreamReader allows explicit charset decoding.\n");
    }

    public static void main(String[] args) {
        String testFilePath = "benchmark_test_file.txt";
        generateTestFile(testFilePath, 50_000);

        compareStringConcatenation(1_000_000);
        compareFileReading(testFilePath);
    }
}
