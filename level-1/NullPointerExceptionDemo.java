public class NullPointerExceptionDemo {

    public static void generateException() {
        String text = null;
        System.out.println("String length: " + text.length());
    }

    public static void handleException() {
        String text = null;
        try {
            System.out.println("Attempting to access length of null string...");
            System.out.println("String length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.toString());
            System.out.println("Cannot invoke methods on a null reference.");
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Demonstrating NullPointerException Handling ===");
        handleException();
    }
}
