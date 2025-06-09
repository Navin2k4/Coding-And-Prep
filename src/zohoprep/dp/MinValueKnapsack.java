package zohoprep.dp;

import java.util.Arrays;

public class MinValueKnapsack {
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int W = 5;

        int minValue = minValueKnapsack(weights, values, W);
        if (minValue == Integer.MAX_VALUE) {
            System.out.println("No subset with total weight " + W);
        } else {
            System.out.println("Minimum value for weight " + W + " is: " + minValue);
        }
    }

    static int minValueKnapsack(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        // Initialize: use MAX to represent impossible cases
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0; // Base: 0 weight requires 0 value

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                // Case 1: Do not include the current item
                if (dp[i - 1][w] != Integer.MAX_VALUE)
                    dp[i][w] = dp[i - 1][w];

                // Case 2: Include the current item if possible
                if (w >= weights[i - 1] && dp[i - 1][w - weights[i - 1]] != Integer.MAX_VALUE) {
                    dp[i][w] = Math.min(dp[i][w],
                            dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        return dp[n][W];
    }
}
