package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

class RearrangeArrayElementBySign {
    public static void main(String[] args) {
        int[] arr = { 3, -2, 1, -5, 2, -4 };
        rearrangeArrayMyApproach(arr);
        rearrangeArrayBetterApproach(arr);
    }

    static int[] rearrangeArrayBetterApproach(int[] nums) {
        int[] res = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;
        for (int num : nums) {
            if (num > 0) {
                res[posIndex] = num;
                posIndex += 2;
            } else {
                res[negIndex] = num;
                negIndex += 2;
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    static int[] rearrangeArrayMyApproach(int[] nums) {
        // Brute Force approach;
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num > 0) {
                posList.add(num);
            } else {
                negList.add(num);
            }
        }
        int index = nums.length - 1;
        while (index >= 0) {
            res[index] = negList.remove(negList.size() - 1);
            index--;
            res[index] = posList.remove(posList.size() - 1);
            index--;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}
