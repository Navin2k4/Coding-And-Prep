package StackAndQueues.NGEandNSE;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] arr = { 4, 12, 1, 3, 5, 2, 3 };
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            System.out.println(stack);
            while (!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }

        System.out.println(Arrays.toString(pse));
    }

}
