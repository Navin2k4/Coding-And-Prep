package Recursion.StringSubSequences;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
        // subseqAscii("","abc");
        // subseq("","abc");
        subString("123", 0);
        // System.out.println(subseqArr("","abc"));
        // System.out.println(subseqAsciiArr("","abc"));
    }
    
    static void subString(String s, int start){
        if(start == s.length()) return;
        for(int end = start; end<s.length();end++){
            String currentSubString = s.substring(start, end+1);
            System.out.println(currentSubString);
        }
        subString(s, start+1);
    }

    static void subseq(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);  
            return;
        }
        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1)); // Taking the character
        subseq(p, up.substring(1));      // Rejecting the Character
    }
    // Arraylist in the function body
    static ArrayList<String> subseqArr(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseqArr(p + ch, up.substring(1)); // Taking the character
        ArrayList<String> right = subseqArr(p, up.substring(1));      // Rejecting the Character
        left.addAll(right);
        return left;
    }

    static void subseqAscii(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseqAscii(p + ch, up.substring(1)); // Taking the character
        subseqAscii(p, up.substring(1));      // Rejecting the Character
        subseqAscii(p+(ch+0),up.substring(1));
    }

    static ArrayList<String> subseqAsciiArr(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subseqAsciiArr(p + ch, up.substring(1)); // Taking the character
        ArrayList<String> second = subseqAsciiArr(p, up.substring(1));      // Rejecting the Character
        ArrayList<String> third = subseqAsciiArr(p+(ch+0), up.substring(1));      // Ascii of the Character
        first.addAll(second);
        first.addAll(third);
        return first;
    }

}
