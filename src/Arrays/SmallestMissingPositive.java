import java.util.Arrays;

public class SmallestMissingPositive {
    public static void main(String[] args) {
        int arr1[] = { 2, -3, 1, 1, 7 };
        int arr2[] = { 5, 3, 2, 5, 1 };
        // int arr3[] = { -8, 0, -1, -4, -3 };
        // int arr3[] = { -1,2,3,4,5};
        // int arr3[] = { -3 ,5, 4, 5 ,8 ,7 ,0 ,9};
        int arr3[] = { -12};
        // System.out.println("Result : " +missingNumber(arr1));
        // System.out.println("Result : " +missingNumber(arr2));
        System.out.println("Result : " +missingNumber(arr3));
    }

    static int missingNumber(int[] arr) {
        int max = 0;
        for (int num : arr) {
            max = Math.max(num, max);
        }
        System.out.println(max);
        int[] freq = new int[max + 1];
        for (int num : arr) {
            if (num > 0) {
                freq[num]++;
            }
        }        
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                return i;
            }
        }
        return max+1;
    }
}
