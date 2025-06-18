package DynamicProgramming.Strings;

public class LongestCommonSubstringLCS {
    // Substring should be consecutive on the order
    public static void main(String[] args) {
        String text1 = "abcd";
        String text2 = "abfd";
        System.out.println(dpLCS(text1, text2));
    }

    static int dpLCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = 0;
                }
            }
        }

        int longest = 0;
        int endIndex = 0; // End index of substring in s1

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] > longest) {
                    longest = dp[i][j];
                    endIndex = i;
                }
            }
        }
        String longestSubstr = s1.substring(endIndex - longest, endIndex);
        System.out.println("Longest Common Substring: " + longestSubstr);
        return longest;
    }
}
