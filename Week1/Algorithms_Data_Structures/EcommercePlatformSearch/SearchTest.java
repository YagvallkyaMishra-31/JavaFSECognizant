import java.util.Arrays;

/**
 * Test class to demonstrate and compare linear search vs binary search
 * on a realistic set of e-commerce products.
 */
public class SearchTest {

    public static void main(String[] args) {

        // Setting up a realistic product catalog
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Headphones", "Electronics"),
            new Product(103, "Smartphone", "Electronics"),
            new Product(104, "Running Shoes", "Footwear"),
            new Product(105, "Backpack", "Accessories"),
            new Product(106, "Desk Lamp", "Home & Office"),
            new Product(107, "Water Bottle", "Sports"),
            new Product(108, "Wireless Mouse", "Electronics"),
            new Product(109, "Yoga Mat", "Fitness"),
            new Product(110, "Sunglasses", "Accessories")
        };

        String target = "Wireless Mouse";
        System.out.println("=== E-commerce Product Search Test ===\n");
        System.out.println("Searching for: \"" + target + "\"");
        System.out.println("Total products in catalog: " + products.length);
        System.out.println();

        // -------- Linear Search --------
        System.out.println("--- Linear Search ---");

        long startTime = System.nanoTime();
        Product linearResult = SearchAlgorithms.linearSearch(products, target);
        long linearTime = System.nanoTime() - startTime;

        if (linearResult != null) {
            System.out.println("Found: " + linearResult);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Time taken: " + linearTime + " nanoseconds\n");

        // -------- Binary Search --------
        // Binary search needs a sorted array, so we sort first
        Arrays.sort(products); // uses our compareTo method (sorts by name)
        System.out.println("--- Binary Search (after sorting by name) ---");

        startTime = System.nanoTime();
        Product binaryResult = SearchAlgorithms.binarySearch(products, target);
        long binaryTime = System.nanoTime() - startTime;

        if (binaryResult != null) {
            System.out.println("Found: " + binaryResult);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Time taken: " + binaryTime + " nanoseconds\n");

        // -------- Time Comparison --------
        System.out.println("=== Performance Comparison ===");
        System.out.println("Linear Search Time:  " + linearTime + " ns");
        System.out.println("Binary Search Time:  " + binaryTime + " ns");

        if (linearTime > binaryTime) {
            System.out.println("Binary search was faster by " + (linearTime - binaryTime) + " ns");
        } else {
            System.out.println("Linear search was faster by " + (binaryTime - linearTime) + " ns");
        }
        System.out.println();

        // -------- Analysis --------
        System.out.println("=== Analysis ===");
        System.out.println("Linear search has O(n) time complexity - it checks every product");
        System.out.println("one by one, which is simple but slow for large catalogs.");
        System.out.println();
        System.out.println("Binary search has O(log n) time complexity - it cuts the search");
        System.out.println("space in half each time. For a catalog of 1 million products,");
        System.out.println("linear search might need up to 1,000,000 comparisons while");
        System.out.println("binary search needs only about 20.");
        System.out.println();
        System.out.println("For an e-commerce platform, binary search is clearly better");
        System.out.println("because product catalogs are usually large and searches happen");
        System.out.println("constantly. The one-time cost of sorting the data is worth it.");
        System.out.println("In practice, platforms use even faster approaches like hash maps");
        System.out.println("or database indexes, but binary search is a great improvement");
        System.out.println("over linear search as a starting point.");
    }
}
