package a207project.fall18.GameCenter;

import android.util.Log;

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
    public TicTacToeBoardManager(int size) {
        this.TicTacToeBoard = new TicTacToeBoard(size);
        this.TicTacToeScoreboard = new TicTacToeScore(size);
    }

    public TicTacToeScore TicTacToeScoreBoard(){
        return this.TicTacToeScoreboard;
    }

    /**
     * Get a TicTacToeBoard.
     * @return A TicTacToeBoard.
     */
    public TicTacToeBoard getTicTacToeBoard() {
        return this.TicTacToeBoard;
    }

    /**
     * Update win or not, If not win, check move.
     * @param tileID Index of the SlidingTile.
     * @param player The Player.
     * @return Move or not.
     */
    public boolean Move(int tileID, int player) {

        if (TicTacToeBoard.move(tileID, player)) {
            won = TicTacToeScoreboard.Update(tileID, player);

            return true;
        }

        return false;
    }

    /**
     * Get an available move.
     * @param player the player.
     * @return the index of move.
     */
    public int getMove(int player)
    {
        return computer.getMove(player);

    }


    /**
     * Switch computer move.
     * @param computer computer player.
     */
    public void SwitchAI(TicTacToeRandomPlayer computer) {
        this.computer = computer;
        this.computer.setTicTacToeBoardManager(this);
    }

    @Override
    public void setScore() {
    }
}