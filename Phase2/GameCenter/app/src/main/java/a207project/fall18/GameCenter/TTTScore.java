package a207project.fall18.GameCenter;

import android.support.annotation.IntDef;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * TicTacToe score class
 */
class TTTScore {
    /**
     * int X = -1
     */
    static final int X = TicTacToeBoardManager.X;
    /**
     * int O = 1
     */
    static final int O = TicTacToeBoardManager.O;
    /**
     * int Empty = 0
     */
    static final int EMPTY = TicTacToeBoardManager.EMPTY;
    /**
     * int Blocked = 100
     */
    static final int BLOCKED = 100;

    @IntDef({X, O, EMPTY, BLOCKED})
    @interface LineState{}

    private class LineStatus {
        @LineState int state;
        int count;
    }

    private Hashtable<String, LineStatus> lines;
    private int dim;

    /**
     * TTT score which is scored by row, col, left diagonal, right diagonal.
     * @param dim dim of board.
     */
    TTTScore(int dim) {
        this.dim = dim;
        lines = new Hashtable<>();

        for (int i = 0; i < this.dim; i++) {
            lines.put("R" + i, new LineStatus()); // rows
            lines.put("C" + i, new LineStatus()); // columns
        }

        lines.put("D1", new LineStatus()); // diagonal left
        lines.put("D2", new LineStatus()); // diagonal right
    }

    /**
     * Update the new board after move/click.
     * @param fieldIdx Index of tile.
     * @param player the player.
     * @return win or not.
     */
    boolean Update(int fieldIdx, int player) {
        boolean won = false;

        int row = fieldIdx / dim;
        int col = fieldIdx % dim;

        ArrayList<String> lineKeys = new ArrayList<>();
        lineKeys.add("R" + row); // mark row line
        lineKeys.add("C" + col); // add col line

        if (row == col) { lineKeys.add("D1"); }
        if (row + col + 1 == dim) { lineKeys.add("D2"); }

        for (String key : lineKeys) {
            LineStatus lineStatus = lines.get(key);
            if (lineStatus.state == EMPTY) {
                lineStatus.state = player;
            }
            else if (lineStatus.state != player) {
                lineStatus.state = BLOCKED;
            }

            lineStatus.count += player;

            if (lineStatus.count * player >= dim) { won = true; }
        }

        return won;
    }


    /**
     * Get the score of current board
     * @return score
     */
     int GetScore() {
        int score = 0;

        for (Map.Entry<String, LineStatus> entry : lines.entrySet()) {
            LineStatus ls = entry.getValue();

            if (!(ls.state == EMPTY || ls.state == BLOCKED)) {
                if (ls.count * ls.state == dim) {
                    return IntMax() * ls.state;
                }
                else {
                    score += Math.pow(4, ls.count * ls.state) * ls.state;
                }
            }
        }

        return score;
    }

    /**
     * Set a max num
     * @return max num.
     */
    private static int IntMax() {
        return 5000000;
    }
}
