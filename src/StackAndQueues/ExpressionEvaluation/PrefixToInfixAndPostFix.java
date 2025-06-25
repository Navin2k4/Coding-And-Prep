package StackAndQueues.ExpressionEvaluation;

import java.util.Stack;

public class PrefixToInfixAndPostFix {

    static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    public static void main(String[] args) {
        String expression = "+a*b-^cde";
        System.out.println("Prefix: " + expression);
        System.out.println("Infix: " + convertprefixToInfix(expression));
        System.out.println("PostFix: " + convertprefixToPostFix(expression));
        /*
         * Prefix: +a*b-^cde
         * Infix: (a+(b*((c^d)-e)))
         * PostFix: abcd^e-*+
         */
    }

    static String convertprefixToInfix(String expression) {
        Stack<String> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);

            if (isOperand(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String expr = "(" + operand2 + ch + operand1 + ")";
                stack.push(expr);
            }
        }
        return stack.pop();
    }

    static String convertprefixToPostFix(String expression) {
        Stack<String> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);

            if (isOperand(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String top1 = stack.pop();
                String top2 = stack.pop();
                String expr = top1 + top2 + ch;
                stack.push(expr);
            }
        }

        return stack.pop();
    }
}
