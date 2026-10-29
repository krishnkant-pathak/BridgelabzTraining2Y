import java.util.Scanner;

public class CompareStrings {

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the first string: ");
            String firstString = scanner.next();

            System.out.print("Enter the second string: ");
            String secondString = scanner.next();

            boolean customCompareResult = compareStrings(firstString, secondString);

            boolean builtInCompareResult = firstString.equals(secondString);

            System.out.println("\n--- Comparison Results ---");
            System.out.println("Custom compareStrings() result: " + customCompareResult);
            System.out.println("Built-in equals() result: " + builtInCompareResult);

            if (customCompareResult == builtInCompareResult) {
                System.out.println("Both methods produced the same result!");
            } else {
                System.out.println("The results differ between the two methods.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
