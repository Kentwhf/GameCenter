package a207project.fall18.GameCenter;


import a207project.fall18.GameCenter.bean.Score;

/**
 * The tic tac toe game.
 */
 public class TicTacToeBoardManager extends BoardManager {

     private Score score;

    /**
     * int of X = -1
     */
    static final int X = -1;
    /**
     * int O = 1
     */
    static final int O = 1;
    /**
     * int Empty = 0
     */
    static final int EMPTY = 0;

    /**
     * A TicTacToeBoard.
     */
    private TicTacToeBoard TicTacToeBoard;
    /**
     * A TTTScore ticTacToeBoard.
     */
    private TicTacToeScore TicTacToeScoreboard;
    /**
     * set won = false
     */
    boolean won = false;
    /**
     * set a random computer player.
     */
    private TicTacToeRandomPlayer computer;


    /**
     * TicTacToe tiles manager.
     * @param size dim of the tiles.
     */
    TicTacToeBoardManager(int size) {
        this.TicTacToeBoard = new TicTacToeBoard(size);
        this.TicTacToeScoreboard = new TicTacToeScore(size);
    }

    /**
     * Get a TicTacToeBoard.
     * @return A TicTacToeBoard.
     */
    TicTacToeBoard getSlidingTilesBoard() {
        return TicTacToeBoard;
    }

    /**
     * Update win or not, If not win, check move.
     * @param tileID Index of the SlidingTile.
     * @param player The Player.
     * @return Move or not.
     */
    boolean Move(int tileID, int player) {

        if (TicTacToeBoard.move(tileID, player)) {
            won = TicTacToeScoreboard.Update(tileID, player);
//            Log.d("field", "idx: " + tileID + " val: " + player);
//            Log.d("field", "score: " + TicTacToeScoreboard.GetScore());

            return true;
        }

        return false;
    }

    /**
     * Get an available move.
     * @param player the player.
     * @return the index of move.
     */
    int GetMove(int player)
    {
        return computer.GetMove(player);
    }


    /**
     * Switch computer move.
     * @param computer computer player.
     */
    void SwitchAI(TicTacToeRandomPlayer computer) {
        this.computer = computer;
        this.computer.setTicTacToeBoardManager(this);
    }

    @Override
    public void setScore() {
    }
}