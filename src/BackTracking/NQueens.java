package BackTracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 5;
        // 4-> 2 ways
        // 5-> 14 ways
        // 8-> 5242 ways
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        // Placing the queen and checking for every row and column
        for (int col = 0; col < board.length; col++) {
            // place the queen if it is safe
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
            }
            board[row][col] = false;
        }
        return count;
    }

    // Gets all count of the placement ie including the rotations
    private static boolean isSafe(boolean board[][], int row, int col) {
        // check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - 1][col - 1]) {
                return false;
            }
        }
        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - 1][col + 1]) {
                return false;
            }
        }
        return true;
    }

    // For Distinct count of the placement
    private static boolean isSafeDistinct(boolean[][] board, int row, int col) {
        // check vertical column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // check diagonal left
        for (int i = 1; i <= row && col - i >= 0; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        // check diagonal right
        for (int i = 1; i <= row && col + i < board.length; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
    // [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    // to do it so that i can display as an internal list listinner list outer
    // method using the subset
    // Refer Recursion -> Subset
}
