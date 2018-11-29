package a207project.fall18.GameCenter;

import android.support.annotation.IntDef;
import android.util.Log;

/**
 * The tic tac toe game.
 */
 class TicTacToeBoardManager extends BoardManager {

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
     * A TicTacToeBoard.
     */
    private TicTacToeBoard ticTacToeBoard;
    /**
     * A TTTScore ticTacToeBoard.
     */
    private TicTacToeScore TicTacToeScoreboard;
    /**
     * set won = false
     */
    boolean won = false;
    /**
     * set a random computer player.
     */
    private TicTacToeRandomPlayer computer;


    TicTacToeBoardManager(int size) {
        this.ticTacToeBoard = new TicTacToeBoard(size);
        this.TicTacToeScoreboard = new TicTacToeScore(size);
    }

    public TicTacToeBoard getSlidingTilesBoard() {
        return ticTacToeBoard;
    }

    /**
     * Update win or not, If not win, check move.
     * @param fieldIdx Index of the Tile.
     * @param player The Player.
     * @return Move or not.
     */
    boolean Move(int fieldIdx, @FieldValue int player) {

        if (ticTacToeBoard.move(fieldIdx, player)) {
            won = TicTacToeScoreboard.Update(fieldIdx, player);
            Log.d("field", "idx: " + fieldIdx + " val: " + player);
            Log.d("field", "score: " + TicTacToeScoreboard.GetScore());

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
    void SwitchAI(TicTacToeRandomPlayer computer) {
        this.computer = computer;
        this.computer.setTicTacToeBoardManager(this);
    }
}