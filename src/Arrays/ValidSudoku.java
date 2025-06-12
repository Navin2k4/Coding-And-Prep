package Arrays;

import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
    public static void main(String[] args) {
        char[][] board1 = {
                { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        char[][] board2 = {
                { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '1', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        int[][] board3 = { { 7, 9, 2, 1, 5, 4, 3, 8, 6 },
                { 6, 4, 3, 8, 2, 7, 1, 5, 9 },
                { 8, 5, 1, 3, 9, 6, 7, 2, 4 },
                { 2, 6, 5, 9, 7, 3, 8, 4, 1 },
                { 4, 8, 9, 5, 6, 1, 2, 7, 3 },
                { 3, 1, 7, 4, 8, 2, 9, 6, 5 },
                { 1, 3, 6, 7, 4, 8, 5, 9, 2 },
                { 9, 7, 4, 2, 1, 5, 6, 3, 8 },
                { 5, 2, 8, 6, 3, 9, 4, 1, 7 } };
        System.out.println(isValidSudokuBrute(board1) ? "Valid" : "Not Valid");
        System.out.println(isValidSudokuBrute(board2) ? "Valid" : "Not Valid");
        System.out.println(isValidSudokuBrute(board3) ? "Valid" : "Not Valid");
    }

    static boolean isValidSudokuBrute(char[][] board) {
        // Row check
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowChecker = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!rowChecker.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        // Column check
        for (int j = 0; j < board[0].length; j++) {
            Set<Character> colChecker = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    if (!colChecker.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        // 3*3 box checks
        for (int row = 0; row < board.length; row += 3) {
            for (int col = 0; col < board[0].length; col += 3) {
                Set<Character> boxChecker = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char current = board[row + i][col + j];
                        if (current != '.') {
                            if (!boxChecker.add(current)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    static boolean isValidSudokuBrute(int[][] mat) {
        int[][] rows = new int[10][10];
        int[][] cols = new int[10][10];
        int[][] subMat = new int[10][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                // Skip empty cells
                if (mat[i][j] == 0)
                    continue;

                // Current value
                int val = mat[i][j];

                // Check for duplicates in row
                if (rows[i][val] == 1)
                    return false;

                // Mark as seen
                rows[i][val] = 1;

                // Check for duplicates in column
                if (cols[j][val] == 1)
                    return false;

                // Mark as seen
                cols[j][val] = 1;

                // Check for duplicates in sub-grid
                int idx = (i / 3) * 3 + j / 3;
                if (subMat[idx][val] == 1)
                    return false;

                // Mark as seen
                subMat[idx][val] = 1;
            }
        }
        return true;
    }

}
