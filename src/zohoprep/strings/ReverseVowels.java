package zohoprep.strings;

public class ReverseVowels {
    public static void main(String[] args) {
        System.err.println(modify("practice"));
    }

    static String modify(String s) {
        // your code here
        if (s == null || s.length() == 0)
            return s;
        char arr[] = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isVowel(arr[left]))
                left++;
            while (left < right && !isVowel(arr[right]))
                right--;

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);

    }

    static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

}
