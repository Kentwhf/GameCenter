package a207project.fall18.GameCenter;

import java.util.ArrayList;


/**
 * Subclass of Score for SlidingTiles
 */
public class SlidingTilesScore extends Score implements Comparable{

    private int complexity;
    private int numofmove;
    private BoardManager boardManager;
    public static ArrayList<SlidingTilesScore> scores;
    private float value;

    public SlidingTilesScore(String username) {
        player = username;
        numofmove = BoardManager.s.size();
        game = "SlidingTiles";
        complexity = (int) Math.sqrt(boardManager.getBoard().numTiles());

        if (boardManager.puzzleSolved()){
            value = 1000 / this.numofmove;
        } else {
            value = 0;
        }

    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof SlidingTilesScore) {
            SlidingTilesScore temp = (SlidingTilesScore) o;
            return ((int)(this.value - temp.value));
        }
        return 0;
    }
}







