public class LargestNumberFormation {
    public static void main(String[] args) {
        Integer[] arr = { 8, 7, 9, 1 };
        // inbuilt sort sort the answer wil be found O(n log n); Optimal
        // Arrays.sort(arr, Collections.reverseOrder()); append to the string

        // better
        int count[] = new int[10];
        for (int num : arr) {
            count[num]++;
        }

        StringBuilder res = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            while (count[i] > 0) {
                res.append(i);
                count[i]--;
            }
        }
        System.out.println(res);
    }
}
