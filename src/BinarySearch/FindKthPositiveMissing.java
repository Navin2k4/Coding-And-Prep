package BinarySearch;

class FindKthPositiveMissing {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 7, 11 };
        int k = 5;
        System.out.println(findKthPositive(arr, k));
        System.out.println(findKthPositiveBetter(arr, k));
        System.out.println(findKthPositiveBinarySearch(arr, k));
    }

    static int findKthPositiveBinarySearch(int[] arr, int k) {
        /*
         * Goal:
         * Given a sorted array of positive integers (no duplicates),
         * find the k-th missing positive number not present in the array.
         *
         * Key Insight:
         * At any index `i`, the number of missing elements before `arr[i]` is:
         * missing = arr[i] - (i + 1)
         * 
         * Because ideally, at index 0 we expect 1, at index 1 we expect 2, ..., at
         * index i we expect i+1.
         * So, missing = actual number at index - expected number.
         *
         * We use binary search to find the smallest index such that
         * the number of missing elements before it is >= k.
         * Once we find this position, the answer will be:
         * position + k
         */
        if (arr.length == 0)
            return k;

        // k-th missing is before the first element
        // For example: arr = [5, 6, 7], k = 3 → missing numbers = [1, 2, 3, 4]
        if (k <= arr[0] - 1)
            return k;

        int low = 0, high = arr.length - 1;

        // Binary search over index space
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Calculate how many numbers are missing before arr[mid]
            int missing = arr[mid] - (mid + 1);

            // DEBUG prints to visualize what’s going on
            System.out.println("Arr[mid] : " + arr[mid] + " | mid : " + mid);
            System.out.println("Missing count till index " + mid + " : " + missing);

            if (missing < k) {
                // Not enough missing numbers, we need to go right
                low = mid + 1;
            } else {
                // We may have enough or more than required missing numbers, go left
                high = mid - 1;
            }
        }

        /*
         * After the loop:
         * - `low` is the number of elements in arr[] that are <= to the final answer
         * - Since `low` elements are present, and we need to find k-th missing,
         * we "add" the missing part to the end of those `low` elements.
         */
        return low + k;
    }

    static int findKthPositiveBetter(int[] arr, int k) {
        int i = 0;
        int curr = 1;
        while (k > 0) {
            if (i < arr.length && arr[i] == curr) {
                i++;
            } else {
                k--;
                if (k == 0)
                    return curr;
            }
            curr++;
        }
        return curr;
    }

    static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int[] map = new int[arr[n - 1]];
        for (int num : arr) {
            map[num - 1]++;
        }
        int i = 1;
        while (i <= map.length && k > 0) {
            // System.out.println(i + " = " + map[i - 1]);
            if (map[i - 1] == 0) {
                k--;
            }
            i++;
        }
        // System.out.println("K : " + k + " And i : " + i);
        int ans = 0;
        if (k == 0) {
            ans = i - 1;
        } else {
            ans = i + k;
        }
        return ans;
    }
}