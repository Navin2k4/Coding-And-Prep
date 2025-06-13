package BinarySearch;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 1, 2, 3, 4 };
        System.out.println(findMin(arr));

    }

    static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // System.out.println(nums[low] + " " + nums[mid] + " " + nums[high] + " " +
            // ans);

            // if the search space is already sorted then low will be always less than high
            // so we can optimize them
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
            }

            if (nums[low] <= nums[mid]) {
                // left half since in the left half the smallest is always the low
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                // right half since in the left half the smallest is always the mid
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

}

/*
 * 3, 4, 5, 1, 2
 * low = 3
 * mid = 5
 * high = 2
 * Test dry running this one
 */
