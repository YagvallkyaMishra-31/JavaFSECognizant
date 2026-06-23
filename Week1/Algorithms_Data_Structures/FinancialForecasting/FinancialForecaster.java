/**
 * FinancialForecaster - Predicts future value of investments using recursion.
 *
 * === What is Recursion? ===
 *
 * Recursion is when a method calls itself to solve smaller pieces of the same
 * problem. Each call handles one "step" and passes the rest of the work to the
 * next call. It keeps going until it hits a base case (the simplest version of
 * the problem that can be answered directly).
 *
 * For financial forecasting, each recursive call applies one year's growth.
 * So for 10 years, the method calls itself 10 times, each time applying the
 * growth rate once.
 *
 * Think of it like compound interest being applied year by year:
 *   Year 0: $1000.00 (base case, no growth yet)
 *   Year 1: $1000.00 * 1.08 = $1080.00
 *   Year 2: $1080.00 * 1.08 = $1166.40
 *   ... and so on
 */
public class FinancialForecaster {

    /**
     * Recursive version: calculates future value by applying growth one year at a time.
     *
     * Formula applied recursively: FV = PV * (1 + growthRate) for each year
     *
     * Time Complexity:  O(n) where n = number of years
     *   - We make exactly one recursive call per year
     *
     * Space Complexity: O(n) due to the call stack
     *   - Each recursive call adds a frame to the stack
     *   - For 10,000 years, that's 10,000 stack frames which could cause StackOverflow
     *
     * @param presentValue the current value of the investment
     * @param growthRate   annual growth rate (e.g., 0.08 for 8%)
     * @param years        number of years to project into the future
     * @return the projected future value
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: no more years left, just return what we have
        if (years == 0) {
            return presentValue;
        }

        // Recursive case: apply one year of growth, then recurse for remaining years
        // Each call handles exactly one year and delegates the rest
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    /**
     * Optimized (iterative) version: uses a loop instead of recursion.
     *
     * Why this is better:
     * - Time Complexity is still O(n), same number of multiplications
     * - Space Complexity drops to O(1) - no call stack buildup
     * - Won't crash with StackOverflowError even for thousands of years
     * - Slightly faster in practice because there's no overhead of function calls
     *
     * Memoization isn't super useful here since each step depends on the previous
     * one (no overlapping subproblems). But the iterative approach gives us the
     * same benefit - avoiding deep recursion - in a simpler way.
     *
     * @param presentValue the current value of the investment
     * @param growthRate   annual growth rate (e.g., 0.08 for 8%)
     * @param years        number of years to project into the future
     * @return the projected future value
     */
    public static double calculateFutureValueOptimized(double presentValue, double growthRate, int years) {
        double futureValue = presentValue;

        // Just apply the growth rate once for each year in a loop
        for (int i = 0; i < years; i++) {
            futureValue = futureValue * (1 + growthRate);
        }

        return futureValue;
    }
}
