package DynamicProgramming;

public class GridUniquePathWithObstacle {

    public static void main(String[] args) {

        int[][] obstacleGrid = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };

        System.out.println(uniquePathsRec(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1));

    }

    static int uniquePathsTab(int grid[][]) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1)
            return 0;

        int dp[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = (i > 0) ? grid[i - 1][j] : 0;
                    int down = (j > 0) ? grid[i][j - 1] : 0;
                    dp[i][j] = up + down;
                }
            }
        }
        return dp[rows - 1][cols - 1];

    }

    static int uniquePathsRec(int grid[][], int row, int col) {
        if (row == 0 && col == 0)
            return 1;
        if (row < 0 || col < 0)
            return 0;
        int up = 0;
        int down = 0;
        if (grid[row][col] != 1) {
            up = uniquePathsRec(grid, row - 1, col);
            down = uniquePathsRec(grid, row, col - 1);
        }
        return up + down;
    }
}
