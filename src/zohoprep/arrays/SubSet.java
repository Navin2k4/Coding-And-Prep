package zohoprep.arrays;

import java.util.Scanner;

public class SubSet {
    static int[] getSubSet(int arr[], int start, int end) {
        int size = Math.abs(start - end) + 1;
        int res[] = new int[size];
        int index = 0;
        int adder = start > end ? -1 : 1;
        int i = start;
        while (i != end + adder) {
            res[index++] = arr[i];
            i += adder;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pickIndex = scanner.nextInt();
        int putIndex = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int ans[] = getSubSet(arr, pickIndex, putIndex);
        System.out.println("Subsets Are");
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}