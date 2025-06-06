package Traversals;

public class MatrixTraversal {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3 , 4},
                {5, 6, 7 , 8},
                {9, 10, 11 ,12 }
        };

        System.out.println("Row-wise Traversal:");
        rowWiseTraversal(matrix);

        System.out.println("\nColumn-wise Traversal:");
        columnWiseTraversal(matrix);

        System.out.println("\nDiagonal Traversal (Main Diagonal):");
        mainDiagonalTraversal(matrix);

        System.out.println("\nDiagonal Traversal (Anti-Diagonal):");
        antiDiagonalTraversal(matrix);

        System.out.println("\nSpiral Traversal:");
        spiralTraversal(matrix);

        System.out.println("Snake Pattern:");
        snakePattern(matrix);

        System.out.println("\nZig-Zag (Diagonal) Traversal:");
        zigZagTraversal(matrix);

        System.out.println("\nWave Pattern:");
        wavePattern(matrix);

        System.out.println("\nBoundary Traversal:");
        boundaryTraversal(matrix);

        System.out.println("\nKnight’s Move Traversal:");
        knightsMoveTraversal(matrix);
    }

    // Row-wise traversal (Left to Right)
    static void rowWiseTraversal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Column-wise traversal (Top to Bottom)
    static void columnWiseTraversal(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main diagonal traversal (Top-left to Bottom-right)
    static void mainDiagonalTraversal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
    }

    // Anti-diagonal traversal (Top-right to Bottom-left)
    static void antiDiagonalTraversal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][matrix.length - 1 - i] + " ");
        }
        System.out.println();
    }

    // Spiral Traversal
    static void spiralTraversal(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) System.out.print(matrix[top][i] + " ");
            top++;

            for (int i = top; i <= bottom; i++) System.out.print(matrix[i][right] + " ");
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) System.out.print(matrix[bottom][i] + " ");
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) System.out.print(matrix[i][left] + " ");
                left++;
            }
        }
        System.out.println();
    }

    static void snakePattern(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) { // Left to right
                for (int j = 0; j < matrix[0].length; j++)
                    System.out.print(matrix[i][j] + " ");
            } else { // Right to left
                for (int j = matrix[0].length - 1; j >= 0; j--)
                    System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    // 2. Zig-Zag (Diagonal) Traversal
    static void zigZagTraversal(int[][] matrix) {
        int n = matrix.length;
        for (int d = 0; d < 2 * n - 1; d++) {
            int row = d < n ? d : n - 1;
            int col = d < n ? 0 : d - (n - 1);
            while (row >= 0 && col < n) {
                System.out.print(matrix[row][col] + " ");
                row--;
                col++;
            }
        }
        System.out.println();
    }

    // 3. Wave Pattern (Column-wise top-bottom, bottom-top)
    static void wavePattern(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (j % 2 == 0) { // Top to bottom
                for (int i = 0; i < matrix.length; i++)
                    System.out.print(matrix[i][j] + " ");
            } else { // Bottom to top
                for (int i = matrix.length - 1; i >= 0; i--)
                    System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    // 4. Boundary Traversal (Only outermost layer)
    static void boundaryTraversal(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < m; i++) System.out.print(matrix[0][i] + " "); // Top row
        for (int i = 1; i < n; i++) System.out.print(matrix[i][m - 1] + " "); // Right column
        if (n > 1) for (int i = m - 2; i >= 0; i--) System.out.print(matrix[n - 1][i] + " "); // Bottom row
        if (m > 1) for (int i = n - 2; i > 0; i--) System.out.print(matrix[i][0] + " "); // Left column
        System.out.println();
    }

    // ♞ 5. Knight’s Move Traversal (L-shape jumps)
    static void knightsMoveTraversal(int[][] matrix) {
        int[] rowMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};

        int startRow = 0, startCol = 0;
        System.out.print(matrix[startRow][startCol] + " ");

        for (int i = 0; i < 8; i++) {
            int newRow = startRow + rowMoves[i];
            int newCol = startCol + colMoves[i];

            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length) {
                System.out.print(matrix[newRow][newCol] + " ");
            }
        }
        System.out.println();
    }
}
