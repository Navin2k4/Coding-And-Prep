package StackAndQueues.NGEandNSE;

import java.util.Arrays;
import java.util.Stack;

public class NGESimple {
    public static void main(String[] args) {
        int[] arr = { 4, 12, 1, 3, 5, 2, 3 };
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }

        System.out.println(Arrays.toString(nge));
    }
}
