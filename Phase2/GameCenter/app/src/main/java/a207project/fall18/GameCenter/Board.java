package a207project.fall18.GameCenter;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Stack;

/**
 * The sliding tiles board.
 */
public class Board extends Observable implements Serializable, Iterable<Tile> {

    public static Stack s = new Stack();
    /**
     * The number of rows.
     */
    static int NUM_ROWS;
    /**
     * The number of cols.
     */
    static int NUM_COLS;
    /**
     * The tiles on the board in row-major order.
     */

    private Tile[][] tiles = new Tile[NUM_ROWS][NUM_COLS];

    /**
     * A new board of tiles in row-major order.
     * Precondition: len(tiles) == NUM_ROWS * NUM_COLS
     *
     * @param tiles the tiles for the board
     */
    Board(List<Tile> tiles) {
        Iterator<Tile> iter = tiles.iterator();
        for (int row = 0; row != Board.NUM_ROWS; row++) {
            for (int col = 0; col != Board.
                    NUM_COLS; col++) {
                this.tiles[row][col] = iter.next();
            }
        }
    }

    public static void setNumRowsCols(int num) {
        NUM_ROWS = num;
        NUM_COLS = num;
    }

    /**
     * Return the number of tiles on the board.
     *
     * @return the number of tiles on the board
     */
    int numTiles() {
        return NUM_ROWS * NUM_COLS;
    }

    /**
     * Return the tile at (row, col)
     *
     * @param row the tile row
     * @param col the tile column
     * @return the tile at (row, col)
     */
    Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    /**
     * Swap the tiles at (row1, col1) and (row2, col2)
     *
     * @param row1 the first tile row
     * @param col1 the first tile col
     * @param row2 the second tile row
     * @param col2 the second tile col
     */
    void swapTiles(int row1, int col1, int row2, int col2) {

        Tile t1 = tiles[row1][col1];
        tiles[row1][col1] = tiles[row2][col2];
        tiles[row2][col2] = t1;

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Board{" +
                "tiles=" + Arrays.toString(tiles) +
                '}';
    }

    @NonNull
    @Override
    public Iterator<Tile> iterator() {
        return new BoardIterator();
    }

    /**
     * The BoardIterator class
     */
    private class BoardIterator implements Iterator<Tile> {

        /** The index of the tile. */
        int nextIndex = 0;
        int row = nextIndex / Board.NUM_COLS;
        int col = nextIndex % Board.NUM_COLS;

        /**
         * Return a boolean that if the current tile has the next tile
         * @return a boolean that if the current tile has the next tile
         */
        public boolean hasNext() {
            boolean toTell = true;
            if (row >= Board.NUM_ROWS) {
                toTell = false;
            }
            return toTell;
        }

        /**
         * Return the next tile at [row][col]
         * @return the next tile at [row][col]
         */
        public Tile next() {
            if (hasNext()){
                Tile result = tiles[row][col];
                nextIndex++;
                return result;
            }
            throw new NoSuchElementException();
        }
    }
}
