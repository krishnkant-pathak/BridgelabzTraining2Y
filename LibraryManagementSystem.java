public class LibraryManagementSystem {

    // ==========================================
    // Data Model: Book Class
    // ==========================================
    static class Book {
        int bookId;
        String title;
        String author;
        double price;

        public Book(int bookId, String title, String author, double price) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.price = price;
        }

        @Override
        public String toString() {
            return "[" + bookId + "] " + title + " - Rs. " + price;
        }
    }

    // =========================================================================
    // Task 1: Store books & remove duplicate records in-place
    // Time Complexity: O(N) | Space Complexity: O(1)
    // =========================================================================
    public static int removeDuplicates(Book[] books, int n) {
        if (n <= 1) {
            return n;
        }

        // Pointer for the position of the last unique element found
        int uniqueIndex = 0;

        for (int i = 1; i < n; i++) {
            // Since books are sorted by bookId, compare current with the last unique book
            if (books[i].bookId != books[uniqueIndex].bookId) {
                uniqueIndex++;
                books[uniqueIndex] = books[i]; // Overwrite in-place
            }
        }

        // The count of unique books is uniqueIndex + 1
        return uniqueIndex + 1;
    }

    // =========================================================================
    // Task 2: Search books using partial title (case-insensitive)
    // Time Complexity: O(N * L) where L is the title length | Space Complexity: O(1)
    // =========================================================================
    public static void searchByTitle(Book[] books, int count, String query) {
        System.out.println("Search Results for '" + query + "':");
        boolean found = false;
        String lowerQuery = query.toLowerCase();

        for (int i = 0; i < count; i++) {
            if (books[i].title.toLowerCase().contains(lowerQuery)) {
                System.out.println("- Found: [" + books[i].bookId + "] " + books[i].title + " (Rs. " + books[i].price + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("- No books found matching '" + query + "'");
        }
    }

    // =========================================================================
    // Task 3: Sort books by price in ascending order using Selection Sort
    // Time Complexity: O(N^2) | Space Complexity: O(1)
    // =========================================================================
    public static void sortByPrice(Book[] books, int count) {
        int swapCount = 0;

        // Selection sort: find minimum in unsorted part and swap with first unsorted position
        for (int i = 0; i < count - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (books[j].price < books[minIndex].price) {
                    minIndex = j;
                }
            }

            // Only swap if the minimum element is not already at index i
            if (minIndex != i) {
                Book temp = books[i];
                books[i] = books[minIndex];
                books[minIndex] = temp;
                swapCount++;
            }
        }

        // Print sorted books
        System.out.println("Books Sorted by Price:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + books[i]);
        }
        System.out.println("Total Swaps: " + swapCount);
    }

    // =========================================================================
    // Task 4: Search a book by price in O(log N) time using Binary Search
    // Time Complexity: O(log N) | Space Complexity: O(1)
    // =========================================================================
    public static int searchByPrice(Book[] books, int count, double targetPrice) {
        int low = 0;
        int high = count - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Using Double.compare for floating-point comparison
            int cmp = Double.compare(books[mid].price, targetPrice);

            if (cmp == 0) {
                return mid; // Book found
            } else if (cmp < 0) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }

        return -1; // Book not found
    }

    // =========================================================================
    // Task 5: Minimum consecutive books whose total price >= S (Sliding Window)
    // Time Complexity: O(N) | Auxiliary Space Complexity: O(1)
    // =========================================================================
    public static int minBooksForTargetCost(Book[] books, int count, double targetCost) {
        int minLength = Integer.MAX_VALUE;
        double currentSum = 0.0;
        int left = 0;

        // Expand the window by adding books from the right
        for (int right = 0; right < count; right++) {
            currentSum += books[right].price;

            // Whenever currentSum >= targetCost, record window length and contract from left
            while (currentSum >= targetCost) {
                int currentWindowLength = right - left + 1;
                if (currentWindowLength < minLength) {
                    minLength = currentWindowLength;
                }
                currentSum -= books[left].price;
                left++;
            }
        }

        // If no valid contiguous window was found, return 0
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    // =========================================================================
    // Main Method: Test Harness with Sample Case
    // =========================================================================
    public static void main(String[] args) {
        // Initial Input Array (6 Books with 1 Duplicate, sorted by bookId)
        Book[] books = new Book[] {
            new Book(101, "Data Structures", "Mark", 400.0),
            new Book(101, "Data Structures", "Mark", 400.0), // Duplicate
            new Book(102, "Java Basics", "James", 300.0),
            new Book(103, "Python Guide", "Guido", 600.0),
            new Book(104, "Database Systems", "Raghu", 500.0),
            new Book(105, "Computer Networks", "Andrew", 700.0)
        };
        int totalBooks = books.length;

        System.out.println("=================================================");
        System.out.println("   SMART LIBRARY MANAGEMENT SYSTEM (DSA DEMO)   ");
        System.out.println("=================================================\n");

        // -----------------------------------------------------------------
        // Task 1: Remove Duplicates
        // -----------------------------------------------------------------
        System.out.println("1. After Task 1 (Remove Duplicates):");
        int uniqueCount = removeDuplicates(books, totalBooks);
        System.out.println("Unique Books Count: " + uniqueCount);
        System.out.println("Book List:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(books[i]);
        }
        System.out.println();

        // -----------------------------------------------------------------
        // Task 2: Partial Title Search
        // -----------------------------------------------------------------
        System.out.println("2. After Task 2 (Search Query: \"data\"):");
        searchByTitle(books, uniqueCount, "data");
        System.out.println();

        // -----------------------------------------------------------------
        // Task 3: Sort by Price
        // -----------------------------------------------------------------
        System.out.println("3. After Task 3 (Sort by Price):");
        sortByPrice(books, uniqueCount);
        System.out.println();

        // -----------------------------------------------------------------
        // Task 4: Search by Price
        // -----------------------------------------------------------------
        double targetPrice = 500.0;
        System.out.println("4. After Task 4 (Search for Price: " + targetPrice + "):");
        System.out.println("Searching for Price Rs. " + targetPrice + "...");
        int foundIndex = searchByPrice(books, uniqueCount, targetPrice);
        if (foundIndex != -1) {
            System.out.println("Result: Book found at index " + foundIndex + ": [" 
                + books[foundIndex].bookId + "] " + books[foundIndex].title 
                + " (Rs. " + books[foundIndex].price + ")");
        } else {
            System.out.println("Result: Book with price Rs. " + targetPrice + " not found.");
        }
        System.out.println();

        // -----------------------------------------------------------------
        // Task 5: Sliding Window for Target Cost
        // -----------------------------------------------------------------
        double targetCost = 1000.0;
        System.out.println("5. After Task 5 (Sliding Window for Target Cost S = Rs. " + targetCost + "):");
        System.out.println("Finding minimum consecutive books whose total price >= Rs. " + targetCost + "...");
        int minBooks = minBooksForTargetCost(books, uniqueCount, targetCost);
        System.out.println("Minimum Consecutive Books Needed: " + minBooks);
    }
}
