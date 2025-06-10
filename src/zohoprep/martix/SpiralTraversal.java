package zohoprep.martix;

import java.util.ArrayList;

public class SpiralTraversal {
    static int[][] mat = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 },
            { 17, 18, 19, 20 }
    };

    public static void main(String[] args) {
        // Right -> Bottom -> Left -> Top
        int n = mat.length;
        int m = mat[0].length;
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        ArrayList<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {
            // Right
            for (int i = left; i <= right; i++) {
                ans.add(mat[top][i]);
            }
            top++;
            // Bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(mat[i][right]);
            }
            right--;
            // Left
            if(top <= bottom){
                for (int i = right; i >= left; i--) {
                    ans.add(mat[bottom][i]);
                }
                bottom--;
            }
            // Top
            if(left <= right){

                for (int i = bottom; i >= top; i--) {
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }
        System.out.println(ans);
    }

}
