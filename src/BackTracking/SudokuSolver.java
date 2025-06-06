package BackTracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] LCBoard = new int[][]{
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9},
        };
        if(solve(LCBoard)){
            display(LCBoard);;
        } else {
            System.out.println("Cannot Solve");
        }

    }

    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;

        // this is how we are replacing r,c from the arguments
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            // if i found some empty element in row then break
            if (emptyLeft == false) {
                break;
            }
        }
        if (emptyLeft == true) {
            return true;
            // sudoku is solved
        }

        // backtrack
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    // found the answer
                    // display(board);
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    static boolean isSafe(int[][] board, int row, int col, int num) {
        // check if the number is in rows
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num)
                return false;
        }
        // check if the number is in column
        for (int[] nums : board) {
            if (nums[col] == num)
                return false;
        }
        // ckeck if the number is already in the 3*3 grid
        int sqrt = (int) (Math.sqrt(board.length));
        int colStart = row - row % sqrt;
        int rowStart = col - col % sqrt;
        for (int r = colStart; r < colStart + sqrt; r++) {
            for (int c = rowStart; c < rowStart + sqrt; c++) {
                if (board[r][c] == num)
                    return false;
            }
        }
        return true;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}


/*
 * For Leetcode
 class Solution {
    public void solveSudoku(char[][] board) {
        if (solve(board)) {
            printBoardAsArray(board);
        } else {
            System.out.println("Cannot Solve");
        }
    }

    static boolean solve(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if (!emptyLeft) {
                break;
            }
        }
        if (emptyLeft) {
            return true;
        }

        for (char number = '1'; number <= '9'; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    static boolean isSafe(char[][] board, int row, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num)
                return false;
        }
        for (char[] nums : board) {
            if (nums[col] == num)
                return false;
        }
        int sqrt = (int) (Math.sqrt(board.length));
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;
        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int c = boxColStart; c < boxColStart + sqrt; c++) {
                if (board[r][c] == num)
                    return false;
            }
        }
        return true;
    }

    private static void printBoardAsArray(char[][] board) {
        System.out.print("[");
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("\"" + board[i][j] + "\"");
                if (j < board[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < board.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
 */