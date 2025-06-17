package DynamicProgramming;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] points = {
                { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 }
        };
        int days = points.length;

        int memDP[][] = new int[days][4];
        for (int i = 0; i < days; i++) {
            Arrays.fill(memDP[i], -1);
        }

        // System.out.println(findMaxPointsMemo(points, days - 1, 3, memDP));

        System.out.println(findMaxPointsOptimized(points, days));

    }

    static int findMaxPointsOptimized(int[][] points, int days) {
        int dp[] = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < points.length; day++) {
            int temp[] = new int[4];
            for (int prevTask = 0; prevTask <= 3; prevTask++) {
                temp[prevTask] = 0;
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != prevTask) {
                        int point = points[day][task] + dp[task];
                        max = Math.max(point, max);
                    }
                }
                temp[prevTask] = max;
            }
            dp = temp;
        }

        return dp[3];
    }

    static int findMaxPointsTab(int[][] points, int days) {
        int dp[][] = new int[points.length][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < points.length; day++) {
            for (int prevTask = 0; prevTask <= 3; prevTask++) {
                dp[day][prevTask] = 0;
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != prevTask) {
                        int point = points[day][task] + dp[day - 1][task];
                        max = Math.max(point, max);
                    }
                }
                dp[day][prevTask] = max;
            }
        }

        return dp[points.length - 1][3];
    }

    static int findMaxPointsMemo(int[][] points, int day, int prevTask, int[][] memDP) {
        if (day == 0) {
            int max = 0;
            for (int task = 0; task <= 2; task++) {
                if (task != prevTask) {
                    max = Math.max(max, points[day][task]);
                }
            }
            return max;
        }

        if (memDP[day][prevTask] != -1)
            return memDP[day][prevTask];

        int max = 0;
        for (int task = 0; task <= 2; task++) {
            if (task != prevTask) {
                int point = points[day][task] + findMaxPointsMemo(points, day - 1, task, memDP);
                max = Math.max(max, point);
            }
        }
        return memDP[day][prevTask] = max;
    }

    static int findMaxPoints(int[][] points, int day, int prevTask) {
        if (day == 0) {
            int max = 0;
            for (int task = 0; task <= 2; task++) {
                if (task != prevTask) {
                    max = Math.max(max, points[day][task]);
                }
            }
            return max;
        }
        int max = 0;
        for (int task = 0; task <= 2; task++) {
            if (task != prevTask) {
                int point = points[day][task] + findMaxPoints(points, day - 1, task);
                max = Math.max(max, point);
            }
        }
        return max;
    }

}
