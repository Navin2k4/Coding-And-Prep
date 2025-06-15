// ? https://leetcode.com/problems/split-array-largest-sum/description/
// * 410
// ! GOOGLE

package BinarySearch;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
        // System.out.println(splitArray(new int[]{1,2,3,4,5}, 2));
        System.out.println(splitArray(new int[] { 1, 4, 4 }, 3));
    }

    static int splitArray(int[] nums, int k) {
        int low = getMax(nums);
        int high = getSum(nums);
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean possible = isPossible(nums, k, mid);
            if (possible) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    static boolean isPossible(int[] nums, int k, int maxSumAllowed) {
        int subArrayCount = 1;
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum + num > maxSumAllowed) {
                subArrayCount++;
                currentSum = num;
                if (subArrayCount > k)
                    return false;
            } else {
                currentSum += num;
            }
        }
        return true;
    }

    static int getMax(int[] arr) {
        int max = arr[0];
        for (int x : arr)
            max = Math.max(max, x);
        return max;
    }

    static int getSum(int[] weights) {
        int totalWeights = 0;
        for (int x : weights) {
            totalWeights += x;
        }
        return totalWeights;
    }

}
