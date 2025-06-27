package StackAndQueues.NGEandNSE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * The next greater element of some element x in an array is the first greater 
 * element that is to the right of x in the same array.
 * 
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, 
 * where nums1 is a subset of nums2.
 * 
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] 
 * and determine the next greater element of nums2[j] in nums2. 
 * If there is no next greater element, then the answer for this query is -1.
 * 
 *  Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 */
public class NextGreaterElementLC {
    public static void main(String[] args) {
        int nums1[] = { 4, 1, 2 };
        int nums2[] = { 1, 3, 4, 2 };

        System.out.println(Arrays.toString(nextGreaterElementBrute(nums1, nums2)));
        System.out.println(Arrays.toString(nextGreaterElementStack(nums1, nums2)));
    }

    static int[] nextGreaterElementStack(int[] nums1, int[] nums2) {
        Map<Integer, Integer> ngeMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            int nge = stack.isEmpty() ? -1 : stack.peek();
            ngeMap.put(num, nge);
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = ngeMap.get(nums1[i]);
        }

        return result;
    }

    static int[] nextGreaterElementBrute(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] nge = new int[n];

        for (int i = 0; i < n; i++) {
            int target = nums1[i];
            int indexInNums2 = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == target) {
                    indexInNums2 = j;
                    break;
                }
            }

            nge[i] = -1;
            for (int j = indexInNums2 + 1; j < nums2.length; j++) {
                if (nums2[j] > target) {
                    nge[i] = nums2[j];
                    break;
                }
            }
        }

        return nge;
    }
}
