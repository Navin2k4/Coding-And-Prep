package zohoprep.strings;

import java.util.HashSet;
import java.util.Set;

public class RemoveFromSecondString {
    public static void main(String[] args) {
        String s1 = "expErIence";
        String s2 = "En";
        // Output s1 -> exprIece
        System.out.println(replace(s1, s2));
        

    }
    static String replace(String s1, String s2){
        StringBuilder res = new StringBuilder();
        Set<Character> toRemove = new HashSet<>();
        for(char ch : s2.toCharArray()){
            toRemove.add(ch);
        }
        for(char c : s1.toCharArray()){
            if(!toRemove.contains(c)){
                res.append(c);
            }
        }
        return res.toString();
    }
}

//*  Time	O(n + m) where n = s1.length(), m = s2.length()
//*  Space	O(m) for the HashSet storing characters of s2
