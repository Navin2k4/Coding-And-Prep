import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyString {
    // find the prefix sub strings
    // find the suffis sub strings
    // Add it in the ds like string , and length of them

    public static void main(String[] args) {
        String s = "level";
        String s1 = "ababab";
        System.out.println(longestPrefix(s));
        System.out.println(longestPrefix(s1));
    }

    static String longestPrefix(String s) {
        String[] prefixes = findProperPrefixes(s);
        String[] suffixes = findProperSuffixes(s);

        Set<String> suffixSet = new HashSet<>(Arrays.asList(suffixes));

        for (int i = prefixes.length - 1; i >= 0; i--) {
            if (suffixSet.contains(prefixes[i])) {
                return prefixes[i];
            }
        }
        return "";
    }

    static String[] findProperPrefixes(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            result.add(s.substring(0, i));
        }
        return result.toArray(new String[0]);
    }

    static String[] findProperSuffixes(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            result.add(s.substring(i));
        }
        return result.toArray(new String[0]);
    }
}
