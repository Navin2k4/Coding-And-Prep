package DynamicProgramming.Strings;

import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int n = word1.length();
        int m = word2.length();

        int[][] memDP = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memDP[i], -1);
        }

        System.out.println(minDistanceRec(word1, word2, n, m));
        System.out.println(minDistanceMem(word1, word2, n, m, memDP));
        System.out.println(minDistance(word1, word2));
    }

    static int minDistanceRec(String w1, String w2, int i, int j) {
        if (i == 0)
            return j;
        if (j == 0)
            return i;

        if (w1.charAt(i - 1) == w2.charAt(j - 1))
            return minDistanceRec(w1, w2, i - 1, j - 1);

        int insert = 1 + minDistanceRec(w1, w2, i, j - 1);
        int delete = 1 + minDistanceRec(w1, w2, i - 1, j);
        int replace = 1 + minDistanceRec(w1, w2, i - 1, j - 1);
        return Math.min(insert, Math.min(delete, replace));
    }

    static int minDistanceMem(String w1, String w2, int i, int j, int[][] dp) {
        if (i == 0)
            return j;
        if (j == 0)
            return i;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (w1.charAt(i - 1) == w2.charAt(j - 1))
            return dp[i][j] = minDistanceMem(w1, w2, i - 1, j - 1, dp);

        int insert = 1 + minDistanceMem(w1, w2, i, j - 1, dp);
        int delete = 1 + minDistanceMem(w1, w2, i - 1, j, dp);
        int replace = 1 + minDistanceMem(w1, w2, i - 1, j - 1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            dp[i][0] = i;
        for (int j = 0; j < m; j++)
            dp[0][j] = j;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n-1][m-1];
    }

}
