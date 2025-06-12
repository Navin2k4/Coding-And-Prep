package Arrays;

import java.util.Arrays;

class ProductExceptSelf {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 6 };
        // productExceptSelfBrute(arr);
        productExceptSelf(arr);
    }

    // left prefix and right suffix;
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = left[i] * right;
            right *= nums[i];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(result));
        return result;
    }

    static int[] productExceptSelfBrute(int[] nums) {
        int zeroCount = 0;
        int totalProduct = 1;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                totalProduct *= num;
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 1) {
                return result;
            } else if (zeroCount == 1) {
                result[i] = nums[i] == 0 ? totalProduct : 0;
            } else {
                result[i] = totalProduct / nums[i];
            }
        }

        System.out.println(Arrays.toString(result));
        return result;

    }

}
