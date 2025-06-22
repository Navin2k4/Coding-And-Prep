public class ZigZagMatrixTraversal {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[] result = zigzagTraversal(matrix);
        System.out.print("Zig-Zag Traversal: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] zigzagTraversal(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];

        int index = 0;
        boolean up = true;

        for (int d = 0; d < m + n - 1; d++) {
            int r = (d < n) ? 0 : d - n + 1;
            int c = (d < n) ? d : n - 1;

            int tempR = r, tempC = c;

            if (up) {
                while (tempR < m && tempC >= 0) {
                    result[index++] = matrix[tempR++][tempC--];
                }
            } else {
                tempR = (d < m) ? d : m - 1;
                tempC = (d < m) ? 0 : d - m + 1;
                while (tempR >= 0 && tempC < n) {
                    result[index++] = matrix[tempR--][tempC++];
                }
            }
            up = !up;
        }

        return result;
    }
}
