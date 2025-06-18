package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int time;

    public Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        System.out.println(orangesRotting(grid));
    }

    static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int visited[][] = new int[n][m];
        int countFresh = 0;
        // traverse across the grid and gather the oranges that are rotten;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1)
                    countFresh++;
            }
        }

        int tm = 0;
        int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int count = 0;
        // {-1,0} up {0,1} right {1,0} botton {0,-1} left
        while ((!q.isEmpty())) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            tm = Math.max(t, tm);
            q.remove();
            // try moving all the 4 directions
            for (int i = 0; i < 4; i++) {
                int nrow = r + dir[i][0];
                int ncol = c + dir[i][1];
                // check for the boundaries
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, t + 1));
                    visited[nrow][ncol] = 2;
                    count++;
                }
            }
        }
        if (count != countFresh)
            return -1;
        return tm;
    }

}
