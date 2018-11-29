package a207project.fall18.GameCenter;

import java.io.Serializable;
import java.util.Observable;

public abstract class BoardManager extends Observable implements Serializable {

    public Board board;

    public Board getBoard(){
        return board;
    }
}
