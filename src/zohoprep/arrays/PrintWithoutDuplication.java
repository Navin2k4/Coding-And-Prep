package zohoprep.arrays;

import java.util.Arrays;

public class PrintWithoutDuplication {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        int k = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]){
                arr[k++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(k);
    }
}
