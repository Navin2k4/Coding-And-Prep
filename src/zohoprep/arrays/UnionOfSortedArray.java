package zohoprep.arrays;

import java.util.ArrayList;
import java.util.List;

public class UnionOfSortedArray {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 5, 6, 7 };
        int[] b = { 3, 5, 6, 7, 8, 9, 10 };
        System.out.println(findUnion(a, b)); // Should return 9
    }

    static int findUnion(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0, j = 0;
        List<Integer> unionList = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != a[i])
                    unionList.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != b[j])
                    unionList.add(b[j]);
                j++;
            } else {
                if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != a[i])
                    unionList.add(a[i]);
                i++;
                j++;
            }
        }

        while (i < n1) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != a[i])
                unionList.add(a[i]);
            i++;
        }

        while (j < n2) {
            if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != b[j])
                unionList.add(b[j]);
            j++;
        }

        System.out.println(unionList);
        return unionList.size();
    }
}
