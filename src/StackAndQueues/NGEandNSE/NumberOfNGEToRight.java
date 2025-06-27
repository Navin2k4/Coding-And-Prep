package StackAndQueues.NGEandNSE;

import java.util.Arrays;

public class NumberOfNGEToRight {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 1 };
        int queries = 2;
        int indices[] = { 0, 3 };
        int N = arr.length;
        System.out.println(Arrays.toString(count_NGEs(N, arr, queries, indices)));
    }

    static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int[] count = new int[N];
        for (int i = 0; i < N; i++) {
            int c = 0;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] > arr[i]) {
                    c++;
                }
            }
            count[i] = c;
        }

        int[] res = new int[queries];
        for (int i = 0; i < queries; i++) {
            res[i] = count[indices[i]];
        }

        return res;
    }
}
