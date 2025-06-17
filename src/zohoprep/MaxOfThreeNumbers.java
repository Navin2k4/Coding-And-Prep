package zohoprep;

public class MaxOfThreeNumbers {
    public static void main(String[] args) {
        int a = 10, b = 25, c = 15;

        int max = maxOfThree(a, b, c);
        System.out.println("Maximum: " + max);
    }

    static int maxOfThree(int a, int b, int c) {
        int max = a;
        if(b > max) max = b;
        if(c > max) max = c;
        return max;
    }

     static int maxOfThreeBW(int a, int b, int c) {
        return maxBitwise(maxBitwise(a, b), c);
    }

    static int maxBitwise(int a, int b) {
        return a - ((a - b) & ((a - b) >> 31));
    }
}
