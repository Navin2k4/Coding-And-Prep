package zohoprep.patterns;

import java.util.ArrayList;

public class SnakePattern {
    public static void main(String[] args) {

    }

    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    res.add(matrix[i][j]);
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}
