package StackAndQueues.NGEandNSE;

import java.util.*;

class SumOfSubarrayMinimum {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        System.out.println(sumSubarrayMinsBrute(arr));
        System.out.println(PSEandNSEMethod(arr));
    }

    // Bruete Force approach generate all the subarray and find its minimum by keep
    // tracking in each itration?

    // Return the answer modulo 10pow9 + 7.
    static int sumSubarrayMinsBrute(int[] arr) { // -> O(n2)TC -> TLE
        int n = arr.length;
        int totalMinSum = 0;
        int mod = (int) (1e9 + 7);
        for (int start = 0; start < n; start++) {
            int min = arr[start];
            for (int end = start; end < n; end++) {
                min = Math.min(min, arr[end]);
                totalMinSum += min;
            }
        }
        return totalMinSum % mod;
    }

    static int PSEandNSEMethod(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            result = (result + arr[i] * left * right) % mod;
            System.out.println("Contribution of " + arr[i] + " Left : " + left + " Right : " + right + " = " + (arr[i] * left * right));
        }
        System.out.println(Arrays.toString(pse));
        System.out.println(Arrays.toString(nse));
        return (int) result;
    }
}