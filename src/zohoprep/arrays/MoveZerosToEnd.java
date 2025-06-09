package zohoprep.arrays;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[] a = { 1, 0, 0, 5, 6, 0, 8, 9, 10 };
        int j = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                j = i;
                break;
            }
        }
        for (int i = j + 1; i < a.length; i++) {
            if (a[i] != 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(a));

    }
}
