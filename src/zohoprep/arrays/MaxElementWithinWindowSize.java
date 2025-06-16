package zohoprep.arrays;

import java.util.Deque;
import java.util.LinkedList;

public class MaxElementWithinWindowSize {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 2, 1, 8, 6, 9 };
        int window = 3;
        int n = arr.length;

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // Remove elements out of window
            if (!dq.isEmpty() && dq.peekFirst() <= i - window)
            dq.pollFirst();
            
            // Remove smaller elements from the back
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
            dq.pollLast();
            
            // Add current index
            dq.offerLast(i);
            System.out.println(dq);
            
            // Window is ready: store max (front of deque)
            // if (i >= window - 1)
                // System.out.println(arr[dq.peekFirst()]);
        }

    }
}
