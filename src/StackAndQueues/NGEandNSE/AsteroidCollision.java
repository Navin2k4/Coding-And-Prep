package StackAndQueues.NGEandNSE;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * We are given an array asteroids of integers representing asteroids in a row. 
 * The indices of the asteriod in the array represent their relative position in space.
 * For each asteroid, the absolute value represents its size, and the sign represents its 
 * direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. 
 * If two asteroids meet, the smaller one will explode. 
 * If both are the same size, both will explode. 
 * Two asteroids moving in the same direction will never meet.
 */

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = { 10, 2, -5 };
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean isDestroyed = false;
            // asteroid is moving left and the existing astering is moving right
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop(); // top explodes
                } else if (stack.peek() == -asteroid) {
                    // both explodes
                    stack.pop();
                    isDestroyed = true;
                    break;
                } else {
                    // incoming is smaller
                    isDestroyed = true;
                    break;
                }
            }

            if (!isDestroyed) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
