package zohoprep.strings;
import java.util.Stack;

public class ValidParanthesisWithRegex {
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(]";
        // System.out.println(isValid(s1));
        // System.out.println(isValid(s2));
        String s3 = "(*))";
        String s4 = "((*)";
        String s5 = "(((*)";
        System.out.println(isValidRegex(s3));
        System.out.println(isValidRegex(s4));
        System.out.println(isValidRegex(s5));
    }

    static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty())
                    return false;
                char check = st.pop();
                if ((ch == ')') && (check != '(') ||
                        (ch == '}') && (check != '{') ||
                        (ch == ']') && (check != '[')) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    static boolean isValidRegex(String s) {
        return backtrack(s, 0, 0);
    }

    static boolean backtrack(String s, int index, int balance) {
        if (balance < 0)
            return false; // More ')' than '(' — invalid

        if (index == s.length()) {
            return balance == 0;
        }

        char ch = s.charAt(index);

        if (ch == '(') {
            return backtrack(s, index + 1, balance + 1);
        } else if (ch == ')') {
            return backtrack(s, index + 1, balance - 1);
        } else if (ch == '*') {
            // Try all 3 choices: empty, '(', or ')'
            return backtrack(s, index + 1, balance) || // skip '*'
                    backtrack(s, index + 1, balance + 1) || // treat '*' as '('
                    backtrack(s, index + 1, balance - 1); // treat '*' as ')'
        } else {
            // Invalid char for this scope
            return backtrack(s, index + 1, balance); // or return false if strict
        }
    }

}
