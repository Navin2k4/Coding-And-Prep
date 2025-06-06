package Assignments.Searching;

public class sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return 1;
        }
        int low = 0;
        int high = x;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid > x)
                high = (int) mid - 1;
            else
                low = (int) mid + 1;
        }
        return high;
    }
}