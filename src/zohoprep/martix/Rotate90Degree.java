package zohoprep.martix;

public class Rotate90Degree {

    // ! Rotate matrix by 90 Degrees Clockwise
    // ! Rotate matrix by 270 Degrees Anti-Clockwise
    
    static int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };
    static int n = matrix.length;

    public static void main(String[] args) {
        // 1. Take the transpose of the matrix;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 2. Reverse each row of the matrix;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - i];
                matrix[i][n - 1 - i] = temp;
            }
        }
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
}
