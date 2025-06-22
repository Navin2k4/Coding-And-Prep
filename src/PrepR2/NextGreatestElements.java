public class NextGreatestElements {
    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };
        replaceWithNextGreatest(arr);

        // Output
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void replaceWithNextGreatest(int[] arr) {
        int n = arr.length;
        int maxSoFar = -1;

        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = maxSoFar;
            if (current > maxSoFar) {
                maxSoFar = current;
            }
        }
    }
}
