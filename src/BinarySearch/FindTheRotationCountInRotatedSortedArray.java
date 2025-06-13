package BinarySearch;
public class FindTheRotationCountInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = { 15, 18, 2, 3, 6, 12 };
        int arr1[] = { 1, 2, 3, 4, 5 };
        System.out.println("Number of Rotations : " + findrotationcount(arr));
        System.out.println("Number of Rotations : " + findrotationcount(arr1));
    }

    static int findrotationcount(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        int index = -1;
        // the min element is the pivot element where the rotation started
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[mid]) {
                // left half since in the left half the smallest is always the low
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            } else {
                // right half since in the left half the smallest is always the mid
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return index;
    }
}
