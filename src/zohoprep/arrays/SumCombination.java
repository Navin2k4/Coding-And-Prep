package zohoprep.arrays;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/problems/combination-sum-1587115620/1
class SumCombination {
    // Input
    // 8 3 4 7 9
    // N=7
    // Output
    // {3 4 } {7}

    // Combination Sum Problem
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8 };
        int target = 8;
        List<List<Integer>> result = new ArrayList<>();
        findCombinationsWithDuplicate(arr, 0, target, new ArrayList<>(), result);

        for (List<Integer> combo : result) {
            System.out.println(combo);
        }
    }

    static void findCombinations(int[] arr, int index, int target, List<Integer> path, List<List<Integer>> result) {
        // same number cannot be taken more than once
        // Take not take pattern recursion problem
        // always move the indedx check if i can take and reduce the target if the
        // target become 0 valid sums add it to the result if it
        // if the index out of bound or the target is les than 0 return not a valid one;

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (index >= arr.length || target < 0)
            return;

        path.add(arr[index]);
        findCombinations(arr, index + 1, target - arr[index], path, result);
        path.remove(path.size() - 1);
        findCombinations(arr, index + 1, target, path, result);
    }

    static void findCombinationsWithDuplicate(int[] arr, int index, int target, List<Integer> path,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (index >= arr.length || target < 0)
            return;

        path.add(arr[index]);
        findCombinationsWithDuplicate(arr, index, target - arr[index], path, result);
        path.remove(path.size() - 1);
        findCombinationsWithDuplicate(arr, index + 1, target, path, result);
    }
}