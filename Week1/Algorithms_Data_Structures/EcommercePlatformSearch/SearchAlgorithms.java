/**
 * SearchAlgorithms - Contains linear and binary search implementations for products.
 *
 * === Understanding Big O Notation ===
 *
 * Big O notation describes how the running time (or space) of an algorithm grows
 * as the input size increases. It gives us a way to compare algorithms without
 * worrying about hardware or language differences.
 *
 * Why it matters:
 * - Helps us pick the right algorithm for our data size
 * - An O(n) algorithm might be fine for 100 items, but terrible for 10 million
 * - In e-commerce, where we might have millions of products, choosing the
 *   right search algorithm can mean the difference between milliseconds and seconds
 *
 * === Search Operation Complexities ===
 *
 * Linear Search:
 *   Best case:    O(1)   - target is the very first element
 *   Average case: O(n)   - target is somewhere in the middle on average
 *   Worst case:   O(n)   - target is at the end or not in the array at all
 *
 * Binary Search:
 *   Best case:    O(1)     - target is exactly at the middle
 *   Average case: O(log n) - we keep halving the search space
 *   Worst case:   O(log n) - even in the worst case we only do log2(n) comparisons
 *   NOTE: Requires the array to be sorted first (sorting costs O(n log n))
 */
public class SearchAlgorithms {

    /**
     * Linear Search - simply walks through every element one by one.
     *
     * Time Complexity: O(n)
     * We may have to check every single product in the worst case.
     *
     * @param products   the array to search through
     * @param targetName the product name we're looking for
     * @return the matching Product, or null if not found
     */
    public static Product linearSearch(Product[] products, String targetName) {
        // Go through each product and check if the name matches
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(targetName)) {
                return products[i]; // found it!
            }
        }
        return null; // went through everything, didn't find it
    }

    /**
     * Binary Search - keeps dividing the sorted array in half.
     *
     * Time Complexity: O(log n)
     * Each step eliminates half the remaining products, so even with
     * a million products we only need ~20 comparisons.
     *
     * IMPORTANT: The array MUST be sorted by productName before calling this.
     *
     * @param products   the SORTED array to search through
     * @param targetName the product name we're looking for
     * @return the matching Product, or null if not found
     */
    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoids potential overflow vs (low+high)/2

            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid]; // found the product at the middle
            } else if (comparison < 0) {
                // middle product comes before target alphabetically, search right half
                low = mid + 1;
            } else {
                // middle product comes after target alphabetically, search left half
                high = mid - 1;
            }
        }

        return null; // product not in the array
    }
}
