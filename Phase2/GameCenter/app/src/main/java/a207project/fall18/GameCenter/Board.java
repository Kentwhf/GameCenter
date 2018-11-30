package a207project.fall18.GameCenter;

import java.io.Serializable;
import java.util.Observable;

/**
 * A Board class.
 */
public class Board extends Observable implements Serializable {


    /**
     * Tiles of this game board.
     */
    private Object[][] tiles;


    /**
     * Returns the tiles of this board.
     *
     * @return tiles of board
     */
    public Object[][] getTiles() {
        return tiles;
    }

    /**
     * Sets the tiles of this board.
     *
     * @param tiles tiles of this game board
     */
    public void setTiles(Object[][] tiles) {
        this.tiles = tiles;
    }








}
