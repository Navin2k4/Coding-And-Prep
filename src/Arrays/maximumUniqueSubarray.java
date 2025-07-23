import java.util.HashSet;
import java.util.Set;

public class maximumUniqueSubarray {
    public static void main(String[] args) {
        // int arr[] = { 4, 2, 4, 5, 6 };
        int arr[] = { 5, 2, 1, 2, 5, 2, 1, 2, 5};
        System.out.println(maximumUniqueSubarrayFun(arr));

    }

    static int maximumUniqueSubarrayFun(int[] nums) {
         int left = 0, right = 0;
        int sum = 0, maxSum = 0;
        Set<Integer> set = new HashSet<>();

        while (right < nums.length) {
            int curr = nums[right];
            while (set.contains(curr)) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(curr);
            sum += curr;
            maxSum = Math.max(maxSum, sum);
            right++;
        }

        return maxSum;
    }
}