package StackAndQueues.Implementations;

import java.util.Stack;

public class MinStack {
    private Stack<Long> stack;
    private long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push((long) val);
            min = val;
        } else if (val >= min) {
            stack.push((long) val);
        } else {
            // Store encoded value
            stack.push(2L * val - min);
            min = val;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long top = stack.pop();
        if (top < min) {
            // Recover previous min
            min = 2 * min - top;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top >= min) {
            return (int) top;
        } else {
            // Encoded value, actual top is min
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(10);
        ms.push(5);
        ms.push(2);
        System.out.println("Min: " + ms.getMin()); // 2
        ms.pop(); // removes 2
        System.out.println("Top: " + ms.top());    // 5
        System.out.println("Min: " + ms.getMin()); // 5
        ms.pop(); // removes 5
        System.out.println("Min: " + ms.getMin()); // 10
    }
}
