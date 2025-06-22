package zohoprep.strings;

import java.util.Arrays;

public class EvaluateExpression {
    public static void main(String[] args) {
        String input = "12345*+-+";
        System.out.println(evaluate(input));
    }

    public static int evaluate(String str) {
        int n = 0;
        while (n < str.length() && Character.isDigit(str.charAt(n))) {
            n++;
        }
        int nums[] = new int[n];
        char op[] = new char[str.length() - n];
        for (int i = 0; i < n; i++) {
            nums[i] = str.charAt(i) - '0';
        }
        for (int i = n; i < str.length(); i++) {
            op[i - n] = str.charAt(i);
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(op));

        int result = nums[0];
        for (int i = 0; i < op.length; i++) {
            switch (op[i]) {
                case '*':
                    result *= nums[i + 1];
                    break;
                case '+':
                    result += nums[i + 1];
                    break;
                case '-':
                    result -= nums[i + 1];
                    break;
                case '/':
                    result /= nums[i + 1];
                    break;
            }
        }

        return result;

    }

}
