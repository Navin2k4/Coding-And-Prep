package StackAndQueues.Conceptual;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = { 4, 2, 0, 3, 2, 5 };
        // System.out.println(trapTwoPointerApproach(height));
        // System.out.println(trapPrefixSuffix(height));
        // System.out.println(trapSuffix(height));
        System.out.println(trapStack(height));
    }

    static int trapTwoPointerApproach(int[] height) {
        int leftMax = 0, rightMax = 0, total = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                if (leftMax > height[l]) {
                    total += leftMax - height[l];
                } else {
                    leftMax = height[l];
                }
                l++;
            } else {
                if (rightMax > height[r]) {
                    total += rightMax - height[r];
                } else {
                    rightMax = height[r];
                }
                r--;
            }
        }
        return total;
    }

    // Prefix and Suffix Max Method
    static int trapPrefixSuffix(int[] height) {
        int total = 0;
        int n = height.length;

        int[] prefixMax = new int[n];
        prefixMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
        }

        int[] suffixMax = new int[n];
        suffixMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }

        // We know that the eater is going to stay only if the current
        // ith building right has a high value ans left has a high value
        // how much water th building contains is min(leftMax, rightMax) minus the
        // height of the current building
        // also the leftmax > ith and rightMax < ith;
        for (int i = 0; i < n; i++) {
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];
            if (height[i] < leftMax && height[i] < rightMax) {
                total += Math.min(leftMax, rightMax) - height[i];
            }
        }

        return total;
    }

    // Remove extra space for the prefix remeber the left max while traversing
    static int trapSuffix(int[] height) {
        int total = 0;
        int n = height.length;
        int leftMax = Integer.MIN_VALUE;

        int[] suffixMax = new int[n];
        suffixMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            int rightMax = suffixMax[i];
            if (height[i] < leftMax && height[i] < rightMax) {
                total += Math.min(leftMax, rightMax) - height[i];
            }
        }

        return total;
    }

    // Stack-based approach (uses indices)
    static int trapStack(int[] height) {
        int totalWater = 0;
        Stack<Integer> stack = new Stack<>();
        int n = height.length;

        for (int current = 0; current < n; current++) {
            System.out.println(stack);
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int bottom = stack.pop();

                if (stack.isEmpty())
                    break;

                int left = stack.peek();
                int width = current - left - 1;
                int boundedHeight = Math.min(height[left], height[current]) - height[bottom];
                // System.out.println("Left : " + left + " Width : " + width + " BoundedHeight :
                // " + boundedHeight);
                if (boundedHeight > 0) {
                    totalWater += width * boundedHeight;
                }
            }
            stack.push(current);
        }

        return totalWater;
    }

}
