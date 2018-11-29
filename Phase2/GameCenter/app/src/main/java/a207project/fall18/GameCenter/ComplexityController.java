package a207project.fall18.GameCenter;

import android.content.Intent;

import a207project.fall18.GameCenter.dao.SaveDao;

public class ComplexityController {
    private String game;
    private SaveDao savingManager;
    private BoardManager boardManager;
    private int undoTime;

    public ComplexityController(int undoTime){
        game = MyApplication.getInstance().gameType;
        savingManager = MyApplication.getInstance().getSavingManager();
        this.undoTime = undoTime;
    }



    public void Easy(){
        if (game == "SlidingTiles"){
            Board.setNumRowsCols(3);
            boardManager = new BoardManager();
            boardManager.setCanUndoTime(undoTime);
            savingManager.autoSave(boardManager);
            MyApplication.getInstance().setBoardManager(boardManager);

        }

        else if(game == "TicTacToe"){
            TicTacToeGameActivity.dim = 3;
//            Intent i = new Intent(ComplexityActivity, TicTacToeGameActivity.class);
//            startActivity(i);
        }
//
//        else{
//
//        }

    }

    public void Intermediate(){
        if (game == "SlidingTiles"){
            Board.setNumRowsCols(4);
            boardManager = new BoardManager();
            boardManager.setCanUndoTime(undoTime);
            savingManager.autoSave(boardManager);
            MyApplication.getInstance().setBoardManager( boardManager);
        }

        else if(game == "TicTacToe"){
            TicTacToeGameActivity.dim = 4;
        }
//
//        else{}

    }

    public void Difficult(){
        if (game == "SlidingTiles"){
            Board.setNumRowsCols(5);
            boardManager = new BoardManager();
            boardManager.setCanUndoTime(undoTime);
            savingManager.autoSave( boardManager);
            MyApplication.getInstance().setBoardManager((BoardManager) boardManager);
        }

        else if(game == "TicTacToe"){
            TicTacToeGameActivity.dim = 5;
        }

//        else{}

    }

}
