import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"tar", "rat", "banana", "atr", "nanaba"};
        groupAnagrams(input);
    }

    public static void groupAnagrams(String[] words) {
        if (words == null || words.length == 0) return;

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            // Convert word to char array, sort it, then turn back into string
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            // Group by sorted key
            map.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }

        // Print the grouped anagrams
        System.out.println("Anagrams:");
        for (List<String> group : map.values()) {
            if (group.size() > 1) {
                System.out.println(String.join(" ", group));
            }
        }
    }
}
