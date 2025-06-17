package zohoprep;

public class CelebrityProblem {
    public static void main(String[] args) {
        int mat[][] = new int[][] {
                { 1, 1, 0 },
                { 0, 1, 0 },
                { 0, 1, 1 } };
        System.out.println(celebrity(mat));

    }

    static int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int[] knowMe = new int[n];
        int[] iknow = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && mat[i][j] == 1) {
                    knowMe[j]++;
                    iknow[i]++;
                }
            }
        }
        // System.out.println(Arrays.toString(knowMe));
        // System.out.println(Arrays.toString(iknow));
        for (int i = 0; i < n; i++) {
            if (knowMe[i] == n - 1 && iknow[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
