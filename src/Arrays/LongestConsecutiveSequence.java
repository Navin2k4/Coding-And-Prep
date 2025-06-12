package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = { 100, 4, 200, 1, 3, 2 };
        int[] arr1 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        int[] arr2 = { 1, 0, 1, 2 };
        // System.out.println(longestConsecutiveBetter(arr));
        System.out.println(longestConsecutiveOptimal(arr));
        // System.out.println(longestConsecutiveOptimal(arr1));
        // System.out.println(longestConsecutiveOptimal(arr2));
    }

    static int longestConsecutiveOptimal(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums) {
            set.add(x);
        }
        int longest = 0;
        for(int x : set) {
            if(!set.contains(x - 1)) {
                int currentNum = x;
                int currentStreak = 1;
                while(set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }

    static int longestConsecutiveBrute(int[] nums) {
        if (nums.length == 0)
            return 0;

        int longest = 1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int count = 1;

            while (LinearSearch(nums, x + 1)) {
                x++;
                count++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    static int longestConsecutiveBetter(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int longest = 1;
        int countCurrent = 0;
        int lastSmaller = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 == lastSmaller) {
                countCurrent += 1;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) {
                countCurrent = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, countCurrent);
        }
        return longest;
    }

    static boolean LinearSearch(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return true;
            }
        }
        return false;
    }
}
