package DynamicProgramming.OneDArray;

import java.util.Arrays;

public class MaxSumOfNonAdjacentHouseRobber {
    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3, 1 };
        int[] nums = { 2, 7, 9, 3, 1 };
        int n = nums.length - 1;

        // System.out.println(robRec(n, nums));

        int[] memDP = new int[n + 1];
        Arrays.fill(memDP, -1);
        System.out.println(robRecMem(n, nums, memDP));

        System.out.println(robRecTab(nums));

        System.out.println(robRecOptimized(nums));
    }

    static int robRec(int i, int[] nums) {
        if (i == 0)
            return nums[i];
        if (i < 0)
            return 0;

        int pick = nums[i] + robRec(i - 2, nums);
        int notPick = robRec(i - 1, nums);

        return Math.max(pick, notPick);
    }

    static int robRecMem(int i, int[] nums, int[] memDP) {
        if (i == 0)
            return nums[i];
        if (i < 0)
            return 0;

        if (memDP[i] != -1)
            return memDP[i];

        int pick = nums[i] + robRec(i - 2, nums);
        int notPick = robRec(i - 1, nums);

        return memDP[i] = Math.max(pick, notPick);
    }

    static int robRecTab(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1)
                pick += dp[i - 2];
            int notPick = dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

    static int robRecOptimized(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1)
                pick += prev2;
            int notPick = prev;
            int current = Math.max(pick, notPick);
            prev2 = prev;
            prev = current;
        }
        return prev;
    }
}
