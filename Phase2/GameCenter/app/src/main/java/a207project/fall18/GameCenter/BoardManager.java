package a207project.fall18.GameCenter;

import java.io.Serializable;
import java.util.Observable;

import a207project.fall18.GameCenter.bean.Score;

/**
 * A BoardManger class.
 */
public abstract class BoardManager extends Observable implements Serializable {

    /**
     * Board that this manager manages.
     */
    private Board board;
    /**
     * Score of this board manager.
     */
    private Score score;

    /**
     * Sets the score of this board manager.
     */
    abstract public void setScore();

    /**
     * Returns the score of this board manager.
     *
     * @return score
     */
    public Score getScore() {
        return score;
    }

    /**
     * Returns the board of this manager.
     *
     * @return a board
     */
    public Board getBoard() {return board;}

    /**
     * Sets the board of this manager.
     *
     * @param board board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

}
