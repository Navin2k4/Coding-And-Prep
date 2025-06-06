package Recursion.StringSubSequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        List<List<Integer>> ans = subset(arr);
        List<Integer> sumarr = subsetSum(arr);
    
        // System.out.println(ans);
        System.out.println(sumarr);
        // for(List<Integer> list : ans){
        //     System.out.println(list);
        // }
    }
// Using iterative process of the subsequence sum converting the recursive process into the iterative process
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num : arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i)); // copy of the outer ith List
                internal.add(num);
                outer.add(internal);
            }
        }
        outer.removeIf(List::isEmpty);
        return outer;
    }

    static List<Integer> subsetSum(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];
                result.add(sum);
            }
        }
       Collections.sort(result);
        return result;
    }
    // what if the array contains the duplicates ? [2,1,2]
    static List<List<Integer>> subsetduplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0 ; 
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if current and previous element is same than start from s = e +1;
            if(i>0 && arr[i] == arr[i-1]){
                start = end+1;
            }
            end = outer.size() - 1 ;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j)); // copy of the outer ith List
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
