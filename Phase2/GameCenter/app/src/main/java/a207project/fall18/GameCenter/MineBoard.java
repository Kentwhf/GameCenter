package a207project.fall18.GameCenter;


import android.database.Observable;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * The board for minesweeper game
 */
public class MineBoard extends Observable implements Serializable, Iterable<> {
    /**
     * The number of columns.
     */
    static int NUM_COLS;
    /**
     * The number of rows.
     */
    static int NUM_ROWS;
//    /**
//     * The x coordinate of a base bottom
//     */
//    private int x;
//    /**
//     * The y coordinate of a base bottom
//     */
//    private int y;

    /**
     * The baseBottoms on the board in row-major order.
     */
    private BaseBottom[][] baseBottoms = new BaseBottom[NUM_ROWS][NUM_COLS];

    /**
     * A new board of baseBottoms in row-major order.
     * Precondition: len(baseBottoms) == NUM_ROWS * NUM_COLS
     *
     * @param baseBottoms the baseBottoms for the board
     */
    MineBoard(List<BaseBottom> baseBottoms) {
        Iterator<BaseBottom> iter = baseBottoms.iterator();
        for (int row = 0; row != Board.NUM_ROWS; row++) {
            for (int col = 0; col != Board.
                    NUM_COLS; col++) {
                this.baseBottoms[row][col] = iter.next();
            }
        }
    }

    public static void setNumRowsCols(int num) {
        NUM_ROWS = num;
        NUM_COLS = num;
    }

    /**
     * Return the number of baseBottoms on the board.
     *
     * @return the number of baseBottoms on the board
     */
    int numbaseBottoms() {
        return NUM_ROWS * NUM_COLS;
    }

    /**
     * Return the tile at (row, col)
     *
     * @param row the tile row
     * @param col the tile column
     * @return the tile at (row, col)
     */
    BaseBottom getBaseBotton(int row, int col) {
        return baseBottoms[row][col];
    }

    /**
     * Swap the baseBottoms at (row1, col1) and (row2, col2)
     *
     * @param row1 the first tile row
     * @param col1 the first tile col
     * @param row2 the second tile row
     * @param col2 the second tile col
     */
    void swapbaseBottoms(int row1, int col1, int row2, int col2) {

        BaseBottom t1 = baseBottoms[row1][col1];
        baseBottoms[row1][col1] = baseBottoms[row2][col2];
        baseBottoms[row2][col2] = t1;

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Board{" +
                "baseBottoms=" + Arrays.toString(baseBottoms) +
                '}';
    }

    @NonNull
    @Override
    public Iterator<Tile> iterator() {
        return new MineBoard.MineBoardIterator();
    }

    /**
     * The BoardIterator class
     */
    private class MineBoardIterator implements Iterator<Tile> {

        /**
         * The index of the tile.
         */
        int nextIndex = 0;
        int row = nextIndex / Board.NUM_COLS;
        int col = nextIndex % Board.NUM_COLS;

        /**
         * Return a boolean that if the current tile has the next tile
         *
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
         *
         * @return the next tile at [row][col]
         */
        public BaseBottom next() {
            if (hasNext()) {
                BaseBottom result = baseBottoms[row][col];
                nextIndex++;
                return result;
            }
            throw new NoSuchElementException();
        }
    }

}

