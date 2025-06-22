package DynamicProgramming.OneDArray;

import java.util.Arrays;

public class HouseRobberTwo {
    public static void main(String[] args) {

        // the new constraint is the house are arranges in circulary way

        // int[] nums = { 1, 2, 3, 1 }; //4
        // int[] nums = { 2,3,2 }; //
        int[] nums = { 1, 2, 3, 1 };
        int n = nums.length;

        int withoutFirst[] = new int[n];
        int withoutLast[] = new int[n];
        for (int i = 1; i < n; i++) {
            withoutFirst[i] = nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            withoutLast[i] = nums[i];
        }
        int wF = robRec(n - 1, withoutFirst);
        int wL = robRec(n - 1, withoutLast);
        System.out.println(Math.max(wF, wL));

        // using the wF and wL can help in working out for all
        int[] memDP = new int[n + 1];
        Arrays.fill(memDP, -1);
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
