
public class AddAndMoveZeroToLast {
    public static void main(String[] args) {
        int[] arr = { 0, 2, 2, 2, 0, 6, 6, 0, 8 };
        // 4 2 12 8 0 0 0 0 0
        moveElements(arr);
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    static void moveElements(int[] arr) {
        int n = arr.length;

        // Sum up the consecutives
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != 0 && arr[i] == arr[i + 1]) {
                arr[i] += arr[i + 1];
                arr[i + 1] = 0;
                i++;
            }
        }

        // Move the elements to the front
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }

        // Fill extra spaces woth 0s
        while (index < n) {
            arr[index++] = 0;
        }
    }

}
