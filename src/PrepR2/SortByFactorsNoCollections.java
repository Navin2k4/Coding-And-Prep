public class SortByFactorsNoCollections {

    // Count number of positive factors of a number
    public static int countFactors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) count++;
                else count += 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 23, 32, 100};
        int n = arr.length;

        // Create 2D array: [number][factor count]
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = arr[i];
            data[i][1] = countFactors(arr[i]);
        }

        // Sort the 2D array using custom logic (Selection Sort)
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j][1] < data[minIndex][1] ||
                    (data[j][1] == data[minIndex][1] && data[j][0] < data[minIndex][0])) {
                    minIndex = j;
                }
            }
            // Swap rows
            int[] temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }

        // Output the sorted numbers
        System.out.print("Sorted by number of factors: [ ");
        for (int i = 0; i < n; i++) {
            System.out.print(data[i][0] + " ");
        }
        System.out.println("]");
    }
}
