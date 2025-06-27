package StackAndQueues.NGEandNSE;

import java.util.Arrays;
import java.util.Stack;

class NGETwoCyclic {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        System.out.println(Arrays.toString(nextGreaterElementsStack(arr)));
        System.out.println(Arrays.toString(nextGreaterElementsBrute(arr)));
    }

    static int[] nextGreaterElementsStack(int[] arr) {
        int nge[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i = 2 * n; i >= 0; i--) {
            int num = arr[i % n];
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            if (i < n) {
                nge[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(num);
        }
        return nge;
    }

    static int[] nextGreaterElementsBrute(int[] arr) {
        int nge[] = new int[arr.length];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            nge[i] = -1;
            for (int j = i + 1; j < i + n; j++) {
                int index = j % n;
                if (arr[index] > arr[i]) {
                    nge[i] = arr[index];
                    break;
                }
            }
        }
        return nge;
    }

}