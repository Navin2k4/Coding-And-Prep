package zohoprep.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "ilike";
        // String s1 = "ilikemangoes";
        String dictionary[] = { "i", "like", "gfg" };
        System.out.println(wordBreak(s, dictionary));
        // System.out.println(wordBreak(s1, dictionary));
    }

    static boolean wordBreak(String s, String[] dictionary) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1;i<=n;i++){
            for(int j =0;j<i;j++){
                String word = s.substring(j,i);
                if(dp[j] && wordSet.contains(word)){
                    dp[i] = true;
                    System.out.println(Arrays.toString(dp) + " " + word );
                    break;
                }
            }
        }

        return dp[n];        
    }
}
