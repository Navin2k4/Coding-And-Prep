package BinarySearch;

public class MinDaysToMakeBouquet {
    public static void main(String[] args) {
        System.out.println(minDays(new int[] { 1, 10, 3, 10, 2 }, 3, 1));
        System.out.println(minDays(new int[] { 1, 10, 3, 10, 2 }, 3, 2));
        System.out.println(minDays(new int[] { 7, 7, 7, 7, 12, 7, 7 }, 2, 3));
    }

    static int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length)
            return -1;
        int lowDay = smallest(bloomDay);
        int highDay = greatest(bloomDay);
        int ans = highDay;
        while (lowDay <= highDay) {
            int midDay = lowDay + (highDay - lowDay) / 2;
            boolean isPossible = possible(bloomDay, midDay, m, k);
            if (isPossible) {
                ans = midDay;
                highDay = midDay - 1;
            } else {

                lowDay = midDay + 1;
            }
        }
        return ans;
    }

    static int greatest(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        return max;
    }

    static int smallest(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
        }
        return min;
    }

    static boolean possible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int numberofBouq = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                numberofBouq += (count / k);
                count = 0;
            }
        }
        numberofBouq += (count / k);

        if (numberofBouq >= m)
            return true;

        return false;
    }

}
