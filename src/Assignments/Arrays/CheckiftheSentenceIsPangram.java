package Assignments.Arrays;

// LC 1832

public class CheckiftheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        boolean[] appeared = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            int index = c - 'a';
            appeared[index] = true;
        }
        for (boolean hasAppeared : appeared) {
            if (!hasAppeared) {
                return false;
            }
        }
        return true;
    }
    
    // public boolean checkIfPangram(String sentence) {
    //     for (char i = 'a'; i <= 'z'; i++) {
    //         if (sentence.indexOf(i) == -1) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
