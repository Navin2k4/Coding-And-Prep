package BinarySearch;

public class NthRoot {
    public static void main(String[] args) {
        int m = 27;
        int n = 3;
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sq = (int)Math.pow(mid, n);
            if (sq == m) {
                System.out.println(mid);
                break;
            } else if (sq < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

    }
}
