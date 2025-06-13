package BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 2, 3, 3, 3 };
        int arr1[] = { 1, 0, 1, 1, 1 };
        System.out.println("Index: " + searchND(arr, 3));
        System.out.println("Index: " + searchWD(arr, 3));
        System.out.println("Index: " + searchND(arr1, 0));
        System.out.println("Index: " + searchWD(arr1, 0));
    }

    // No Duplicates
    static int searchND(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;

            // left sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // right sorted
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // With Dupliates
    // The idea is converging the search space bu increasing low and reducing high if they all are same;
    static int searchWD(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            // left sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // right sorted
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
