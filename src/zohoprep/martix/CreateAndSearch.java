package zohoprep.martix;

class CreateAndSearch {
    public static void main(String[] args) {
        String word = "WELCOMETOZOHOCORPORATION";
        char[][] grid = new char[5][5];
        String toFind = "TIO";
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (index == word.length()) {
                    grid[i][j] = ' ';
                } else {
                    grid[i][j] = word.charAt(index++);
                }
            }
        }
        for (char[] row : grid) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }

        int rows = grid.length;
        int cols = grid[0].length;

        // Traverse horizantal left to right
        for (int currentRow = 0; currentRow < rows; currentRow++) {
            String rowString = new String(grid[currentRow]);
            if (rowString.contains(toFind)) {
                int startCol = rowString.indexOf(toFind);
                int endCol = startCol + toFind.length() - 1;
                System.out.println("Start index : <" + currentRow + "," + startCol + ">");
                System.out.println("End index   : <" + currentRow + "," + endCol + ">");
            }
        }
        // Traverse vertically top to bottom
        for (int currentCol = 0; currentCol < cols; currentCol++) {
            StringBuilder colString = new StringBuilder();
            for (int currentRow = 0; currentRow < rows; currentRow++) {
                colString.append(grid[currentRow][currentCol]);
            }
            String colStr = colString.toString();
            if (colStr.contains(toFind)) {
                int startRow = colStr.indexOf(toFind);
                int endRow = startRow + toFind.length() - 1;
                System.out.println("Start index : <" + startRow + "," + currentCol + ">");
                System.out.println("End index   : <" + endRow + "," + currentCol + ">");
            }
        }
    }

}
