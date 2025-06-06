package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int array[] = { 1,2,6,7,8,11,11,14,18 }; // sorted array
        // System.out.println(BinarySearchIndex(array, 18));
        System.out.println(LowerBound(array, 11));
        // System.out.println(UpperBound(array, 11));

    }

    // Return the index
    // return if it does not exist return -1
    static int BinarySearchIndex(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // Find the mddle element
            // int mid = (start+end) / 2; // might be possible that the start+end may exceed
            // the range of integer in java which might lead to error
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1; // For ascending
                // start = mid + 1 // For descending
            } else if (target > arr[mid]) {
                start = mid + 1; // For ascending
                // end = mid - 1 // For descending
            } else {
                return mid;
            }
        }
        return -1;
    }

    // Smallest index i such that arr[i] >= x
    // If x is greater than all elements → returns arr.length
    static int LowerBound(int arr[], int x) {
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length; // Default answer if x is greater than all elements

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                ans = mid; // Potential answer
                end = mid - 1; // But keep searching to the left for a smaller index
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    // Smallest index i such that arr[i] > x
    // If x is greater than or equal to all elements → returns arr.length
    static int UpperBound(int arr[], int x) {
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length; // Default answer if no element is greater than x

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > x) {
                ans = mid; // Potential answer
                end = mid - 1; // Look for smaller index on the left
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

}