public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLength = 0;
        int n = nums.length;
        int zeros = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0)
                zeros++;
            if (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            if (zeros <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        
        // for (int right = 0; right < n; right++) {
        //     int currentElement = nums[right];
        //     if (currentElement == 0) {
        //         zeros++;
        //     }
        //     while (zeros > k) {
        //         if (nums[left] == 0) {
        //             zeros--;
        //         }
        //         left++;
        //     }
        //     if (zeros <= k) {
        //         maxLength = Math.max(maxLength, right - left + 1);
        //     }
        // }
        
        return maxLength;
    }    
}
