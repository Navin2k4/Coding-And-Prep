package zohoprep.patterns;

// Given an odd length word which should be printed from the middle of the word. 
// Example: 
// Input: PROGRAM  be in the following 
// pattern. 

// Output: 
// G 
// GR 
// GRA 
// GRAM 
// GRAMP 
// GRAMPR 
// GRAMPRO 

public class PrintFromMiddleForOddLengthString {
    public static void main(String[] args) {
        String s = "PROGRAM";
        // printFromMiddle(s);
        printFromMiddleOptimized(s);
    }
    static void printFromMiddle(String s){
        int midInd = (s.length() / 2);
        int start = 0;
        int temp  = midInd;
        int end = s.length()-1;
        StringBuilder res = new StringBuilder("");
        while(temp <= end){
            res.append(s.charAt(temp));
            System.out.println(res);
            temp++;
        }
        while(start < midInd){
            res.append(s.charAt(start));
            System.out.println(res);
            start++;
        }
    }
    static void printFromMiddleOptimized(String s) {
        int n = s.length();
        int mid = n / 2;
        for (int i = mid; i < n; i++) {
            System.out.println(s.substring(mid, i+1));
        }
        for (int i = 0; i < mid; i++) {
            System.out.println(s.substring(mid) + s.substring(0, i+1));
        }
    }

}
