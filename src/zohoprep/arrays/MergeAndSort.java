package zohoprep.arrays;

import java.util.Arrays;

public class MergeAndSort {
    public static void main(String[] args) {
        int arr1[] = { 3, 27, 38, 43 };
        int arr2[] = { 9, 10, 82 };
        int n1 = arr1.length;
        int n2 = arr2.length;

        mergeAndSort(arr1, arr2, n1, n2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    static void mergeAndSort(int[] arr1, int[] arr2, int n1, int n2) {
        int gap = nextGap(n1 + n2);
        while (gap > 0) {
            int i = 0;
            while (i + gap < n1) {
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
                i++;
            }

            int j = gap > n1 ? gap - n1 : 0;
            while (i < n1 && j < n2) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
                i++;
                j++;
            }

            if (j < n2) {
                j = 0;
                while (j + gap < n2) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                    j++;
                }
            }

            gap = nextGap(gap);
        }
    }
}

/*
 * Suppose we have a number A and we want to
 * convert it to a number B and there is also a
 * constraint that we can recover number A any
 * time without using other variable.To achieve
 * this we choose a number N which is greater
 * than both numbers and add B*N in A.
 * so A --> A+B*N
 * 
 * To get number B out of (A+B*N)
 * we divide (A+B*N) by N.
 * so (A+B*N)/N = B.
 * 
 * To get number A out of (A+B*N)
 * we take modulo with N.
 * so (A+B*N)%N = A.
 * 
 * -> In short by taking modulo
 * we get old number back and taking divide
 * we new number.
 */