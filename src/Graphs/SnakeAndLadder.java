package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {

    static class Pair {
        int position;
        int steps;

        public Pair(int position, int steps) {
            this.position = position;
            this.steps = steps;
        }
    }

    public static void main(String[] args) {
        int[][] board1 = {
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 15, -1, -1, -1, -1 }
        };
        System.out.println(snakesAndLadders(board1));
    }

    static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, 0));

        while (!queue.isEmpty()) {

            Pair curretPair = queue.poll();
            int pos = curretPair.position;
            System.out.println("Visiting: " + pos);
            int steps = curretPair.steps;

            // Check for the 6 possible steps
            for (int i = 0; i < 6; i++) {
                int nextPos = pos + i;
                if (nextPos > target)
                    break;

                int[] rowcol = intToPos(nextPos, n);
                int newRow = rowcol[0];
                int newCol = rowcol[1];

                if (board[newRow][newCol] != -1) {
                    nextPos = board[newRow][newCol];
                }

                if (nextPos == target)
                    return steps + 1;

                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.offer(new Pair(nextPos, steps + 1));
                }
            }
        }

        return -1;
    }

    // To map a cell number to (row, col), use:
    static int[] intToPos(int pos, int n) {
        int rFromBottom = (pos - 1) / n;
        int c = (pos - 1) % n;

        int row = n - 1 - rFromBottom;
        int col = (rFromBottom % 2 == 0) ? c : n - 1 - c;

        return new int[] { row, col };
    }
}