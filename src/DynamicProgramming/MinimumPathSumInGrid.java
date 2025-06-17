package DynamicProgramming;

public class MinimumPathSumInGrid {
    public static void main(String[] args) {
        int[][] grid = {
                { 5, 3, 20 },
                { 20, 2, 1 },
                { 4, 20, 1 }
        };

        int rows = grid.length;
        int cols = grid[0].length;

        System.out.println(minPathSumOptimized(grid));

        // System.out.println(minPathSum(grid1, rows - 1, cols - 1));
    }

    static int minPathSumOptimized(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int dp[][] = new int[rows][cols];
        dp[0][0] = grid[0][0];

        int prev[] = new int[cols];

        for (int i = 0; i < rows; i++) {
            int curr[] = new int[cols];

            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else {
                    int up = (i > 0) ? prev[j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? curr[j - 1] : Integer.MAX_VALUE;
                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = curr;
        }

        return prev[cols - 1];
    }

    public int minPathSumDP(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int dp[][] = new int[rows][cols];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE;
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }

    static int minPathSum(int[][] grid, int row, int col) {

        if (row == 0 && col == 0)
            return grid[row][col];
        if (row < 0 || col < 0)
            return Integer.MAX_VALUE;

        int up = minPathSum(grid, row - 1, col);
        int left = minPathSum(grid, row, col - 1);

        int minPathCost = Math.min(up, left);
        int totalCost = grid[row][col] + minPathCost;

        return totalCost;
    }

}
