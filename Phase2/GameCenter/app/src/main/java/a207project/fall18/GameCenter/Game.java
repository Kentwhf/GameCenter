package a207project.fall18.GameCenter;

import android.support.annotation.IntDef;
import android.util.Log;

/**
 * The tic tac toe game.
 */
 class Game {

    static final int X = -1;
    static final int O = 1;
    static final int EMPTY = 0;

    @IntDef({X, O, EMPTY})
    @interface FieldValue {
    }

    private TTTBoard board;
    private TTTScore scoreBoard;
    boolean won = false;
    private RandomPlayer computer;


    Game(int dim) {
        this.board = new TTTBoard(dim);
        this.scoreBoard = new TTTScore(dim);
    }

    public TTTBoard getBoard() {
        return board;
    }

    boolean Move(int fieldIdx, @FieldValue int player) {

        if (board.move(fieldIdx, player)) {
            won = scoreBoard.Update(fieldIdx, player);
            Log.d("field", "idx: " + fieldIdx + " val: " + player);
            Log.d("field", "score: " + scoreBoard.GetScore());

            return true;
        }

        return false;
    }

    int GetMove(@FieldValue int fieldValue)
    {
        return computer.GetMove(fieldValue);
    }


    void SwitchAI(RandomPlayer computer) {
        RandomPlayer.game = this;
        this.computer = computer;
    }
}