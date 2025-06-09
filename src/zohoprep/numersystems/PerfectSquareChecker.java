package zohoprep.numersystems;

public class PerfectSquareChecker {
    public static void main(String[] args) {
        int number = 49;
        System.out.println(isPerfectSquare(number));  // Output: true

        number = 50;
        System.out.println(isPerfectSquare(number));  // Output: false
    }
     static boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        int sqrt = (int)Math.sqrt(num);
        return sqrt*sqrt == num;
     }
}
