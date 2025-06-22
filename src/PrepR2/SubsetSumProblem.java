import java.util.*;

class SubsetSumProblem {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 8, 10};
        int target = 10;

        List<List<Integer>> result = new ArrayList<>();
        findSubsets(arr, 0, target, new ArrayList<>(), result);

        // Final Output
        System.out.println("Subsets summing to " + target + ":");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    // Backtracking method
    public static void findSubsets(int[] arr, int index, int remaining, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));  // store a copy
            return;
        }

        if (index == arr.length || remaining < 0) return;

        // Include current element
        current.add(arr[index]);
        findSubsets(arr, index + 1, remaining - arr[index], current, result);

        // Backtrack (exclude current)
        current.remove(current.size() - 1);
        findSubsets(arr, index + 1, remaining, current, result);
    }
}
