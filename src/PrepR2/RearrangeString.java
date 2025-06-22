import java.util.*;

public class RearrangeString {
    public static void main(String[] args) {
        System.out.println(rearrange("aaabc"));   // Output: abaca or similar
        System.out.println(rearrange("aa"));      // Output: ""
        System.out.println(rearrange("aaaabc"));  // Output: ""
    }

    public static String rearrange(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freq[b - 'a'] - freq[a - 'a']
        );

        for (char c = 'a'; c <= 'z'; c++) {
            if (freq[c - 'a'] > 0) {
                maxHeap.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();
        char prev = '#';  // dummy previous character
        int prevFreq = 0;

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();

            // Append the current char
            result.append(current);
            freq[current - 'a']--;

            // If the previous character still has frequency left, push it back
            if (prevFreq > 0) {
                maxHeap.offer(prev);
            }

            // Update prev
            prev = current;
            prevFreq = freq[current - 'a'];
        }

        // Final check: If result is same length as input, return it. Else, impossible.
        return result.length() == s.length() ? result.toString() : "";
    }
}
