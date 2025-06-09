package zohoprep.martix;

import java.util.ArrayList;
import java.util.List;

public class WordSearchMatrixIndexLexicalOrder {
    public static void main(String[] args) {
        char[][] grid = { { 'a', 'b', 'c' }, { 'd', 'r', 'f' }, { 'g', 'h', 'i' } };
        String word = "abc";
        System.out.println(searchWord(grid, word));

    }

    // 8 directions: up-left, up, up-right, left, right, down-left, down, down-right
    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    static int[][] searchWord(char[][] grid, String word) {
        int n = grid.length;
        int m = grid[0].length;
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == word.charAt(0) && exists(grid, word, i, j, n, m)) {
                    result.add(new int[] { i, j });
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    static boolean exists(char[][] grid, String word, int x, int y, int n, int m) {
        int len = word.length();

        for (int dir = 0; dir < 8; dir++) {
            int newX = x, newY = y;
            int k;

            for (k = 0; k < len; k++) {
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY] != word.charAt(k)) {
                    break;
                }
                newX += dx[dir];
                newY += dy[dir];
            }

            if (k == len)
                return true;
        }

        return false;
    }

}
