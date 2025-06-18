package DynamicProgramming.Strings;

public class LargestCommonSubSequenceLCS {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(recLCS(text1.length() - 1, text2.length() - 1, text1, text2));
        System.out.println(dpLCS(text1, text2));

    }

    static int recLCS(int i1, int i2, String s1, String s2) {
        if (i1 < 0 || i2 < 0)
            return 0;

        if (s1.charAt(i1) == s2.charAt(i2))
            return 1 + recLCS(i1 - 1, i2 - 1, s1, s2);

        return Math.max(recLCS(i1 - 1, i2, s1, s2), recLCS(i1, i2 - 1, s1, s2));
    }

    static int dpLCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n;
        int j = m;
        char res[] = new char[dp[n][m]];
        int index = res.length - 1;
        while (i > 0 || j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                res[index] = s1.charAt(i - 1);
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : res) {
            ans.append(ch);
        }
        System.out.println(ans.toString());
        return dp[n][m];
    }
}
