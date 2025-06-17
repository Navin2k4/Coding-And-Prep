package zohoprep.arrays;

import java.util.ArrayList;

public class PrintElementGreaterThanPreviousElementInArrray {
    public static void main(String[] args) {
        int arr[] = { 2, -3, -4, 5, 9, 7, 8 };
        ArrayList<Integer> result = new ArrayList<>();
        printElements(arr, result);
    }

    static void printElements(int[] arr, ArrayList<Integer> ans) {
        if (arr.length == 0)
            return;

        ans.add(arr[0]);
        int prev = arr[0]; 

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > prev) {
                ans.add(arr[i]);
                prev = arr[i];
            }
        }
        System.out.println(ans);
    }

}
