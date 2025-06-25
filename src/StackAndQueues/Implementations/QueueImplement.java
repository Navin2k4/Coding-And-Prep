package StackAndQueues.Implementations;

class MyQueue {
    private int front, rear;
    private int[] queue;
    private final int MAX_SIZE = 10;
    private int currentSize;

    public MyQueue() {
        front = 0;
        rear = -1;
        currentSize = 0;
        queue = new int[MAX_SIZE];
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Queue Overflow: Cannot add more elements");
            return;
        }
        rear = (rear + 1) % MAX_SIZE;
        queue[rear] = x;
        currentSize++;
    }

    public int getTop() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: No elements to pop");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % MAX_SIZE;
        currentSize--;
        return item;
    }

    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == MAX_SIZE;
    }
}


public class QueueImplement {
    public static void main(String[] args) {
        
    }
}
