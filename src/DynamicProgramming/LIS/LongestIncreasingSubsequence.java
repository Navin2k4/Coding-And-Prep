package DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(solveRec(arr, 0, -1));

        int n = arr.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(solveMem(arr, 0, -1, dp));
    }

    static int solveRec(int[] nums, int index, int prevIndex) {
        if (index == nums.length)
            return 0;
        int notPick = solveRec(nums, index + 1, prevIndex);
        int pick = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            pick = 1 + solveRec(nums, index + 1, index);
        }

        return Math.max(pick, notPick);
    }

    static int solveMem(int[] nums, int index, int prevIndex, int[][] dp) {
        if (index == nums.length)
            return 0;

        if (dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];

        int notPick = solveMem(nums, index + 1, prevIndex, dp);

        int pick = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            pick = 1 + solveMem(nums, index + 1, index, dp);
        }

        return dp[index][prevIndex + 1] = Math.max(pick, notPick);
    }

}
