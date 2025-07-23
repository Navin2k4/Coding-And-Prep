package BinarySearch;

// Classic problem 
/*
 * Key understanding
 * so this problem is a type of Binary Search in the answers where we will be making the sarch on the answers
 * for example we can say from this 3,6,7,11 ans K=8 to find the value of s 
 * Not Satisfying
 * Let us consider s=2 for per hour then  => 2 + 3 + 4 + 6 => 15 > 8
 * Let us consider s=3 for per hour then  => 1 + 2 + 3 + 4 => 10 > 8
 * Satisfying
 * Let us consider s=4 for per hour then  => 1 + 2 + 2 + 3 => 8 = 8
 * Let us consider s=5 for per hour then  => 1 + 2 + 2 + 2 => 7 < 8
 * Let us consider s=11 for per hour then  => 1 + 1 + 1 + 1 => 4 < 8
 * we need to find minimum satisfying s which is here 4 so we apply BS on 1 to 11 to find the minimum possible to get s<=k
 *  */
public class KokoEatingBanana {
    public static void main(String[] args) {
        System.out.println(kokoEatBrute(new int[] { 5, 10, 3 }, 4));
        System.out.println(kokoEatBrute(new int[] { 5, 10, 15, 20 }, 7));
        System.out.println(kokoEatBruteBS(new int[] { 5, 10, 3 }, 4));
        System.out.println(kokoEatBruteBS(new int[] { 5, 10, 15, 20 }, 7));
    }

    static int kokoEatBruteBS(int[] arr, int k) {
        int low = 1;
        int high = maxElement(arr);
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalHours = calculateHours(arr, mid);
            if (totalHours <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    static int maxElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // System.out.println(max);
        return max;
    }

    static int calculateHours(int[] arr, int k) {
        int totalHours = 0;
        for (int i = 0; i < arr.length; i++) {
            totalHours += (arr[i] + k - 1) / k;
        }
        return totalHours;
    }

    static int kokoEatBrute(int[] arr, int k) {
        // code here
        int s = 1;
        while (true) {
            int totalHours = 0;

            for (int num : arr) {
                totalHours += (num + s - 1) / s;
            }

            if (totalHours <= k)
                return s;

            s++;
        }
    }
}
