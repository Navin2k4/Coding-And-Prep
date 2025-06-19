package Graphs;

class IPair {
    int row;
    int col;

    public IPair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class NumberOfIslandConnectedComponents {

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println(numIslands(grid)); // Output: 1
    }

    static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callBfs(i, j, grid);
                }
            }
        }
        return count;
    }

    static void callBfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length)
            return;
        if (j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        callBfs(i - 1, j, grid);
        callBfs(i + 1, j, grid);
        callBfs(i, j - 1, grid);
        callBfs(i, j + 1, grid);
    }

    // static int numIslands(char[][] grid) {
    // int isLandCount = 0;
    // int n = grid.length;
    // int m = grid[0].length;
    // boolean[][] visited = new boolean[n][m];

    // for (int row = 0; row < n; row++) {
    // for (int col = 0; col < m; col++) {
    // if (!visited[row][col] && grid[row][col] == '1') {
    // isLandCount++;
    // bfs(grid, visited, row, col);
    // }
    // }
    // }
    // return isLandCount;
    // }

    // static void bfs(char[][] grid, boolean[][] visited, int row, int col) {
    // Queue<IPair> q = new LinkedList<>();
    // int n = grid.length;
    // int m = grid[0].length;
    // q.add(new IPair(row, col));
    // visited[row][col] = true;
    // int[] dx = { -1, 1, 0, 0 };
    // int[] dy = { 0, 0, -1, 1 };

    // while (!q.isEmpty()) {
    // IPair node = q.poll();
    // int r = node.row;
    // int c = node.col;

    // for (int i = 0; i < 4; i++) {
    // int nRow = r + dx[i];
    // int nCol = c + dy[i];
    // if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
    // grid[nRow][nCol] == '1' && !visited[nRow][nCol]) {
    // q.add(new IPair(nRow, nCol));
    // visited[nRow][nCol] = true; // ✅ mark visited here
    // }
    // }
    // }
    // }

}
