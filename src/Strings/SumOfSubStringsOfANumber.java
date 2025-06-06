package Strings;

import java.util.ArrayList;
import java.util.List;

// Geek For Geek daily Problem Solution date 24/05/25

class AnsHelper {
    int answer = 0;
    List<String> substrings = new ArrayList<>();
}


public class SumOfSubStringsOfANumber {
    // static int subStringSumUsingMath(String s){
    //     // sum[i] = (i + 1) * digit[i] + 10 * sum[i - 1]
    //     int n = s.length();
    //     int mod = 1000000007;
    //     long result = 0;
    //     long prev = 0;

    //     for (int i = 0; i < n; i++) {
    //         int num = s.charAt(i) - '0';
    //         prev = (prev*10 + num*(i+1));
    //         result += prev;
    //     }

    //     return (int)result;
    // }

    static void subStringHelper(String s, int start, AnsHelper helper){
        if(start == s.length()) return;
        for(int end = start; end<s.length();end++){
        
            String currentSubString = s.substring(start, end+1);
            int value = Integer.parseInt(currentSubString);
            // or simply use ans[0] as integer array reference this is just to learn that we can use the class to make some more and play around
            helper.answer += value;
            helper.substrings.add(currentSubString);
        
        }
        subStringHelper(s, start+1, helper);
    }

    
    public static void main(String[] args) {
        String s = "1234";
        AnsHelper helper = new AnsHelper();
        subStringHelper(s, 0, helper);
        System.out.println(helper.answer);
        System.out.println(helper.substrings);
        // System.out.println(subStringSumUsingMath(s));
    }   
}
