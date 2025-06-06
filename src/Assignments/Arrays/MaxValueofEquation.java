package Assignments.Arrays;

public class MaxValueofEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (checkFirstConstraint(points[i][0], points[j][0], k)) {
                    int equationValue = points[i][1] + points[j][1] + absDiff(points[i][0], points[j][0]);
                    if (max < equationValue) {
                        max = equationValue;
                    }
                }
            }
        }
        return max;
    }

    static boolean checkFirstConstraint(int a, int b, int k) {
        if (absDiff(a, b) <= k) {
            return true;
        }
        return false;
    }

    static int absDiff(int num1, int num2) {
        if (num1 > num2) {
            return num1 - num2;
        } else {
            return num2 - num1;
        }
    }
    // Time limit exceeding
}
