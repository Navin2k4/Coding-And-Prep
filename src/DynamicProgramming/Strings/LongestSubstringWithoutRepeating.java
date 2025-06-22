package DynamicProgramming.Strings;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestUniqueSubstring(s)); // Output: 3
    }

    static int lengthOfLongestUniqueSubstring(String s) {
        int n = s.length();
        int[] lastIndex = new int[256]; // ASCII character set
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }

        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            char current = s.charAt(end);

            // If char was seen and is in current window
            if (lastIndex[current] >= start) {
                start = lastIndex[current] + 1;
            }

            lastIndex[current] = end;
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}
