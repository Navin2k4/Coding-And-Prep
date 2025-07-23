import java.util.Stack;

public class MaxGain {
    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        System.out.println(maximumGain(s, x, y));
    }

    static int maximumGain(String s, int x, int y) {
        // since mazimizing them i might need to pic the greatest of x and y
        // it can be either ab->x or ba->y
        int maxPoints = 0;
        String maxPicker = (x > y) ? "ab" : "ba";
        String minPicker = (x > y) ? "ba" : "ab";
        int maxValue = Math.max(x, y);
        int minValue = Math.min(x, y);
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                String pair = "" + top + ch;
                if (pair.equals(maxPicker)) {
                    stack.pop();
                    maxPoints += maxValue;
                    continue;
                }
            }
            stack.push(ch);
        }


        StringBuilder remstring = new StringBuilder();
        while (!stack.isEmpty()) {
            remstring.append(stack.pop());
        }
        remstring.reverse();

        for (char ch : remstring.toString().toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                String pair = "" + top + ch;
                if (pair.equals(minPicker)) {
                    stack.pop();
                    maxPoints += minValue;
                    continue;
                }
            }
            stack.push(ch);
        }

        return maxPoints;
        
    }   
}