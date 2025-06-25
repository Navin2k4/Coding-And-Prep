// LC 66
package Arrays;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int arr[] = { 9 };
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
