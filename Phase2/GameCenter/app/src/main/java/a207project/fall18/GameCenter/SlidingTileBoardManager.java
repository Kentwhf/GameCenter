package a207project.fall18.GameCenter;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import a207project.fall18.GameCenter.bean.Score;


/**
 * Manage a board, including swapping tiles, checking for a win, and managing taps.
 */
public class SlidingTileBoardManager extends BoardManager implements Serializable {

    private Score score;

    /**
     * The board being managed.
     */
    private Board board;

    public static ArrayList<Integer> s = new ArrayList<>();

    public int undo_time = 0;

    public int can_undo_time ;

    /**
     * Manage a board that has been pre-populated.
     *
     * @param board the board
     */
    SlidingTileBoardManager(Board board) {
        this.board = board;
    }

    /**
     * Manage a new shuffled board.
     */
    SlidingTileBoardManager() {
        List<Tile> tiles = new ArrayList<>();
        final int numTiles = Board.NUM_ROWS * Board.NUM_COLS;
        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
            tiles.add(new Tile(tileNum));
        }

        Collections.shuffle(tiles);
        this.board = new Board(tiles);
        score = new Score(MyApplication.getInstance().getUser(), "SlidingTiles");
    }


    /**
     * Return the current board.
     */
    Board getBoard() {
        return board;
    }

    /**
     * Return whether the tiles are in row-major order.
     *
     * @return whether the tiles are in row-major order
     */
    boolean puzzleSolved() {
        for (int i = 0; i < Board.NUM_ROWS; i++) {
            for (int j = 0; j < Board.NUM_COLS; j++) {
                if (board.getTile(i, j).getId() != i * Board.NUM_COLS + j + 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void undoTimePlus(){
        this.undo_time += 1;
    }

    public void setCanUndoTime(int time) {

        this.can_undo_time = time;

    }

    /**
     * Return whether any of the four surrounding tiles is the blank tile.
     *
     * @param position the tile to check
     * @return whether the tile at position is surrounded by a blank tile
     */
    boolean isValidTap(int position) {

        int blankId = board.numTiles();
        // Are any of the 4 the blank tile?
        Tile[] temp = tileArray(position);
        return (temp[0] != null && temp[0].getId() == blankId)
                || (temp[1] != null && temp[1].getId() == blankId)
                || (temp[2] != null && temp[2].getId() == blankId)
                || (temp[3] != null && temp[3].getId() == blankId);
    }

    public boolean undo() {
        if (undo_time < can_undo_time && board.getCurrentscore() < 100){
            undoTimePlus();
            int col1 = s.get(s.size()-3);
            int row1 = s.get(s.size()-4);
            int col2 = s.get(s.size()-1);
            int row2 = s.get(s.size()-2);
            board.swapTiles(row1, col1, row2, col2);
            s.remove(s.size()-1);
            s.remove(s.size()-1);
            s.remove(s.size()-1);
            s.remove(s.size()-1);
            int newScore = board.getCurrentscore() + 1;
            board.setCurrentscore(newScore);
            return true;
        }
        return false;
    }

    /**
     * Process a touch at position in the board, swapping tiles as appropriate.
     *
     * @param position the position
     */
    void touchMove(int position) {
        int row = position / Board.NUM_ROWS;
        int col = position % Board.NUM_COLS;
        int blankId = board.numTiles();
        Tile above = row == 0 ? null : board.getTile(row - 1, col);
        Tile below = row == Board.NUM_ROWS - 1 ? null : board.getTile(row + 1, col);
        Tile left = col == 0 ? null : board.getTile(row, col - 1);
        Tile right = col == Board.NUM_COLS - 1 ? null : board.getTile(row, col + 1);
        if (isValidTap(position)) {
            if (above != null && above.getId() == blankId) {
                board.swapTiles(row, col, row - 1, col);
                s.add(row-1);
                s.add(col);
                s.add(row);
                s.add(col);
            } else if (below != null && below.getId() == blankId) {
                s.add(row+1);
                s.add(col);
                s.add(row);
                s.add(col);
                board.swapTiles(row, col, row + 1, col);
            } else if (left != null && left.getId() == blankId) {
                s.add(row);
                s.add(col-1);
                s.add(row);
                s.add(col);
                board.swapTiles(row, col, row, col - 1);
            } else if (right != null && right.getId() == blankId) {
                s.add(row);
                s.add(col+1);
                s.add(row);
                s.add(col);
                board.swapTiles(row, col, row, col + 1);
            }
            board.scoring();
        }
    }



    /**
     * Return an array of the four surrounding tiles.
     *
     * @param position the position
     * @return Tile[]
     */
    private Tile[] tileArray(int position) {

        int row = position / Board.NUM_COLS;
        int col = position % Board.NUM_COLS;
        Tile above = row == 0 ? null : board.getTile(row - 1, col);
        Tile below = row == Board.NUM_ROWS - 1 ? null : board.getTile(row + 1, col);
        Tile left = col == 0 ? null : board.getTile(row, col - 1);
        Tile right = col == Board.NUM_COLS - 1 ? null : board.getTile(row, col + 1);
        return new Tile[]{above, below, left, right};
    }

//    @Override
//    public String toString(){
//        return board.toString();
//    }


//    protected Object clone()  {
//        try {
//            BoardManager cloneBoardManager = (BoardManager) super.clone();
//            return cloneBoardManager;
//        } catch (CloneNotSupportedException ignore){}
//
//        return null;
//    }

    public Score getScore(){return this.score;}
    public void setScore(){this.score.setFinalScore(board.getCurrentscore());}

}