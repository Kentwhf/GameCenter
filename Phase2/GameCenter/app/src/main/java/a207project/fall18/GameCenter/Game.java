package a207project.fall18.GameCenter;

import android.support.annotation.IntDef;
import android.util.Log;

/**
 * The tic tac toe game.
 */
public class Game {

    static final int X = -1;
    static final int O = 1;
    static final int EMPTY = 0;

    @IntDef({X, O, EMPTY})
    @interface FieldValue {
    }

    private TTTBoard board;
    boolean won = false;


    Game(int dim) {
        this.board = new TTTBoard(dim);
    }

    public TTTBoard getBoard() {
        return board;
    }

    boolean Move(int fieldIdx, @FieldValue int player) {

        if (board.move(fieldIdx, player)) {
            Log.d("field", "idx: " + fieldIdx + " val: " + player);

            return true;
        }

        return false;
    }
}