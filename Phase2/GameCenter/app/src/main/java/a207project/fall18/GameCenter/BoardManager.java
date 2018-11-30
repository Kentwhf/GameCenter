package a207project.fall18.GameCenter;

import java.io.Serializable;
import java.util.Observable;

public class BoardManager extends Observable implements Serializable {

    public Board board;

    public Board getSlidingTilesBoard(){
        return board;
    }
}
