package Recursion;

import java.util.ArrayList;

public class StringSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        subSeq("", s);

        int[] nums = { 1, 2, 3, 4 };
        ArrayList<Integer> ans = new ArrayList<>();
        subSeqArr(0, nums, ans);
    }

    static void subSeq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSeq(p + ch, up.substring(1)); // Include char
        subSeq(p, up.substring(1)); // Exclude char
    }

    static void subSeqArr(int index, int[] nums, ArrayList<Integer> res) {
        if (index == nums.length) {
            System.out.println(res);
            return;
        }

        // Include the element
        res.add(nums[index]);
        subSeqArr(index + 1, nums, res);

        // Exclude the element (backtrack)
        res.remove(res.size() - 1);
        subSeqArr(index + 1, nums, res);
    }
}
