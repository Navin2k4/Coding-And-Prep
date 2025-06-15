package BinarySearch;

public class SqRoot {
    public static void main(String[] args) {
        int n = 28;
        int low = 1;
        int high = n;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sq = mid * mid;
            if (sq <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
