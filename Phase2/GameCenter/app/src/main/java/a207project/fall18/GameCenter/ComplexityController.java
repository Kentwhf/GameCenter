package a207project.fall18.GameCenter;

import a207project.fall18.GameCenter.dao.SaveDao;

/**
 * ComplexityController class.
 */
public class ComplexityController {
    /**
     * A game
     */
    private String game;
    /**
     * Manager for saving games
     */
    private SaveDao savingManager;
    /**
     * Manager that manages boards of games
     */
    private BoardManager boardManager;
    /**
     * Number of undo chances
     */
    private int undoTime;

    /**
     * Constructs a Complexity Controller
     */
    public ComplexityController(){
        game = MyApplication.getInstance().gameType;
        savingManager = MyApplication.getInstance().getSavingManager();
    }

    /**
     * Returns the board manager
     *
     * @return boardManager
     */
    public BoardManager getBoardManager() {
        return boardManager;
    }

    /**
     * Sets the undo times of game
     *
     * @param undoTime undo chances
     */
    public void SetUndoTime(int undoTime){
        this.undoTime = undoTime;
    }

    /**
     * Easy game
     */
    public void Easy(){
        boardManager = setBoardManager(game, 3);
    }

    /**
     * Intermediate game
     */
    public void Intermediate() {
       boardManager = setBoardManager(game, 4);
    }

    /**
     * Hard game
     */
    public void Difficult(){
        boardManager = setBoardManager(game, 5);
    }

    /**
     * Sets the boardManager for game.
     *
     * @param game game played
     * @param complexity of game
     * @return boardManager
     */
    private BoardManager setBoardManager(String game, int complexity){
        switch (game) {
            case "SlidingTiles":
                SlidingTilesBoard.setNumRowsCols(complexity);
                boardManager = new SlidingTilesBoardManager();
                ((SlidingTilesBoardManager) boardManager).setCanUndoTime(undoTime);
                break;
            case "TicTacToe":
                boardManager = new TicTacToeBoardManager(complexity);
                TicTacToeGameActivity.size = complexity;
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
