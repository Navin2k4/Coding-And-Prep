package Arrays;

public class MaximumDifference {
    public static void main(String[] args) {
        // int nums[] = { 7, 1, 5, 4 };
        int nums[] = { 9, 4, 3, 2 };
        // int nums[] = { 1,5,2,10};
        int n = nums.length;
        if(n < 2){
            if(nums[0] > nums[1]){
                System.out.println(nums[1]- nums[0]);
            }
        }
        int ans = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    int diff = nums[j] - nums[i];
                    ans = Math.max(diff, ans);
                    System.out.println("i : " + nums[i] + " " + " j : " + nums[j]);
                }
            }
        }

        System.out.println(ans);
    }
}