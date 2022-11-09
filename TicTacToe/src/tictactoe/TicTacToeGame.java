package tictactoe;

import java.awt.Point;
/**
 * 
 * @authors Luca Bova, Chad Long
 *
 */
public class TicTacToeGame implements TicTacToe {
// All main parameters established
    private BoardChoice [][] board;
    private GameState state;
    private BoardChoice last_move;
    private int move_count;
    private Point[] moves;

    public TicTacToeGame() {
        newGame();
    }
/**
 * newGame clears the board if its occupied with anything, then has the player begin by placing something. It build the board of 3x3 and sets the board choices to open
 * 
 */
    public void newGame() {
        board = new BoardChoice[3][3];
        for(int i=0; i < 3; i++) {
            for(int j=0; j < 3; j++) {
                board[i][j] = BoardChoice.OPEN;
            }
        }
        state = GameState.IN_PROGRESS;
        last_move = BoardChoice.OPEN;
        move_count = 0;
        moves = new Point[9];
    }
/**
*Choose allows you to select a tile and checks if something is on it. It checks to see if it is whithin the grid and if it is a legal move to make, and if so it places.
*It then increases move count and checks to see if the game is over.
*/
    
    public boolean choose(BoardChoice player, int row, int col) {
        if (state != GameState.IN_PROGRESS) return false;
        if (player == BoardChoice.OPEN) return false;
        if (player == last_move) return false;
        if ((row < 0) || (row > 2) || (col < 0) || (col > 2)) return false;
        if (board[row][col] != BoardChoice.OPEN) return false;
        board[row][col] = player;
        last_move = player;
        moves[move_count] = new Point(row, col);
        move_count++;
        gameOver();
        return true;
    }
//Checks the board choice to see if its usable.
    private BoardChoice tester(int r, int c, int dr, int dc) {
        // board[r,c], board[r+dr,c+dc], board[r+2*dr,c+2*dc] are
        // three board cells in a row - horiz, vert, or diag
        if (board[r][c] == BoardChoice.OPEN) return BoardChoice.OPEN;
        if ((board[r][c] == board[r+dr][c+dc]) &&
            (board[r][c] == board[r+2*dr][c+2*dc])) {
            state = (board[r][c] == BoardChoice.X) ? GameState.X_WON : GameState.O_WON;
            return board[r][c];
        }
        return BoardChoice.OPEN;
    }
/**
*this checks to see if the game is over by checking if either 3 Xs or Os are in a row OR the movecount for the game has reached the maximum it can reach.
*it does this by systematically checking every single tile and possible win permutation every time its called.
*/
    public boolean gameOver() {
        if (state != GameState.IN_PROGRESS) return true;
        // top row
        if (tester(0, 0, 0, 1) != BoardChoice.OPEN) return true;
        // middle row
        if (tester(1, 0, 0, 1) != BoardChoice.OPEN) return true;
        // bottom row
        if (tester(2, 0, 0, 1) != BoardChoice.OPEN) return true;
        // left column
        if (tester(0, 0, 1, 0) != BoardChoice.OPEN) return true;
        // middle column
        if (tester(0, 1, 1, 0) != BoardChoice.OPEN) return true;
        // right column
        if (tester(0, 2, 1, 0) != BoardChoice.OPEN) return true;
        // main diagonal
        if (tester(0, 0, 1, 1) != BoardChoice.OPEN) return true;
        // reverse diagonal
        if (tester(2, 0, -1, 1) != BoardChoice.OPEN) return true;

        if (move_count == 9) {
            state = GameState.TIE;
            return true;
        }
        return false;
    }

//gets the current gamestate, whether in progress, beggining, or over.
    public GameState getGameState() {
    	return state;
    }
//generates gamegrid.
    public BoardChoice[][] getGameGrid() {
    	BoardChoice [][] copyBoard = new BoardChoice[3][3];
    	for(int i=0; i < 3; i++) {
           for(int j=0; j < 3; j++) {
               copyBoard[i][j] = board[i][j];
           }
       }
    	return copyBoard;
    }
//gets the movecount and game moves
    public Point[] getMoves() {
        Point[] copyMoves = new Point[move_count];
        for(int i=0; i < move_count; i++) {
            copyMoves[i] = moves[i];
        }
       return copyMoves;
    }

}
