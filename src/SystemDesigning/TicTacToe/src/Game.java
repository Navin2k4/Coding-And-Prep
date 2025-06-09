import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game(String p1Name, String p2Name) {
        this.board = new Board(3);
        this.player1 = new Player(p1Name, 'X');
        this.player2 = new Player(p2Name, 'O');
        this.currentPlayer = player1;
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + "), enter your move (row and col): ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (!board.placeSymbol(row, col, currentPlayer.getSymbol())) {
                System.out.println("Invalid Move Try again");
                continue;
            }
            if (board.checkWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }
}
