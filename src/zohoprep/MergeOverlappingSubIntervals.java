package zohoprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 1, 3 }, { 5, 7 }, { 8, 12 } };
        int[][] intervals2 = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        int[][] ans = mergeOP(intervals2);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            System.out.println("start " + start + " end " + end);

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1)[1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            ans.add(new int[] { start, end });
        }

        return ans.toArray(new int[ans.size()][]);
    }

    static int[][] mergeOP(int[][] intervals) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (ans.isEmpty()) {
                ans.add(new int[] { start, end });
            } else {
                int lastEnd = ans.get(ans.size() - 1)[1];
                if (start <= lastEnd) {
                    // Overlap — merge current into the last interval
                    ans.get(ans.size() - 1)[1] = Math.max(lastEnd, end);
                } else {
                    // No overlap — add as new interval
                    ans.add(new int[] { start, end });
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
