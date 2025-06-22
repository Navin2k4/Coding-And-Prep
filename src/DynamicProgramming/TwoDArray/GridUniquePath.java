package DynamicProgramming.TwoDArray;

import java.util.Arrays;

public class GridUniquePath {

    public static void main(String[] args) {
        int m = 3, n = 3;

        int memDP[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memDP[i], -1);
        }

        // System.out.println(uniquePathsMem(m - 1, n - 1, memDP));

        System.out.println(uniquePathsTab(m, n));

    }

    static int uniquePathsTab(int row, int col) {
        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    static int uniquePathsMem(int row, int col, int[][] memDp) {
        if (row == 0 && col == 0)
            return 1;
        if (row < 0 || col < 0)
            return 0;

        if (memDp[row][col] != -1)
            return memDp[row][col];

        int up = uniquePathsMem(row - 1, col, memDp);
        int left = uniquePathsMem(row, col - 1, memDp);

        return memDp[row][col] = up + left;
    }

    static int uniquePaths(int row, int col) {
        if (row == 0 && col == 0)
            return 1;
        if (row < 0 || col < 0)
            return 0;

        int up = uniquePaths(row - 1, col);
        int left = uniquePaths(row, col - 1);

        return up + left;
    }

}
