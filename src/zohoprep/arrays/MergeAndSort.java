package zohoprep.arrays;

import java.util.Arrays;

public class MergeAndSort {
    public static void main(String[] args) {
        int arr1[] = { 1, 3, 5, 7 };
        int arr2[] = { 0, 2, 6, 8, 9 };
        int n1 = arr1.length;
        int n2 = arr2.length;

        mergeAndSortGapMethod(arr1, arr2, n1, n2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    static void mergeAndSortGapMethod(int[] arr1, int[] arr2, int n, int m) {
        // Gap method comes from shell sort algo
        int len = n + m;
        int gap = (len / 2) + (len % 2); // 9/2 + 9%2 -> 4+1 -> 5
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // left -> arr1 , right -> array2
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // left, right -> array2
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // left, right > array1
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            System.out.println(gap);
            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    static void mergeAndSortOP(int[] arr1, int[] arr2, int n, int m) {
        int left = n - 1;
        int right = 0;
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // static void mergeAndSortBrute(int[] arr1, int[] arr2, int n, int m) {
    // int res[] = new int[n + m];
    // int i = 0;
    // int j = 0;
    // int index = 0;
    // while (i < n && j < m) {
    // if (arr1[i] <= arr2[j]) {
    // res[index++] = arr1[i];
    // i++;
    // } else {
    // res[index++] = arr2[j];
    // j++;
    // }
    // }
    // while (i < n) {
    // res[index++] = arr1[i];
    // i++;
    // }
    // while (j < m) {
    // res[index++] = arr2[j];
    // j++;
    // }

    // // replace the original array
    // for (int ind = 0; ind < res.length; ind++) {
    // if (ind < n)
    // arr1[ind] = res[ind];
    // else
    // arr2[ind - n] = res[ind];
    // }
    // System.out.println(Arrays.toString(res));
    // }
}