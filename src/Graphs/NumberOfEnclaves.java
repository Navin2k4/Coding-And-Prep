package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
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
        int[][] grid = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };
        // int[][] grid1 = {
        // { 0, 1, 1, 0 },
        // { 0, 0, 1, 0 },
        // { 0, 0, 1, 0 },
        // { 0, 0, 0, 0 }
        // };
        solve(grid);
    }

    static void solve(int[][] board) {
        // check for all the boundary that has the '0'
        int rows = board.length;
        int cols = board[0].length;
        int enclavesCount = 0;

        for (int row = 0; row < rows; row++) {
            bfs(board, row, 0);
            bfs(board, row, cols - 1);
        }

        for (int col = 0; col < cols; col++) {
            bfs(board, 0, col);
            bfs(board, rows - 1, col);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    enclavesCount++;
                    board[i][j] = 0;
                }
            }
        }
        System.out.println("Enclaves Count = " + enclavesCount);
    }

    static void bfs(int[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;

        // Only process the region
        if (board[row][col] != 1)
            return;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        board[row][col] = -1;

        while (!queue.isEmpty()) {
            Pair currentPair = queue.poll();
            int curRow = currentPair.row;
            int curCol = currentPair.col;

            for (int[] dir : directions) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] == 1) {
                    board[newRow][newCol] = -1;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }

    }
}
