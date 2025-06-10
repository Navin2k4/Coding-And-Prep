package zohoprep.martix;
import java.util.*;
public class SearchIn2DArray {
    static int[][] matrix = {
            { 1, 3, 5, 7 },
            { 10, 11, 16, 20 },
            { 23, 30, 34, 60 }
    };

    static int[][] matrix2 = {
            { 1, 2, 3, 4, 5 },
            { 6, 7, 8, 9, 10 },
            { 11, 12, 13, 14, 15 },
            { 16, 17, 18, 19, 20 },
            { 21, 22, 23, 24, 25 }
    };

    static int n = matrix.length;
    static int m = matrix[0].length;

    public static void main(String[] args) {
        // 1. We can make the matrix traversal normally -> O(mn)
        // 2. Find the row where the number lies using the bounds and then binary search
        // it -> O(n*logm);
        // ! 3. Flatten the matrix find the number -> O(lognm) but cant do it flatten
        // itself takes them
        // ! Converting the 1d into 2d ->
        // ! index 5 -> index / m(number of columns) -> row
        // ! index 5 -> index % m(number of columns) -> col
        System.out.println(searchMatrix(matrix, 20));
        System.out.println(Arrays.toString(searchMatrixTwo(matrix2, 20)));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = n * m - 1;
        while (low <= high) {
            int mid = (low) + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    // Colwise increasing downwards
    // Rowise increasing right side
    static int[] searchMatrixTwo(int[][] matrix2, int target) {
        int n = matrix2.length;
        int m = matrix2[0].length;
        int row = 0;
        int col = m - 1;

        while (row < n || col >= 0) {
            if (matrix2[row][col] == target) {
                return new int[]{row,col};
            } else if (matrix2[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }

        return new int[]{row,col};
    }
}
