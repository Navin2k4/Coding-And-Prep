package zohoprep;

import java.util.HashSet;
import java.util.Set;

public class TwoDMatrixWithoutDuplicate {
    public static void main(String[] args) {
        int mat[][] = {
                { 1, 0, 1 },
                { 1, 1, 0 },
                { 1, 1, 1 },
                { 1, 0, 1 }
        };
        printUniqueRows(mat);
    }

    static void printUniqueRows(int[][] matrix) {
        Set<String> seen = new HashSet<>();
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            for (int num : row) {
                sb.append(num);
            }
            String rowString = sb.toString();
            if (!seen.contains(rowString)) {
                seen.add(rowString);
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}
