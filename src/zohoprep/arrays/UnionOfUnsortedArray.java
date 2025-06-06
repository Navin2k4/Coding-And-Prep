package zohoprep.arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class UnionOfUnsortedArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,5,6,7};
        int[] b = {3,5,6,7,8,9,10};
        System.out.println(findUnion(a, b));
    }
    static int findUnion(int a[], int b[]) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : a)
            set.add(num);
        for (int num : b)
            set.add(num);

        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        System.out.println(Arrays.toString(result));
        return set.size();
    }
}
