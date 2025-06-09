public class Board {
    private final int size;
    private final char[][] board;
    private final char EMPTY = '-';

    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public boolean placeSymbol(int row, int col, char symbol) {
        if (row >= size || col >= size || col < 0 || row < 0) {
            return false;
        }
        if (board[row][col] != EMPTY) return false;
        board[row][col] = symbol;
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == EMPTY) return false;
            }
        }
        return true;
    }

    public boolean checkWin(char symbol) {
        // Rows
        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        // Cols
        for (int j = 0; j < size; j++) {
            boolean win = true;
            for (int i = 0; i < size; i++) {
                if (board[i][j] != symbol) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        // Diagonal
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Anti-Diagonal
        win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] != symbol) {
                win = false;
                break;
            }
        }
        return win;
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
