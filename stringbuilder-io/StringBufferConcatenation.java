import java.util.Scanner;

public class StringBufferConcatenation {

    public static String concatenateStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        StringBuffer buffer = new StringBuffer();

        for (String str : strings) {
            buffer.append(str);
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of string elements: ");
            int count = scanner.nextInt();
            scanner.nextLine();

            if (count <= 0) {
                System.err.println("Count must be greater than 0.");
                return;
            }

            String[] strings = new String[count];
            System.out.println("Enter " + count + " strings:");
            for (int i = 0; i < count; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                strings[i] = scanner.nextLine();
            }

            String result = concatenateStrings(strings);

            System.out.println("\n--- Concatenation Result ---");
            System.out.println("Concatenated String: \"" + result + "\"");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
