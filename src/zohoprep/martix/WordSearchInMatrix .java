package zohoprep.martix;

import java.util.ArrayList;

class WordSearchInMatrix {
    public static void main(String[] args) {
        char[][] matrix = {
                { 'C', 'A', 'T', 'F' },
                { 'B', 'G', 'E', 'S' },
                { 'I', 'T', 'A', 'E' }
        };

        String[] words = { "EX" };
        // String[] words = { "CAT", "TEA", "EAT", "FET", "BAT", "AEE" };

        ArrayList<String> resultSet = new ArrayList<>();

        for (String word : words) {
            isWordPresent(matrix, word, resultSet);
        }

        System.out.println(resultSet);
    }

    static boolean isWordPresent(char[][] matrix, String word, ArrayList<String> resultSet) {
        // Horizantal
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int r = 0; r < rows; r++) {
            String rowStr = new String(matrix[r]);
            resultSet.add(rowStr + "");
            if (rowStr.contains(word))
                return true;
        }
        // Vertical
        for (int c = 0; c < cols; c++) {
            StringBuilder colString = new StringBuilder();
            for (int r = 0; r < rows; r++) {
                colString.append(matrix[r][c]);
                resultSet.add(colString + "");
            }
            if (colString.toString().contains(word))
                return true;
        }
        // Diagonal Topleft to bottom right 0,0 to n,m
        if (searchDiagonals(matrix, word, rows, cols, resultSet))
            return true;

        // Antidiagonal
        if (searchAntiDiagonals(matrix, word, rows, cols, resultSet))
            return true;

        return false;
    }

    static boolean searchDiagonals(char[][] matrix, String word, int rows, int cols, ArrayList<String> resultSet) {
        for (int c = 0; c < cols; c++) {
            StringBuilder diagonalStr = new StringBuilder();
            for (int r = 0, col = c; r < rows && col < cols; r++, col++) {
                diagonalStr.append(matrix[r][col]);
                resultSet.add(diagonalStr + "");

            }
            if (diagonalStr.toString().contains(word))
                return true;
        }
        for (int r = 1; r < rows; r++) {
            StringBuilder diagonalStr = new StringBuilder();
            for (int row = r, c = 0; row < rows && c < cols; row++, c++) {
                diagonalStr.append(matrix[row][c]);
                resultSet.add(diagonalStr + "");
            }
            if (diagonalStr.toString().contains(word))
                return true;
        }

        return false;
    }

    static boolean searchAntiDiagonals(char[][] matrix, String word, int rows, int cols, ArrayList<String> resultSet) {
        for (int c = cols - 1; c >= 0; c--) {
            StringBuilder antiDiagonal = new StringBuilder();
            for (int r = 0, col = c; r < rows && col >= 0; r++, col--) {
                antiDiagonal.append(matrix[r][col]);
                resultSet.add(antiDiagonal + "");

            }
            if (antiDiagonal.toString().contains(word))
                return true;
        }
        for (int r = 1; r < rows; r++) {
            StringBuilder antiDiagonal = new StringBuilder();
            for (int row = r, c = cols - 1; row < rows && c >= 0; row++, c--) {
                antiDiagonal.append(matrix[row][c]);
                resultSet.add(antiDiagonal + "");

            }
            if (antiDiagonal.toString().contains(word))
                return true;
        }
        return false;
    }
}
