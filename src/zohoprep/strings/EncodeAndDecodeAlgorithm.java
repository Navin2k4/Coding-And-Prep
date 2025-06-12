package zohoprep.strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeAlgorithm {

    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length()).append('#').append(s);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            // Read until we find the delimiter #
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1; // move past '#'
            String word = str.substring(i, i + len);
            result.add(word);
            i += len;
        }

        return result;
    }

    // Demo main method
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("neet");
        input.add("code");
        input.add("love");
        input.add("you");

        String encoded = encode(input);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
