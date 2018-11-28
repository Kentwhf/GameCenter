package a207project.fall18.GameCenter;

import android.content.Context;
import android.widget.Toast;
import java.util.Collections;

import a207project.fall18.GameCenter.dao.ScoreDao;


public class MovementController {
    private BoardManager boardManager = null;

//    private SlidingTilesScore slidingTilesScore = null;

    public MovementController() {
    }

    public void setBoardManager(BoardManager boardManager) {
        this.boardManager = boardManager;
    }

    public void processTapMovement(Context context, int position,  boolean display) {
        if (boardManager.isValidTap(position)) {
            boardManager.touchMove(position);
            if (boardManager.puzzleSolved()) {
                MyApplication.getInstance().getScoreDao().insert(boardManager.getScore());

//                MyApplication.getInstance().currentScore.setFinalScore(boardManager.getBoard().getCurrentscore());

                // Send current score here. Singleton needed.
//                 SlidingTilesScore current = new SlidingTilesScore("");
//                 SlidingTilesScore.scores.add(current);
//                 Collections.sort(SlidingTilesScore.scores);

                Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Invalid Tap", Toast.LENGTH_SHORT).show();
        }
    }
}

