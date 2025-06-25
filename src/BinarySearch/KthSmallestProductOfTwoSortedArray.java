package BinarySearch;

import java.util.Arrays;

class KthSmallestProductOfTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = { -4, -2, 0, 3 };
        int arr2[] = { 2, 4 };
        long k = 2;
        System.out.println(kthSmallestProduct(arr1, arr2, k));
    }

    static long kthSmallestProduct(int[] arr1, int[] arr2, long k) {
        int n = arr1.length;
        int m = arr2.length;
        int[] res = new int[n * m];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[index++] = arr1[i] * arr2[j];
            }
        }

        Arrays.sort(res);
        return res[(int) k - 1];
    }

    static long kthSmallestProductBS(int[] arr1, int[] arr2, long k) {

        return 0;
    }
}