
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int us_arr[] = { 1, -8, 4, -3, 5, 4 };
        bubbleSort(us_arr);
        System.out.println(Arrays.toString(us_arr));
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean swapped = false;

            // Bubble up the largest element to the correct position
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    swapped = true;
                }
            }

            // Optimization: Break if no swaps occurred
            if (!swapped) {
                break;
            }
        }
    }
    
    static void swap(int[] arr, int i, int j) {
        if (i == j)
            return; // No need to swap if indices are the same
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
