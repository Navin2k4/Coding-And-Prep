package zohoprep.martix;

public class Rotate180Degree {
    static int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };
    static int n = matrix.length;

    public static void main(String[] args) {
        // Method 1. Rotate matrix 90 Degree 2 times
        // Method 2. Reverse the rows -> reverse the columns O(mn)

        // Reverse the rows
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        // Reverse the columns
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n / 2; i++) { 
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
        // rotate180InPlace(matrix);
        display();
    }

    static void display() {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    static void rotate180InPlace(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < m; j++) {
                // Skip middle row if n is odd and we're on the middle row
                if (n % 2 == 1 && i == n / 2 && j >= m / 2)
                    break;

                int ni = n - 1 - i;
                int nj = m - 1 - j;

                // Avoid double-swap for the middle element in odd x odd
                if (i == ni && j >= nj) continue;

                int temp = matrix[i][j];
                matrix[i][j] = matrix[ni][nj];
                matrix[ni][nj] = temp;
            }
        }
    }

}
