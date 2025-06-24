package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) {
        char[][] board = {
                { 'X', 'O', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X', 'X' },
                { 'X', 'X', 'O', 'X', 'O' },
                { 'X', 'O', 'X', 'O', 'O' },
                { 'X', 'X', 'X', 'X', 'X' }
        };

        solve(board);
    }

    static void solve(char[][] board) {
        // check for all the boundary that has the '0'
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            bfs(board, row, 0);
            bfs(board, row, rows - 1);
        }

        for (int col = 0; col < cols; col++) {
            bfs(board, 0, col);
            bfs(board, cols - 1, col);
        }

        for(int i = 0 ;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j] == 'T') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        for (char[] row : board) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

    }

    static void bfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;

        // Only process the region
        if (board[row][col] != 'O')
            return;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        board[row][col] = 'T';

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            int curRow = currentPair.row;
            int curCol = currentPair.col;

            for (int[] dir : directions) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] == 'O') {
                    board[newRow][newCol] = 'T';
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }

    }
}
