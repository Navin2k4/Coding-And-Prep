package zohoprep.arrays;

import java.util.Arrays;

class RearrangeArraysAlternatively{
     public static void main(String[] args) {
        int[] arr = {890, 289, 483, 519, 550, 447, 946, 957, 92, 783};
        rearrangeMaxMin(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void rearrangeMaxMin(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); 

        int maxIdx = n - 1;
        int minIdx = 0;
        int maxElem = arr[n - 1] + 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // Place max element at even index
                arr[i] += (arr[maxIdx] % maxElem) * maxElem;
                maxIdx--;
            } else {
                // Place min element at odd index
                arr[i] += (arr[minIdx] % maxElem) * maxElem;
                minIdx++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }    
}