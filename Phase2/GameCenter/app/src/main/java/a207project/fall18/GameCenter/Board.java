package a207project.fall18.GameCenter;

import java.io.Serializable;
import java.util.Observable;

public class Board extends Observable implements Serializable {


    private Object[][] tiles;


    public Object[][] getTiles() {
        return tiles;
    }

    public void setTiles(Object[][] tiles) {
        this.tiles = tiles;
    }








}
