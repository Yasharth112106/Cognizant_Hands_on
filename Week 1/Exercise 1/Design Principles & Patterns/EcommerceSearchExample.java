
import java.util.Arrays;

public class EcommerceSearchExample {

    // Step 2: Product class
    static class Product implements Comparable<Product> {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return productId + ": " + productName + " [" + category + "]";
        }

        // Needed for sorting (used in binary search)
        @Override
        public int compareTo(Product other) {
            return this.productName.compareTo(other.productName);
        }
    }

    // Step 3a: Linear search by product name
    static Product linearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(targetName)) {
                return p;
            }
        }
        return null;
    }

    // Step 3b: Binary search (array must be sorted by productName)
    static Product binarySearch(Product[] sortedProducts, String targetName) {
        int left = 0, right = sortedProducts.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = sortedProducts[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0) {
                return sortedProducts[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Step 5: Main function to test and analyze
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "T-Shirt", "Clothing"),
            new Product(3, "Book", "Education"),
            new Product(4, "Phone", "Electronics"),
            new Product(5, "Shoes", "Footwear")
        };

        System.out.println("=== Linear Search ===");
        Product found1 = linearSearch(products, "Book");
        System.out.println(found1 != null ? found1 : "Product not found.");

        // Prepare sorted array for binary search
        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts);

        System.out.println("=== Binary Search ===");
        Product found2 = binarySearch(sortedProducts, "Book");
        System.out.println(found2 != null ? found2 : "Product not found.");

        // Step 4: Time complexity analysis
        System.out.println("\n=== Analysis ===");
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n)");
        System.out.println("Binary search is faster but requires a sorted array.");
    }
}
