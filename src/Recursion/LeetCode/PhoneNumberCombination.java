package Recursion.LeetCode;

import java.util.ArrayList;

public class PhoneNumberCombination {
    public static void main(String[] args) {
        // phonepad("", "1");
        System.out.println(phonepadArrList("","12"));
    }
    static void phonepad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; // Convert '2' to 2

        for (int i = (digit-1)*3 ; i < digit*3 ; i++) { // Refer notes
            char ch = (char)('a' + i);
            phonepad(p+ch,up.substring(1));
        }
    } 
    
    static ArrayList<String> phonepadArrList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0'; // Convert '2' to 2
        ArrayList<String> ans = new ArrayList<>();
        for (int i = (digit-1)*3 ; i < digit*3 ; i++) { // Refer notes
            char ch = (char)('a' + i);
            ans.addAll(phonepadArrList(p+ch,up.substring(1)));
        }
        return ans;
    }
}


/* LeetCode Soltion
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            ArrayList<String> list = new ArrayList<>();
            return list;
        }
        return phonepadArrList("",digits);
    }
    static ArrayList<String> phonepadArrList(String p, String ip){
        if(ip.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        int digit = ip.charAt(0) - '0';
        int i=(digit-2)*3;
        if(digit > 7) {
            i+=1;
        }
        int len = i+3;
        if(digit == 7 || digit == 9) {
            len+=1;
        }
        
        ArrayList<String> list = new ArrayList<>();
                
        for(; i<len; i++) {
            char ch = (char)('a' + i);
            list.addAll(phonepadArrList(p+ch, ip.substring(1)));
        }
        
        return list;
    }
}

*/