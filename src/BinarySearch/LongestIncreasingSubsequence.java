package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    static int lengthOfLIS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i] > ans.get(ans.size()-1)){
                ans.add(nums[i]);
            }
            else {
                int index = lowerbound(ans, nums[i]);
                ans.set(index, nums[i]); 
            }
        }
        return ans.size();
    }
    static int lowerbound(List<Integer> arr, int num){
        int low = 0;
        int high = arr.size();
        int res = arr.size();
        while(low <= high){
            int mid = (low)+(high-low) / 2;
              if (arr.get(mid) >= num) {
                res = mid;
                high = mid -1;
            } else {
                low = mid + 1;  
            }
        }
        return res;
    }
}
