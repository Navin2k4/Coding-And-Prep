package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertSubInterval {
    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 1, 3 }, { 6, 9 } };
        int[] newInterval = new int[] { 2, 5 };
        int[][] ans = insert(intervals, newInterval);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    static int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        boolean inserted = false;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Case 1: Current interval ends before newInterval starts (no overlap)
            if (end < newStart) {
                ans.add(new int[] { start, end });
            }
            // Case 2: Current interval starts after newInterval ends (no overlap)
            else if (start > newEnd) {
                if (!inserted) {
                    ans.add(new int[] { newStart, newEnd }); // insert the merged interval once
                    inserted = true;
                }
                ans.add(new int[] { start, end });
            }
            // Case 3: Overlapping intervals, merge them
            else {
                newStart = Math.min(newStart, start);
                newEnd = Math.max(newEnd, end);
            }
        }

        // If newInterval is after all intervals and never added
        if (!inserted) {
            ans.add(new int[] { newStart, newEnd });
        }

        return ans.toArray(new int[ans.size()][]);
    }

}
