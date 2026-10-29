public class CompareStringBufferStringBuilder {

    public static void main(String[] args) {
        int iterations = 1_000_000;
        String textToAppend = "hello";

        System.out.println("Starting Benchmark: Appending \"" + textToAppend + "\" " + iterations + " times...\n");

        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(textToAppend);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;
        double durationBuilderMs = durationBuilder / 1_000_000.0;

        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(textToAppend);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;
        double durationBufferMs = durationBuffer / 1_000_000.0;

        System.out.println("==========================================================");
        System.out.printf("%-18s | %-16s | %-16s%n", "Class", "Time (ns)", "Time (ms)");
        System.out.println("==========================================================");
        System.out.printf("%-18s | %-16d | %-16.2f%n", "StringBuilder", durationBuilder, durationBuilderMs);
        System.out.printf("%-18s | %-16d | %-16.2f%n", "StringBuffer", durationBuffer, durationBufferMs);
        System.out.println("==========================================================");

        if (durationBuilder < durationBuffer) {
            double factor = (double) durationBuffer / durationBuilder;
            System.out.printf("Conclusion: StringBuilder was %.2fx faster than StringBuffer due to lack of synchronization overhead.%n", factor);
        } else {
            System.out.println("Conclusion: Both classes showed comparable performance.");
        }
    }
}
