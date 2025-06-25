package StackAndQueues.ExpressionEvaluation;

import java.util.Stack;

public class PostFixToInfixAndPrefix {

    static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    public static void main(String[] args) {
        String expression = "abcd^e-*+";
        System.out.println("Postfix: " + expression);
        System.out.println("Infix: " + convertpostfixToInfix(expression));
        System.out.println("Prefix: " + convertpostfixToPrefix(expression));
        /*
         * Postfix: abcd^e-*+
         * Infix: (a+(b*((c^d)-e)))
         * Prefix: +a*b-^cde
         */
    }

    static String convertpostfixToInfix(String expression) {
        Stack<String> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (isOperand(ch)) {
                stack.push(String.valueOf(ch)); // Push operand as String;
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String expr = "(" + operand1 + ch + operand2 + ")";
                stack.push(expr);
            }
        }
        return stack.pop();
        // Implemented using String but using Strig Builder is more effecient for larger
        // strings
    }

    static String convertpostfixToPrefix(String expression) {
        Stack<String> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (isOperand(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String firstTop = stack.pop();
                String secondTop = stack.pop();
                String expr = ch + secondTop + firstTop;
                stack.push(expr);
            }
        }
        return stack.pop();
    }
}
