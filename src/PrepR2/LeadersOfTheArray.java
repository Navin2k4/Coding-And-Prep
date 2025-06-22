import java.util.ArrayList;
import java.util.Collections;

public class LeadersOfTheArray {
    public static void main(String[] args) {
        int[] nums = { 10, 22, 12, 3, 0, 6 };
        System.out.println(collectLeadersOptimal(nums));
    }

    static ArrayList<Integer> collectLeadersOptimal(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();

        int n = arr.length - 1;
        int max = Integer.MIN_VALUE;
        while (n >= 0) {
            boolean leader = false;
            if (arr[n] > max) {
                max = arr[n];
                leader = true;
            }
            if (leader) {
                res.add(arr[n]);
            }
            n--;
        }
        Collections.reverse(res);
        return res;
    }
}
