package a207project.fall18.GameCenter;

import android.support.annotation.IntDef;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

class TTTScore {
    static final int X = Game.X;
    static final int O = Game.O;
    static final int EMPTY = Game.EMPTY;
    static final int BLOCKED = 100;

    @IntDef({X, O, EMPTY, BLOCKED})
    @interface LineState{}

    private class LineStatus {
        @LineState int state;
        int count;
    }

    private Hashtable<String, LineStatus> lines;
    private int dim;

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

    private static int IntMax() {
        return 2000000000;
    }
}
