// ? https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// ! Problem Number : 448 ( Google )
/*
 * Given an array arr of n integers where arr[i] is in the range [1, n], 
 * return an array of all the integers in the range [1, n] that do not appear in arr.
 */
package SortingAlgorithms;
import java.util.ArrayList;
import java.util.List;
public class FindAllThenumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(arr));
    }
    static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index+1) {
                ans.add(index+1);
            }
        }
        return ans;
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
