/**
 * Test class for the FinancialForecaster.
 * Compares recursive vs iterative approach with realistic investment values.
 */
public class ForecastingTest {

    public static void main(String[] args) {

        // Realistic investment scenario
        double presentValue = 1000.0;   // starting with $1000
        double growthRate = 0.08;       // 8% annual growth
        int years = 10;                 // projecting 10 years ahead

        System.out.println("=== Financial Forecasting Test ===\n");
        System.out.println("Present Value:  $" + String.format("%.2f", presentValue));
        System.out.println("Growth Rate:    " + (growthRate * 100) + "%");
        System.out.println("Time Period:    " + years + " years");
        System.out.println();

        // --- Recursive Version ---
        long startTime = System.nanoTime();
        double recursiveResult = FinancialForecaster.calculateFutureValue(presentValue, growthRate, years);
        long recursiveTime = System.nanoTime() - startTime;

        System.out.printf("Recursive Result:  $%.2f%n", recursiveResult);
        System.out.println("Time taken:        " + recursiveTime + " ns");
        System.out.println();

        // --- Iterative (Optimized) Version ---
        startTime = System.nanoTime();
        double iterativeResult = FinancialForecaster.calculateFutureValueOptimized(presentValue, growthRate, years);
        long iterativeTime = System.nanoTime() - startTime;

        System.out.printf("Iterative Result:  $%.2f%n", iterativeResult);
        System.out.println("Time taken:        " + iterativeTime + " ns");
        System.out.println();

        // --- Testing with larger year values ---
        System.out.println("--- Testing with 50 years ---");
        double longTermRecursive = FinancialForecaster.calculateFutureValue(presentValue, growthRate, 50);
        double longTermIterative = FinancialForecaster.calculateFutureValueOptimized(presentValue, growthRate, 50);
        System.out.printf("Recursive (50 yrs):  $%.2f%n", longTermRecursive);
        System.out.printf("Iterative (50 yrs):  $%.2f%n", longTermIterative);
        System.out.println();

        // --- Analysis ---
        System.out.println("=== Time Complexity & Optimization Analysis ===");
        System.out.println();
        System.out.println("Both versions have O(n) time complexity where n = years,");
        System.out.println("since each year requires exactly one multiplication.");
        System.out.println();
        System.out.println("The key difference is space complexity:");
        System.out.println("- Recursive: O(n) space because each call adds to the stack.");
        System.out.println("  For very large values of n (like 100,000 years), this will");
        System.out.println("  cause a StackOverflowError and crash the program.");
        System.out.println();
        System.out.println("- Iterative: O(1) space - it just uses a single variable in a loop.");
        System.out.println("  It can handle any number of years without running out of memory.");
        System.out.println();
        System.out.println("Memoization doesn't help much here because there are no overlapping");
        System.out.println("subproblems - each year's value depends only on the previous year.");
        System.out.println("The iterative version is the best optimization for this particular");
        System.out.println("problem. It's simpler, faster, and more memory-efficient.");
    }
}
