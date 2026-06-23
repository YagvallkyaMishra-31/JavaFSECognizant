/**
 * Product class - a simple POJO representing a product on an e-commerce platform.
 * Implements Comparable so we can sort products by name (needed for binary search).
 */
public class Product implements Comparable<Product> {

    private int productId;
    private String productName;
    private String category;

    // Constructor to initialize all fields at once
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // --- Getters ---

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    // --- Setters ---

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Nice readable format when we print a product
    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }

    /**
     * Compare products alphabetically by name.
     * This is what Arrays.sort() will use to sort our product array
     * before we do binary search on it.
     */
    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }
}
