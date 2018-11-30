package a207project.fall18.GameCenter;

import android.content.Intent;

import a207project.fall18.GameCenter.dao.SaveDao;

public class ComplexityController {
    private String game;
    private SaveDao savingManager;
    private SlidingTilesBoardManager boardManager;
    private int undoTime;

    public ComplexityController(int undoTime){
        game = MyApplication.getInstance().gameType;
        savingManager = MyApplication.getInstance().getSavingManager();
        this.undoTime = undoTime;
    }

    public BoardManager getBoardManager(){return this.boardManager;}



    // 简化三个难度的code. Redundant, code smell
    // 可以 tiles.manager 写个 toString， 这里可以写个method调用，然后新建对应的manager. 然后在三个难度里call一次就好了
    // 可以考虑新建static fields 3,4,5.
    public void Easy(){
        if (game.equals("SlidingTiles")){
            SlidingTilesBoard.setNumRowsCols(3);
            boardManager = new SlidingTilesBoardManager();
            boardManager.setCanUndoTime(undoTime);
            savingManager.autoSave(boardManager);
            MyApplication.getInstance().setBoardManager(boardManager);

        }

        else if(game.equals("TicTacToe")){
            TicTacToeGameActivity.size = 3;
//            Intent i = new Intent(ComplexityActivity, TicTacToeGameActivity.class);
//            startActivity(i);
        }
//
        else{

        }

    }

    public void Intermediate(){
        if (game.equals("SlidingTiles")){
            SlidingTilesBoard.setNumRowsCols(4);
            boardManager = new SlidingTilesBoardManager();
            boardManager.setCanUndoTime(undoTime);
            savingManager.autoSave(boardManager);
            MyApplication.getInstance().setBoardManager( boardManager);
        }

        else if(game.equals("TicTacToe")){
            TicTacToeGameActivity.size = 4;
        }
//
        else{}

    }

    public void Difficult(){
        if (game.equals("SlidingTiles")){
            SlidingTilesBoard.setNumRowsCols(5);
            boardManager = new SlidingTilesBoardManager();
            boardManager.setCanUndoTime(undoTime);
            savingManager.autoSave( boardManager);
            MyApplication.getInstance().setBoardManager((BoardManager) boardManager);
        }

        else if(game == "TicTacToe"){
            TicTacToeGameActivity.size = 5;
        }

        else{}
    }




}
