// Exercise 7: Financial Forecasting using Recursion in one file

public class FinancialForecasting {

    // Recursive function to calculate future value
    // Formula: futureValue(n) = futureValue(n-1) * (1 + growthRate)
    static double predictFutureValue(int years, double growthRate, double baseValue) {
        if (years == 0) {
            return baseValue; // Base case
        }
        return predictFutureValue(years - 1, growthRate, baseValue) * (1 + growthRate);
    }

    // Optimized version using memoization to avoid repeated computation
    static double predictFutureValueMemo(int years, double growthRate, double baseValue, double[] memo) {
        if (years == 0) {
            return baseValue;
        }
        if (memo[years] != 0) {
            return memo[years]; // Return cached result
        }
        memo[years] = predictFutureValueMemo(years - 1, growthRate, baseValue, memo) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {
        double baseValue = 1000.0;     // Initial investment
        double growthRate = 0.05;      // 5% annual growth
        int years = 10;                // Forecast for 10 years

        // 1. Simple Recursive Calculation
        double resultRecursive = predictFutureValue(years, growthRate, baseValue);
        System.out.printf("Future value after %d years (recursive): %.2f%n", years, resultRecursive);

        // 2. Optimized using Memoization
        double[] memo = new double[years + 1];
        double resultMemo = predictFutureValueMemo(years, growthRate, baseValue, memo);
        System.out.printf("Future value after %d years (memoized): %.2f%n", years, resultMemo);
    }
}
