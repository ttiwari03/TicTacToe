/*
 Board class to represent game board.
 */
public class Board {
    private final int BOARD_SIZE = 3;
    private final char EMPTY_BOARD_CHAR = '-';
    private final char[][] board;
    
    public Board() {
        this.board = new char[BOARD_SIZE][BOARD_SIZE];
        initializeBoard();
    }

    /*
        Initialize board with empty character "-" .
     */
    private void initializeBoard() {
        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                this.board[r][c] = EMPTY_BOARD_CHAR;
            }
        }
    }

    /*
        Mark player given position with their symbol.
     */
    public void markPosition(int row, int column, char playerSymbol) {
        this.board[row][column] = playerSymbol;
    }

    /*
        Check if player entered position is valid and available, throw exception otherwise.
     */
    public boolean isPositionValid(int row, int column) {
        if (row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE
                && this.board[row][column] == EMPTY_BOARD_CHAR) {
                return true;
        }
        throw new RuntimeException("Invalid position");
    }

    /*
       Check if board is full. (In case game drawn)
     */
    public boolean isBoardFull() {
        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                if (this.board[r][c] == EMPTY_BOARD_CHAR) {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getBoard() {
        return this.board;
    }

    /*
        Show current status of board to players.
     */
    public void showBoard() {
        String space = "  ";
        char bar = '|';
        String separator = space + bar + space;
        String horizontalLine = space + "-".repeat(19);

        System.out.println(horizontalLine);
        for (int r = 0; r < BOARD_SIZE; r++) {
            System.out.print(separator);
            for (int c = 0; c < BOARD_SIZE; c++) {
                System.out.print(this.board[r][c] + separator);
            }
            System.out.println();
        }
        System.out.println(horizontalLine);
    }
}