package Assignments.Arrays;

// LC 1929
public class ConcatenationofArray {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int i = 0, j = 0;
        int list[] = new int[len * 2];
        while (j < len * 2) {
            list[j] = nums[i];
            if (i == nums.length - 1) {
                i = -1;
            }
            j++;
            i++;
        }
        return list;
    }
}
