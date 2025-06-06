package StackAndQueues;

class MyStack {
    private int top;
    private int[] st;
    private final int MAX_SIZE = 10;
    public MyStack() {
        top = -1;
        st = new int[MAX_SIZE];
    }
    public void push(int x) {
        if (top >= MAX_SIZE - 1) {
            System.out.println("Stack Overflow: Size exceeds " + MAX_SIZE);
            return;
        }
        st[++top] = x;
    }

    public int getTop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return st[top];
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: No values to pop");
            return -1;
        }
        return st[top--];
    }

    public int getSize() {
        return top + 1; // Fix: Returning the actual size of the stack
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MAX_SIZE - 1;
    }
}

public class StackImplement {
    public static void main(String[] args) {

    }
}

