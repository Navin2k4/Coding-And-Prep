package zohoprep.martix;

public class UpperOrLowerTriangle {
    public static void main(String[] args) {
        int mat[][] = {
                { 1, 1, 1 },
                { 0, 1, 1 },
                { 0, 0, 1 }
        };
        System.out.println(checkType(mat));
    }

    static String checkType(int[][] martix) {
        int n = martix.length;
        boolean isUpper = true;
        boolean isLower = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j && martix[i][j] != 0)
                    isUpper = false;
                if (i < j && martix[i][j] != 0)
                    isLower = false;
            }
        }

        if (isUpper)
            return "Upper Triangular";
        if (isLower)
            return "Lower Triangular";
        return "None";
    }
}
