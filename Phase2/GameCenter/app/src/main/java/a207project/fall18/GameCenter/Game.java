package a207project.fall18.GameCenter;

import android.support.annotation.IntDef;
import android.util.Log;

/**
 * The tic tac toe game.
 */
 class Game {

    /**
     * int of X = -1
     */
    static final int X = -1;
    /**
     * int O = 1
     */
    static final int O = 1;
    /**
     * int Empty = 0
     */
    static final int EMPTY = 0;

    @IntDef({X, O, EMPTY})
    @interface FieldValue {
    }

    /**
     * A TTTBoard.
     */
    private TTTBoard board;
    /**
     * A TTTScore board.
     */
    private TTTScore scoreBoard;
    /**
     * set won = false
     */
    boolean won = false;
    /**
     * set a random computer player.
     */
    private RandomPlayer computer;


    /**
     * A game which takes the dimension of the board and scoreboard.
     * @param dim dim of the board
     */
    Game(int dim) {
        this.board = new TTTBoard(dim);
        this.scoreBoard = new TTTScore(dim);
    }

    /**
     * Get the board.
     * @return a board
     */
    public TTTBoard getBoard() {
        return board;
    }

    /**
     * Update win or not, If not win, check move.
     * @param fieldIdx Index of the Tile.
     * @param player The Player.
     * @return Move or not.
     */
    boolean Move(int fieldIdx, @FieldValue int player) {

        if (board.move(fieldIdx, player)) {
            won = scoreBoard.Update(fieldIdx, player);
            Log.d("field", "idx: " + fieldIdx + " val: " + player);
            Log.d("field", "score: " + scoreBoard.GetScore());

            return true;
        }

        return false;
    }

    /**
     * Get an available move.
     * @param fieldValue Index of the Tile.
     * @return the index of move.
     */
    int GetMove(@FieldValue int fieldValue)
    {
        return computer.GetMove(fieldValue);
    }


    /**
     * Switch computer move.
     * @param computer computer player.
     */
    void SwitchAI(RandomPlayer computer) {
        RandomPlayer.game = this;
        this.computer = computer;
    }
}