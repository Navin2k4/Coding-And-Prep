package DynamicProgramming.Strings;

public class WildcardMatching {
    public static void main(String[] args) {
        // String s1 = "ab*cd"; // pattern
        // String s2 = "abdefcd"; // string
        String s1 = "baaaaba*****b***ab******"; // pattern
        String s2 = "aaaababbbaaabaabbbbabaababaabbabbaabababbaaaaaaabba"; // string
        int n = s1.length();
        int m = s2.length();
        // System.out.println(isMatch(n - 1, m - 1, s1, s2));
        System.out.println(isMatchDP(s1, s2));
    }

    static boolean isMatchDP(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base case 1
        dp[0][0] = true;

        // Base case 2
        for (int j = 1; j <= m; j++) {
            dp[0][j] = false; // Pattern is empty
        }

        // Base case 3
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == '*';
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char p = s1.charAt(i - 1);
                char t = s2.charAt(j - 1);
                if (p == t || p == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    // TLE will rise
    static boolean isMatch(int i1, int i2, String s1, String s2) {
        if (i1 < 0 && i2 < 0)
            return true;
        if (i1 < 0 && i2 >= 0)
            return false;
        if (i2 < 0 && i1 >= 0) {
            for (int i = 0; i <= i1; i++) {
                if (s1.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        if (s1.charAt(i1) == s2.charAt(i2) || s1.charAt(i1) == '?') {
            return isMatch(i1 - 1, i2 - 1, s1, s2);
        }
        if (s1.charAt(i1) == '*') {
            return isMatch(i1 - 1, i2, s1, s2) || isMatch(i1, i2 - 1, s1, s2);
        }
        return false;
    }

}
