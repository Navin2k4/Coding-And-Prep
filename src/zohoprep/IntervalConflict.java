package zohoprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalConflict {
    public static void main(String[] args) {
        int[][] intervals1 = new int[][] { { 1, 3 }, { 5, 7 }, { 8, 12 } };
        int[] newInterval1 = new int[] { 4, 6 }; // Should be Conflict
        printResult(insertOrConflict(intervals1, newInterval1));

        int[][] intervals2 = new int[][] { { 1, 3 }, { 5, 7 }, { 8, 12 } };
        int[] newInterval2 = new int[] { 3, 5 }; // Should be merged
        printResult(insertOrConflict(intervals2, newInterval2));
    }

    static void printResult(Object result) {
        if (result instanceof String) {
            System.out.println(result);
        } else {
            int[][] ans = (int[][]) result;
            for (int[] row : ans) {
                System.out.println(Arrays.toString(row));
            }
        }
        System.out.println("-----");
    }

    static Object insertOrConflict(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        boolean inserted = false;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Conflict detected if overlap exists
            if (start < newEnd && newStart < end) {
                return "Conflict";
            }

            // No overlap, new interval comes before current
            if (!inserted && newEnd < start) {
                ans.add(new int[] { newStart, newEnd });
                inserted = true;
            }

            ans.add(new int[] { start, end });
        }

        // If new interval is after all existing intervals
        if (!inserted) {
            ans.add(new int[] { newStart, newEnd });
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
