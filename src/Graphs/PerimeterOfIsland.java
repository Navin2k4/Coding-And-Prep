package Graphs;

public class PerimeterOfIsland {
    public static void main(String[] args) {
        int grid[][] = {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 0 },
        };
        System.out.println(islandPerimeter(grid));
    }

    static int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;

                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }

    static int dfsHelper(int[][] grid, int row, int col) {
        // Out of bound -> Perimeter included
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return 1;
        }
        // water case
        if (grid[row][col] == 1) {
            return 1;
        }
        // visited case
        if (grid[row][col] == -1) {
            return 0;
        }
        grid[row][col] = -1; // visit the column
        // try to move all the four directions
        int perimeter = 0;
        perimeter += dfsHelper(grid, row - 1, col); // up
        perimeter += dfsHelper(grid, row + 1, col); // down
        perimeter += dfsHelper(grid, row, col - 1); // left
        perimeter += dfsHelper(grid, row, col + 1); // right

        return perimeter;

    }
}
