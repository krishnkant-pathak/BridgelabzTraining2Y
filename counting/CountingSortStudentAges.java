import java.util.Scanner;

public class CountingSortStudentAges {

    public static void countingSort(int[] ages) {
        int n = ages.length;
        if (n <= 1) {
            return;
        }

        int minAge = 10;
        int maxAge = 18;

        for (int age : ages) {
            if (age < minAge) minAge = age;
            if (age > maxAge) maxAge = age;
        }

        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[ages[i] - minAge]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int age = ages[i];
            int position = count[age - minAge] - 1;
            output[position] = age;
            count[age - minAge]--;
        }

        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
        }
    }

    public static void printAges(int[] ages) {
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter number of students: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.err.println("Invalid number of students! Must be greater than 0.");
                return;
            }

            int[] ages = new int[n];
            System.out.println("Enter ages for " + n + " students (10 - 18):");
            for (int i = 0; i < n; i++) {
                System.out.print("Student " + (i + 1) + " age: ");
                ages[i] = scanner.nextInt();
                if (ages[i] < 10 || ages[i] > 18) {
                    System.err.println("Student age should typically be between 10 and 18. Please re-enter.");
                    i--;
                }
            }

            System.out.println("\n--- Before Sorting ---");
            System.out.print("Student Ages: ");
            printAges(ages);

            countingSort(ages);

            System.out.println("\n--- After Counting Sort (Ascending Order) ---");
            System.out.print("Sorted Student Ages: ");
            printAges(ages);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
