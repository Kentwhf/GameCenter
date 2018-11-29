package a207project.fall18.GameCenter;

import android.content.Context;
import android.widget.Toast;
import java.util.Collections;

import a207project.fall18.GameCenter.dao.ScoreDao;


public class MovementController {
    private SlidingTilesBoardManager boardManager = null;

//    private SlidingTilesScore slidingTilesScore = null;

    public MovementController() {
    }

    public void setBoardManager(SlidingTilesBoardManager boardManager) {
        this.boardManager = boardManager;
    }

    public void processTapMovement(Context context, int position,  boolean display) {
        if (boardManager.isValidTap(position)) {
            boardManager.touchMove(position);
            if (boardManager.puzzleSolved()) {
                MyApplication.getInstance().getScoreDao().insert(boardManager.getScore());

//                MyApplication.getInstance().currentScore.setFinalScore(boardManager.getBoard().getCurrentscore());

                Toast.makeText(context, "YOU WIN!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Invalid Tap", Toast.LENGTH_SHORT).show();
        }
    }
}

