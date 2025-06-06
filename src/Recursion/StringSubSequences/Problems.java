package Recursion.StringSubSequences;

public class Problems {
    public static void main(String[] args) {
        //? Q1 :Remove a particular character from the string using recursive function and also try by creating a variable in the body of the function
        skip("", "baccad");  
        System.out.println(skip("baccad"));
        // Q2 :Remove a particular string from the string using recursive function and also try by creating a variable in the body of the function
        System.out.println(skipString("bcdapplefg","apple"));
        System.out.println(skipSubStringNotString("bcdapplefg","apple","app"));
        System.out.println(skipSubStringNotString("bcdapplfg","apple","app"));
    }
    static void skip (String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        if(ch=='a'){
            skip(processed,unprocessed.substring(1));
        } else {
            skip(processed+ch,unprocessed.substring(1));
        }
    }
    static String skip(String unprocessed){
        if(unprocessed.isEmpty()){
            return "";
        }
        char ch = unprocessed.charAt(0);
        if(ch =='a'){
            return skip(unprocessed.substring(1));
        } else {
            return ch + skip(unprocessed.substring(1));
        }
    }
    static String skipString(String unprocessed,String toSkip){
        if(unprocessed.isEmpty()){
            return "";
        }
        if(unprocessed.startsWith(toSkip)){
            return skipString(unprocessed.substring(toSkip.length()),toSkip);
        } else {
            return unprocessed.charAt(0) + skipString(unprocessed.substring(1),toSkip);
        }
    }
    static String skipSubStringNotString(String unprocessed,String toSkip, String notToSkip){
        if(unprocessed.isEmpty()){
            return "";
        }
        if(unprocessed.startsWith(notToSkip) && !unprocessed.startsWith(toSkip)){
            return skipSubStringNotString(unprocessed.substring(notToSkip.length()),toSkip,notToSkip);
        } else {
            return unprocessed.charAt(0) + skipSubStringNotString(unprocessed.substring(1),toSkip,notToSkip);
        }
    }

}

