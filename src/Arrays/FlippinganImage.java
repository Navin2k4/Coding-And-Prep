package Arrays;

public class FlippinganImage {
    // Excess storage
    public int[][] flipAndInvertImage(int[][] image) {
        int row = image.length;
        int col = image[0].length;
        int reversed[][] = new int[row][col];
        int inverted[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                reversed[i][j] = image[i][col - j - 1];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                inverted[i][j] = reversed[i][j] ^ 1;
            }
        }
        return inverted;
    }

    // Inplace
    public int[][] flipAndInvertImage2(int[][] image) {
        int row = image.length;
        int col = image[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = image[i][j] ^ 1;
                image[i][j] = image[i][col - j - 1] ^ 1;
                image[i][col - j - 1] = temp;
            }
            if (col % 2 == 1)
                image[i][col / 2] ^= 1;
        }
        return image;
    }
}
