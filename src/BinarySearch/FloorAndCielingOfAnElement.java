package BinarySearch;

public class FloorAndCielingOfAnElement {
    public static void main(String[] args) {
        int array[] = { 2, 3, 5, 9, 14, 16, 18 };

        int ceil = CielingIndex(array, 15);
        int floor = FloorIndex(array, 15);

        System.out.println("Ceiling Index: " + ceil); // Expected: 5 (16)
        System.out.println("Floor Index: " + floor);   // Expected: 4 (14)
    }

    static int CielingIndex(int arr[], int target) {
        if (target > arr[arr.length - 1]) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start; // Smallest element ≥ target
    }

    static int FloorIndex(int[] arr, int target) {
        if (target < arr[0]) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end; // Largest element ≤ target
    }

}
