public class WordReverseFromSubstring {
    public static void main(String[] args) {
        String S1 = "This is a test input string";
        String S2 = "st";

        System.out.println(reverseFromSubstring(S1, S2));
    }

    static String reverseFromSubstring(String S1, String S2) {
        int n = S1.length();
        StringBuilder result = new StringBuilder();

        // Store spaces and words separately
        String[] words = new String[100];
        String[] spaces = new String[100];
        int count = 0;

        StringBuilder word = new StringBuilder();
        StringBuilder space = new StringBuilder();

        boolean inWord = false;

        for (int i = 0; i < n; i++) {
            char c = S1.charAt(i);
            if (c != ' ') {
                if (!inWord) {
                    // start of a new word
                    spaces[count] = space.toString();
                    space.setLength(0);
                    inWord = true;
                }
                word.append(c);
            } else {
                if (inWord) {
                    // end of current word
                    words[count++] = word.toString();
                    word.setLength(0);
                    inWord = false;
                }
                space.append(c);
            }
        }

        // Add last word if string doesn't end in space
        if (word.length() > 0) {
            words[count++] = word.toString();
            spaces[count] = "";
        }

        // Find the first index where S2 appears as a substring in a word
        int startIndex = -1;
        for (int i = 0; i < count; i++) {
            if (containsSubstring(words[i], S2)) {
                startIndex = i;
                break;
            }
        }

        // Build the result
        for (int i = 0; i < startIndex; i++) {
            result.append(spaces[i]).append(words[i]);
        }

        // Reverse from startIndex onward
        for (int i = count - 1; i >= startIndex && startIndex != -1; i--) {
            result.append(spaces[i]).append(words[i]);
        }

        return result.toString();
    }

    // Custom method to check if word contains the substring (no inbuilt)
    static boolean containsSubstring(String word, String pattern) {
        int n = word.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && word.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) return true;
        }
        return false;
    }
}
