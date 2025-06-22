package DynamicProgramming.OneDArray;

import java.util.Arrays;

public class CountStairs {
    public static void main(String[] args) {
        // You are climbing a staircase. It takes n steps to reach the top.
        // Each time you can either climb 1 or 2 steps. In how many distinct
        // ways can you climb to the top?
        // System.out.println(climbStairsTab(2)); // 1,1 or 2
        System.out.println(climbStairsTab(3)); // 1,1,1 or 2,1 or 1,2

        System.out.println(climbStairsTab(3)); // 1,1,1 or 2,1 or 1,2

        int n = 3;
        int[] memDP = new int[n + 1];
        Arrays.fill(memDP, -1);
        System.out.println(climbStairsMemo(n, memDP));
    }

    static int climbStairsRec(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        return climbStairsRec(n - 1) + climbStairsRec(n - 2);
    }

    static int climbStairsTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            // System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    static int climbStairsMemo(int n, int[] dp) {
        if (n == 1 || n == 0)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = climbStairsMemo(n - 1, dp) + climbStairsMemo(n - 2, dp);
    }

}
