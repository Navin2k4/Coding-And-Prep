package BinarySearch;

class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = { 7, 12, 14, 15 };
        int[] arr2 = { 1, 2, 3, 4, 9, 11 };
        System.out.println(median(arr1, arr2));
    }

    static double median(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;

        if (n1 > n2)
            return median(b, a);

        int low = 0, high = n1;
        int total = n1 + n2;
        int half = (total + 1) / 2;

        while (low <= high) {
            // mid1 decides how many elements we are picking from tha array1 
            // Eg if we need of 11 elements combined by both array and now the mid1 is 2 that is pick 2 element from arr1
            // since the value of half is 10+1/2 -> 6
            int mid1 = low + (high - low) / 2;
            // mid1 decides how many elements we are picking from tha array2 and always based on mid2 
            // since we have picked 2 element from array1 and half is 6 we need 4 elements still from array2 hence mid2 is 4
            int mid2 = half - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : a[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : b[mid2];

            System.out.println(
                    "mid1: " + a[mid1] + ", mid2: " + b[mid2] +
                            " | l1: " + l1 + ", r1: " + r1 +
                            " | l2: " + l2 + ", r2: " + r2);

            if (l1 <= r2 && l2 <= r1) {
                if (total % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0.0;
    }
}
