package DynamicProgramming.Strings;

public class MinimumInsertionToMakeStringPalindrome {
    public static void main(String[] args) {
        String text1 = "codingninjas";
        String text2 = new StringBuilder(text1).reverse().toString();
        System.out.println(LCS(text1, text2));
    }

    static int LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[n][m];
    }
}
