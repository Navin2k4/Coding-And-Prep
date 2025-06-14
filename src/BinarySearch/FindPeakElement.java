// ! https://leetcode.com/problems/find-peak-element/description/
// * 162 (EASY) using code of 852 
/*
    ? A peak element is an element that is strictly greater than its neighbors.
    ? Given a 0-indexed integer numsay nums,find a peak element,and return its index.
        * If the numsay contains multiple peaks,return the index to any of the peaks.
    ? You may imagine that nums[-1]=nums[n]=-∞.
        * In other words,an element is always considered to be strictly greater than a neighbor that is outside the numsay.
        ! You must write an algorithm that runs in O(log n)time. ( Binary Search )
Example 1:
Input:nums=[1,2,3,1]
Output:2 
Explanation:3 is a peak element and your function should return the index number 2. 
Example 2:
Input:nums=[1,2,1,3,5,6,4]
Output:5 
Explanation:Your function can return either index number 1 where the peak element is 2,
or index number 5 where the peak element is 6.
*/

package BinarySearch;

public class FindPeakElement {
    public static void main(String[] args) {
        int nums[] = { 1, 3, 5, 6, 4 };
        System.out.println(findPeakElement(nums));
        // System.out.println(findPeakElementLinear(nums));
    }

    static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] < nums[n - 1])
            return n - 1;

        int low = 1;
        int high = nums.length - 2;
        while (low <= high) {
            int mid = (low) + (high - low) / 2;
            if ((nums[mid] > nums[mid - 1]) && (nums[mid] > nums[mid + 1])) {
                return nums[mid];
            } else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    static int findPeakElementLinear(int[] nums) {
        int n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            if ((i == 0 || nums[i] >= nums[i - 1]) &&
                    (i == n - 1 || nums[i] >= nums[i + 1])) {
                return nums[i];
            }
        }
        return -1;
    }

}
