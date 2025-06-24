package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    static class Pair {
        int row;
        int col;
        int dist;

        public Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 0, 1 },
                { 1, 1, 0 },
                { 1, 0, 0 }
        };
        for (int[] is : updateMatrix(mat)) {
            System.out.println(Arrays.toString(is));
        }
    }

    static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int row = current.row;
            int col = current.col;
            int dist = current.dist;

            distance[row][col] = dist;

            for (int[] dir : directions) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    queue.add(new Pair(nRow, nCol, dist + 1));
                }
            }
        }

        return distance;
    }

}
