package EuclidianAlgorithms;

public class ReverseOfANumber {
    public static void main(String[] args) {
        int n = -7548;
        System.out.println(reverse(n));
    }
    static int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = x * -1;
        }
        int reverseNum = 0;
        while (x > 0) {
            int last = x % 10;

            if (reverseNum > Integer.MAX_VALUE / 10 || (reverseNum == Integer.MAX_VALUE / 10 && last > 7))
                return 0;

            reverseNum = (reverseNum * 10) + last;
            x = x / 10;
        }
        return reverseNum * sign;
    }
}
