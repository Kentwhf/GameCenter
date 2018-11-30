package a207project.fall18.GameCenter;

import android.content.Intent;

import a207project.fall18.GameCenter.dao.SaveDao;

public class ComplexityController {
    private String game;
    private SaveDao savingManager;
    private BoardManager boardManager;
    private int undoTime;

    public ComplexityController(){
        game = MyApplication.getInstance().gameType;
        savingManager = MyApplication.getInstance().getSavingManager();
    }

    public BoardManager getBoardManager() {
        return boardManager;
    }

//    public BoardManager getBoardManager(){return this.boardManager;}

    public void ConfirmUndoTime(int undoTime){
        this.undoTime = undoTime;
    }

    public void Easy(){
        boardManager = getBoardManager(game, 3);
    }

    public void Intermediate() {
       boardManager = getBoardManager(game, 4);
    }

    public void Difficult(){
        boardManager = getBoardManager(game, 5);
    }

    public BoardManager getBoardManager(String game, int complexity){
        switch (game) {
            case "SlidingTiles":
                SlidingTilesBoard.setNumRowsCols(complexity);
                boardManager = new SlidingTilesBoardManager();
                ((SlidingTilesBoardManager) boardManager).setCanUndoTime(undoTime);
                break;
            case "TicTacToe":
                boardManager = new TicTacToeBoardManager(complexity);
                break;
            default:
                boardManager = new SudokuBoardManager();
                break;
        }
        savingManager.autoSave(boardManager);
        MyApplication.getInstance().setBoardManager(boardManager);
        return boardManager;
    }
}
