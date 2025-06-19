package Graphs;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        int sr = 1, sc = 1, newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color)
            return image;
        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    static void dfs(int[][] image, int row, int col, int originalColor, int newcolor) {
        // boundry checks
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length)
            return;

        if (image[row][col] != originalColor)
            return;

        image[row][col] = newcolor;

        dfs(image, row - 1, col, originalColor, newcolor);
        dfs(image, row + 1, col, originalColor, newcolor);
        dfs(image, row, col - 1, originalColor, newcolor);
        dfs(image, row, col + 1, originalColor, newcolor);
    }
}
