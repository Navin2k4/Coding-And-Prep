/* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
34
!!! Facebook Interview Question
 * Given an array of integers nums sorted in non-decreasing order, 
        * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 
? Example 1:
? Input: nums = [5,7,7,8,8,10], target = 8
? Output: [3,4]

? Example 2:
? Input: nums = [5,7,7,8,8,10], target = 6
? Output: [-1,-1]

? Example 3:
? Input: nums = [], target = 0
? Output: [-1,-1]


* Approach
! By using two binary search
! 1st binary search is for the start index
! 2nd binary search if fot the last index
! We can also do it in the one binary search
*/

package BinarySearch;

import java.util.ArrayList;

public class FindTheFirstAndLastPositionOfAnElementInASortedArray {
    public static void main(String[] args) {
        int array[] = { 5, 7, 7, 8, 8, 10 };
        System.out.println(find(array, 8));
    }

    static ArrayList<Integer> find(int arr[], int x) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        int startIndex = bs(arr, x, true);
        if (startIndex != -1) {
            int endIndex = bs(arr, x, false);
            result.set(0, startIndex);
            result.set(1, endIndex);
        }
        return result;
    }

    static int bs(int[] arr, int target, boolean start) {
        int ans = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                if (start) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}