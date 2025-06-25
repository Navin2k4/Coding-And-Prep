// LC 1480

package Arrays;

public class RunningSumof1dArray {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] + sum;
            sum += nums[i];
        }
        return ans;
    }
}
