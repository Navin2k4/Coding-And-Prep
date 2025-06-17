package zohoprep;

public class CollectMaximumScoreFromTopLeftToBottomDown {

    public static void main(String[] args) {
        Integer[][] grid1 = {
                { 5, 3, null },
                { null, 2, 1 },
                { 4, null, 1 }
        };
        int rows = grid1.length;
        int cols = grid1[0].length;

        int result = maxSum(grid1, rows - 1, cols - 1);
        System.out.println(result == Integer.MIN_VALUE ? "No valid path" : result);
    }

    static int maxSum(Integer[][] grid, int row, int col) {
        // Out of bounds
        if (row < 0 || col < 0)
            return Integer.MIN_VALUE;

        // Blocked cell
        if (grid[row][col] == null)
            return Integer.MIN_VALUE;

        // Start cell
        if (row == 0 && col == 0)
            return grid[row][col];

        int up = maxSum(grid, row - 1, col);
        int left = maxSum(grid, row, col - 1);

        int maxPrev = Math.max(up, left);

        if (maxPrev == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return grid[row][col] + maxPrev;
    }
}
