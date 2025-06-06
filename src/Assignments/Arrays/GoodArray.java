package Assignments.Arrays;

public class GoodArray {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 2, 4, 1 };
        System.out.println(isGood(nums));
    }

    static boolean isGood(int[] nums) {
        int i = 0;
        if (nums.length == 1) {
            return false;
        }
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (correctIndex < nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        if (checkCorrect(nums)) {
            if (nums[nums.length - 1] == nums[nums.length - 2]) {
                return true;
            }
            return false;
        }
        return false;
    }

    static boolean checkCorrect(int[] nums) {
        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index] != index + 1) {
                return false;
            }
        }
        return true;
    }

    static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
