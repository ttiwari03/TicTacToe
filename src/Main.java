import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * This program play game of tic-tac-toe between two players.
 */
public class Main {
    static Scanner readIp = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // Creating game board.
        Board board = new Board();

        // Initialising both players.
        Deque<Player> players = new LinkedList<>();
        Player player1 = new Player('O', board);
        Player player2 = new Player('X', board);
        players.add(player1);
        players.add(player2);
        
        System.out.println("***** Tic Tac Toe *****");
        System.out.println("Player 1 symbol - O \nPlayer 2 symbol - X");

        Player player;
        // Game continue until one player won or game board is full.
        while (true) {
            board.showBoard();
            // Remove first player from queue to play.
            player = players.removeFirst();
            System.out.println("Player with symbol - " + player.getSymbol());
            System.out.println("Please enter row(1-3) and column(1-3) number to place your symbol:- ");
            try {
                // Player enter move as space separated row and column number to place their symbol.
                String[] move = readIp.nextLine().split(" ");
                int row = Integer.parseInt(move[0]) - 1;
                int column = Integer.parseInt(move[1]) - 1;

                // Check is position is valid and available
                if (board.isPositionValid(row, column)) {
                    // Place player symbol at given position.
                    board.markPosition(row, column, player.getSymbol());
                }

                // Check if player with turn has won the game.
                if (player.hasPlayerWon()) {
                    // End game if player won.
                    System.out.println("Player with symbol - " + player.getSymbol() + " has won.\nGame Ended.");
                    break;
                }

                // Check if board is full.
                if (board.isBoardFull()) {
                    // End game if board is full. (if player won is already checked).
                    System.out.println("Game draw. No one won.\nGame Ended.");
                    break;
                }

                // Add current player to the end of queue.
                players.addLast(player);
            } catch (RuntimeException ex) {
                System.out.println("Invalid move. Enter valid row number and column number separated by space.");
                // Add current player to the start of queue, so that it can have its turn again.
                players.addFirst(player);
            }
        }
    }
}
