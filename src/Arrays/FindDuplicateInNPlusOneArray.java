package Arrays;

import java.util.Arrays;

class FindDuplicateInNPlusOneArray {
    public static void main(String[] args) {
        // int[] arr = { 1, 3, 4, 2, 2 };
        // int[] arr = { 3,3,3,3,3 };
        int[] arr = { 3,1,3,4,2 };
        // System.out.println(findDuplicateSortAndFindApproach(arr));
        // System.out.println(findDuplicateHashMapApproavh(arr));
        System.out.println(findDuplicateLinkedListCyclePattern(arr));
    }

    static int findDuplicateLinkedListCyclePattern(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);
        // System.out.println(nums[slow]);
        // System.out.println(nums[fast]);
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    static int findDuplicateHashMapApproavh(int[] nums) {
        int map[] = new int[nums.length];
        for(int num: nums){
            if(map[num] >0){
                return num;
            }
            map[num]++;
        }
        System.out.println(Arrays.toString(map));
        return 0;
    }
    static int findDuplicateSortAndFindApproach(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[i] == nums[j]) return nums[j];
            i++;
            j++;
        }
        return 0;
    }
}
