package a207project.fall18.GameCenter;

import java.io.Serializable;
import java.util.Observable;

import a207project.fall18.GameCenter.bean.Score;

public abstract class BoardManager extends Observable implements Serializable {

    private Board board;
    private Score score;

    abstract public void setScore();

    public Score getScore() {
        return score;
    }

    public Board getBoard() {return board;};

    public void setBoard(Board board) {
        this.board = board;
    }

}
