package QuickSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 2, 1 };
        // original array is not modified it returns a new array object
        QS(arr, 0, arr.length - 1);
        System.out.println("Quick sort result : " + Arrays.toString(arr));

        // Internal sorting algorithm in Java
        /*
        ? DualPivotQuicksort.sort(a, 0, 0, a.length);
        ? Arrays.sort(arr);
        */

    }
    // If not making the copy of the array then i need to maintain the index value
    // which is the low and high (InPlace)
    static void QS(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = nums[m];
        // also a reason why if its already sotted it will not sort
        while (nums[s] < pivot) {
            s++;
        }
        while (nums[e] > pivot) {
            e--;
        }
        if (s <= e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
        // Now the pivot is at correct index now sort other halves
        QS(nums, low, e);
        QS(nums, s, high);
    }
}
