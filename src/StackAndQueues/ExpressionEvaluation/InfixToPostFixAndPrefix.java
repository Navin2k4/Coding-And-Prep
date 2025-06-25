package StackAndQueues.ExpressionEvaluation;

import java.util.Stack;

public class InfixToPostFixAndPrefix {

    static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    static boolean isOperator(char ch) {
        return "+-*/%^".indexOf(ch) != -1;
    }

    static int precedence(char ch) {
        switch (ch) {
            case '^':
                return 3;
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String expression = "a+b*(c^d-e)";
        System.out.println("Infix: " + expression);
        System.out.println("Postfix: " + convertinfixToPostfix(expression));
        System.out.println("Prefix: " + convertinfixToPrefix(expression));
        /*
         * Infix: a+b*(c^d-e)
         * Postfix: abcd^e-*+
         * Prefix: +a*b-^cde
         */
    }

    static String convertinfixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (isOperand(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                // Pop until opening parenthesis
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Discard '('
                }
            } else if (isOperator(ch)) {
                // Pop while the precedence of the current operator is <= top of the stack
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    static String convertinfixToPrefix(String expression) {
        StringBuilder prefix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        StringBuilder reversed = new StringBuilder();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                reversed.append(')');
            } else if (ch == ')') {
                reversed.append('(');
            } else {
                reversed.append(ch);
            }
        }

        for (char ch : reversed.toString().toCharArray()) {
            if (isOperand(ch)) {
                prefix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    prefix.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (isOperator(ch)) {
                if (ch == '^') {
                    while (!stack.isEmpty() && precedence(ch) < precedence(stack.peek())) {
                        prefix.append(stack.pop());
                    }
                } else {
                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                        prefix.append(stack.pop());
                    }
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        return prefix.reverse().toString();
    }

}
