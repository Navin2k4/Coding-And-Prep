package BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 8, 8 };
        System.out.println(singleNonDuplicate(arr));
        System.out.println(singleNonDuplicateBruteIteration(arr));
    }

    static int singleNonDuplicate(int[] nums) {
        // Sorted ? Binary Search
        // how we are going to eliminate
        // property of the single element
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[n - 1] != nums[n - 2])
            return nums[n - 1];
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];
            // elimination odd index and element in the right half
            // standing at odd and left is equal . standing at the even and ight is equal
            if ((mid % 2 == 1) && (nums[mid - 1] == nums[mid]) ||
                    (mid % 2 == 0) && (nums[mid] == nums[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int singleNonDuplicateBruteIteration(int[] nums) {
        // O(n) time and O(n) space
        if (nums.length == 1)
            return nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1])
                    return nums[i];
            } else if (i == nums.length - 1) {
                if (nums[i] != nums[i - 1])
                    return nums[i];
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                    return nums[i];
            }
        }
        return 0;
    }

    static int singleNonDuplicateBrute(int[] nums) {
        // O(n) time and O(n) space
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

}
