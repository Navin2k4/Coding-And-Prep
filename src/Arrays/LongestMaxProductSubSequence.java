package Arrays;


import java.util.ArrayList;
import java.util.List;

class LongestMaxProductSubSequence {
    public static void main(String[] args) {
        // int nums[] = { -1, -9, 2, 3, -2, -3, 1 };
        // int m = 1;
        int nums[] = { 1,3,-5,5,6,-4 };
        int m = 3;
        System.out.println(maximumProductMaxOP(nums, m));
    }

    static long maximumProduct(int[] nums, int m) {
        long[] maxProduct = new long[] { Long.MIN_VALUE };
        dfs(nums, 0, m, new ArrayList<>(), maxProduct);
        return maxProduct[0];
    }
    static void dfs(int[] nums, int idx, int m, List<Integer> path, long[] maxProduct) {
        if (path.size() == m) {
            int first = path.get(0);
            int last = path.get(path.size() - 1);
            long product = 1L * first * last;
            if (product > maxProduct[0]) {
                maxProduct[0] = product;
            }
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, m, path, maxProduct);
            path.remove(path.size() - 1);
        }
    }

     public static long maximumProductOP(int[] nums, int m) {
        int n = nums.length;
        if (m == 1) {
            long max = Long.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, 1L * num * num);
            }
            return max;
        }

        long maxProduct = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + m - 1; j < n; j++) {
                if (j - i + 1 >= m) {
                    maxProduct = Math.max(maxProduct, 1L * nums[i] * nums[j]);
                }
            }
        }

        return maxProduct;
    }

    public static long maximumProductMaxOP(int[] nums, int m) {
        int n = nums.length;
        if (m == 1) {
            long best = Long.MIN_VALUE;
            for (int x : nums) {
                best = Math.max(best, 1L * x * x);
            }
            return best;
        }
        
        long[] prefixMax = new long[n];
        long[] prefixMin = new long[n];
        long currentMax = nums[0], currentMin = nums[0];
        
        for (int i = 0; i < n; i++) {
            currentMax = Math.max(currentMax, nums[i]);
            currentMin = Math.min(currentMin, nums[i]);
            prefixMax[i] = currentMax;
            prefixMin[i] = currentMin;
        }
        
        long[] suffixMax = new long[n];
        long[] suffixMin = new long[n];
        currentMax = nums[n-1]; currentMin = nums[n-1];
        
        for (int i = n - 1; i >= 0; i--) {
            currentMax = Math.max(currentMax, nums[i]);
            currentMin = Math.min(currentMin, nums[i]);
            suffixMax[i] = currentMax;
            suffixMin[i] = currentMin;
        }
        
        long maxProd = Long.MIN_VALUE;
        for (int i = 0; i + m - 1 < n; i++) {
            int j = i + m - 1;
            long a = prefixMax[i] * suffixMax[j];
            long b = prefixMin[i] * suffixMin[j];
            maxProd = Math.max(maxProd, Math.max(a, b));
        }
        return maxProd;
    }

}