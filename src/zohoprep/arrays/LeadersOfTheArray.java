package zohoprep.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersOfTheArray {
    public static void main(String[] args) {
        // Everything in the right should be smaller for the element
        int[] nums = { 10, 22, 12, 3, 0, 6 }; // last element is always the leader of the array;
        // System.out.println(collectLeadersBrute(nums));
        System.out.println(collectLeadersOptimal(nums));
    }

    static ArrayList<Integer> collectLeadersBrute(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean leader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader)
                ans.add(arr[i]);
        }
        return ans;
    }

     static ArrayList<Integer> collectLeadersOptimal(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length-1;
        int max = Integer.MIN_VALUE;
        while(n >= 0){
            boolean leader = false;
            if(arr[n] > max){
                max = arr[n];
                leader = true;
            }
            if(leader) ans.add(arr[n]);
            n--;
        }
        Collections.reverse(ans);
        return ans; 
    }

}
