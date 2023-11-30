/*
    Class to represent a player in the game.
 */
public class Player {
    private final char symbol;
    private final Board board;

    Player(char symbol, Board board) {
        this.symbol = symbol;
        this.board = board;
    }

    public char getSymbol() {
        return this.symbol;
    }

    /*
        Check if a player has won the game.
        For winning game player need their symbol in either same row / column / diagonal.
     */
    public boolean hasPlayerWon() {
        char[][] board = this.board.getBoard();
        return hasSameRow(board) || hasSameColumn(board) 
            || hasSameDiagonal(board) || hasOppositeDiagonal(board);
    }

    private boolean hasSameDiagonal(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != symbol) {
               return false; 
            }
        }
        return true;
    }

    private boolean hasOppositeDiagonal(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            if (board[i][size - 1 - i] != symbol) {
               return false; 
            }
        }
        return true;
    }

    private boolean hasSameColumn(char[][] board) {
        int size = board.length;
        for (int c = 0; c < size; c++) {
            boolean isSameColumn = true;
            for (int r = 0; r < size; r++) {
                if (board[r][c] != symbol) {
                    isSameColumn = false;
                    break;
                }
            }
            if (isSameColumn) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSameRow(char[][] board) {
        int size = board.length;
        for (int r = 0; r < size; r++) {
            boolean isSameRow = true; 
            for (int c = 0; c < size; c++) {
                if (board[r][c] != symbol) {
                    isSameRow = false;
                    break;
                }
            }
            if (isSameRow) {
                return true;
            }
        }
        return false;
    }
}