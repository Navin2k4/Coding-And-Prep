package zohoprep.strings;

import java.util.ArrayList;

public class KMPAlgo {
    static final int d = 256; 
    
    public static void main(String[] args) {
        System.out.println(searchKnuthMorrisPrattlgo("birth", "birthdayboybirth").toString());
        System.out.println(searchRabinKarpAlgo("happyhap", "hap", 101).toString());
    }

    static ArrayList<Integer> searchKnuthMorrisPrattlgo(String pattern, String text) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pattern.length();
        int n = text.length();

        // Step 1: Build LPS Array
        int[] lps = new int[m];
        int len = 0;
        for (int i = 1; i < m;) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Step 2: Search using KMP
        int i = 0, j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j); // match found
                j = lps[j - 1];
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    static ArrayList<Integer> searchRabinKarpAlgo(String text, String pattern, int q) {
        int m = pattern.length();
        int n = text.length();
        int range = n-m;
        int p = 0; 
        int t = 0; 
        int h = 1; 
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }
        System.out.println(h);

        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }
        System.out.println("Hash Initial : "+ p + " Hash pattern : "+t);

        // Slide the pattern over text one by one
        for (int i = 0; i <= range; i++) {
            // Check hash values of current window and pattern
            if (p == t) {
                // Hashes match, check character by character
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == m)
                    result.add(i);
            }

            // Calculate hash for next window
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                // We might get negative value of t, convert it to positive
                if (t < 0) t = (t + q);

                System.out.println(t);
            }
        }
        return result;
    }

}
