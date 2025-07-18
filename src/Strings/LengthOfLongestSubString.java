import java.util.*;

public class LengthOfLongestSubString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int maxLength = 1;
        int i = 0;
        int j = 0;
        while (j < n && i < n) {
            char ch = s.charAt(j);
            System.out.println(s.substring(i, j) + " " + set);
            if (set.contains(ch)) {
                while (i <= j && set.contains(ch)) {
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            set.add(ch);
            j++;
            maxLength = Math.max(set.size(), maxLength);
        }
        return maxLength;
    }
}
