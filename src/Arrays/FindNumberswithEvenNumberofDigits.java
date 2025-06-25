package Arrays;

public class FindNumberswithEvenNumberofDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (even(num)) {
                count++;
            }
        }
        return count;
    }

    static boolean even(int num) {
        return (int) (Math.log10(num) + 1) % 2 == 0;
    }
}
