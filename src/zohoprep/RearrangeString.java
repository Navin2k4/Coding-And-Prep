
import java.util.PriorityQueue;

class RearrangeString {
    public static void main(String[] args) {
        System.out.println(rearrangeString("aab")); // Output: aba
        System.out.println(rearrangeString("aaab")); // Output: aba

    }

    public static String rearrangeString(String s) {
        StringBuilder ans = new StringBuilder();
        // map the frequencies
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[] { i, freq[i] });
            }
        }

        int[] prev = { -1, 0 };

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            ans.append((char) (current[0] + 'a'));
            current[1]--;
            if(prev[1] > 0){
                maxHeap.offer(prev);
            }
            prev = current;
            // System.out.println(ans);
        }

        return ans.length() == s.length() ? ans.toString() : "";
    }
}