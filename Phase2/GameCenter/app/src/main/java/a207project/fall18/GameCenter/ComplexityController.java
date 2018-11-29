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



    // 简化三个难度的code啊！！！完全redundant, code smell
    // 我建议 board.manager 写个 toString， 这里可以写个method调用，然后对应新建一个
    public void Easy(){
        if (game.equals("SlidingTiles")){
            SlidingTilesBoard.setNumRowsCols(3);
            boardManager = new SlidingTilesBoardManager();
            boardManager.setCanUndoTime(undoTime);
            savingManager.autoSave(boardManager);
            MyApplication.getInstance().setBoardManager(boardManager);

        }

        else if(game.equals("TicTacToe")){
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
        if (game.equals("SlidingTiles")){
            SlidingTilesBoard.setNumRowsCols(4);
            boardManager = new SlidingTilesBoardManager();
            boardManager.setCanUndoTime(undoTime);
            savingManager.autoSave(boardManager);
            MyApplication.getInstance().setBoardManager( boardManager);
        }

        else if(game.equals("TicTacToe")){
            TicTacToeGameActivity.dim = 4;
        }
//
//        else{}

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
            TicTacToeGameActivity.dim = 5;
        }

//        else{}

    }

}
