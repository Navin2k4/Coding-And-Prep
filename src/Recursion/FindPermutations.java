package Recursion;


public class FindPermutations {
    static boolean isValid(char c) {
        return "abc".indexOf(c) != -1;
    }
    static void numberOfSubstrings(String s) {
        // sliding window expand and shring the window in the iteration to get the substrings
        int n = s.length();
        int left = 0 ;
        int right = 0 ;
        int count = 0;
//        expand the right side window until it reaches the last
        StringBuilder string = new StringBuilder();
        while(right < n){
            string.append(s.charAt(right));
            while (string.indexOf("a") != -1 &&
                    string.indexOf("b") != -1 &&
                    string.indexOf("c") != -1) {
                count += (n-right);
                string.deleteCharAt(0);
                left++;
            }
            right++;
        }
            System.out.println("Total number of substrings: " + count);
//        shrink the left side window until the end is reached
    }
    public static void main(String[] args) {
        numberOfSubstrings("abcabc");
    }
}
