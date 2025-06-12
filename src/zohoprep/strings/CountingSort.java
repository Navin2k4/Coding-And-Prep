package zohoprep.strings;

public class CountingSort {
    public static void main(String[] args) {
        String s = "edebsab";
        System.out.println(countSort(s));
    }

    static String countSort(String arr) {
        int[] freq = new int[26];
        for (char c : arr.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                for (int j = 0; j < freq[i]; j++) {
                    char c = (char) (i + 'a');
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
