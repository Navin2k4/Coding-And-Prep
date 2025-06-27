package StackAndQueues.NGEandNSE;

import java.util.*;

public class NextSmallerElement {
    public static void main(String[] args) {
        int arr[] = { 4, 8, 5, 2, 25 };
        System.out.println(Arrays.toString(nextSmallerElementsStack(arr)));
    }

    static int[] nextSmallerElementsStack(int[] arr) {
        int nse[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            while (!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(num);
        }

        return nse;
    }
}
