package zohoprep.strings;

public class GetConsecutiveCharCount {
    public static void main(String[] args) {
        System.out.println(getCount("geeksforgeeks", 2));
    }
    static int getCount(String S, int N) {
        // your code here
        int[] freq = new int[26];
        int len = S.length();
    
        for (int i = 0; i < len; i++) {
            char ch = S.charAt(i);
            if (i > 0 && S.charAt(i) == S.charAt(i - 1)) continue;
            freq[ch - 'a']++;
        }
    
        int count = 0;
        for (int f : freq) {
            if (f == N) count++;
        }
        return count;
    }
}
