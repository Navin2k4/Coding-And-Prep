package Arrays;

import java.util.ArrayList;

public class MaximumSubArraySum {
    public static void main(String[] args) {
        // int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        // int[] arr = {-71 ,92, 0, 67 ,-8 ,67 ,-78 ,-7};
        // int[] arr = { 1, 2, 5, -7, 2, 6 };
        int[] arr = { -838 ,-329};
        // System.out.println(maxSubArray(arr));
        // System.out.println((maxSubArrayAsArray(arr)));
        System.out.println((findSubarrayGFG(arr)));
    }

    static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    static ArrayList<Integer> maxSubArrayAsArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int resStart = -1;
        int resEnd = -1;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {

            if (sum == 0)
                start = i;

            sum = sum + nums[i];

            if (sum > max) {
                max = sum;
                resStart = start;
                resEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }

        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int k = resStart; k <= resEnd; k++) {
            res.add(nums[k]);
        }
        return res;
    }

     static ArrayList<Integer> findSubarrayGFG(int arr[]) {
        int maxSum = -1;
        int currSum = 0;
        int start = 0;
        int resStart = -1;
        int resEnd = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                currSum += arr[i];
            } else {
                if (currSum > maxSum || (currSum == maxSum && resStart > start)) {
                    maxSum = currSum;
                    resStart = start;
                    resEnd = i - 1;
                }
                currSum = 0;
                start = i + 1;
            }
        }

        if (currSum > maxSum || (currSum == maxSum && resStart > start)) {
            maxSum = currSum;
            resStart = start;
            resEnd = arr.length - 1;
        }

        ArrayList<Integer>
         res = new ArrayList<>();
        System.out.println(resStart + " " + resEnd);
        if (resStart == -1 || resEnd == -1) {
            res.add(-1);
        } else {
            for (int k = resStart; k <= resEnd; k++) {
                res.add(arr[k]);
            }
        }

        return res;
    }

}
