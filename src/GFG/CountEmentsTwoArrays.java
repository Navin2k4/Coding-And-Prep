package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class CountEmentsTwoArrays {
    public static void main(String[] args) {
        // int a[] = { 1, 2, 3, 4, 7, 9 };
        // int b[] = { 0, 1, 2, 1, 1, 4 };
        // [4, 5, 5, 6, 6, 6]
        int a[] = { 4, 8, 7, 5, 1 };
        int b[] = { 4, 48, 3, 0, 1, 1, 5 };
        // [5, 6, 6, 6, 3]
        // countLessEqBrute(a, b);
        countLessEq(a, b);
    }

    static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // O(mlogm)+O(nlogm)=O((n+m)logm)
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(b); // O(m log m)
        for (int num : a) { // O(n)
            int res = bs(b, num); // O(log m)
            result.add(res + 1); // O(1)
        }
        System.out.println(result);
        return result;
    }

    static int bs(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static ArrayList<Integer> countLessEqBrute(int a[], int b[]) {
        // TLE o(n2) TC
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < b.length; j++) {
                if (b[j] <= a[i])
                    count++;
            }
            result.add(count);
        }
        System.out.println(result);
        return result;
    }
}
