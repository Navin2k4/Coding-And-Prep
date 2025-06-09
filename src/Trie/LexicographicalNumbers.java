package Trie;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(12));
    }

    static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int curr = 1;
        for (int i = 0; i < n; i++) {
            result.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10;
                }
                curr += 1;
            }
        }
        return result;
    }
}
