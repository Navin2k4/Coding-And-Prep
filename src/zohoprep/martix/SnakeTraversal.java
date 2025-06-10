package zohoprep.martix;

import java.util.ArrayList;

public class SnakeTraversal {
    static int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 },
            { 10, 11, 12 }
    };

    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println(res);
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                // Left to right
                for (int j = 0; j < cols; j++) {
                    res.add(matrix[i][j]);
                }
            } else {
                // Right to left
                for (int j = cols - 1; j >= 0; j--) {
                    res.add(matrix[i][j]);
                }
            }
        }

        System.out.println(res);
    }
}
