package a207project.fall18.GameCenter;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import a207project.fall18.GameCenter.bean.Score;


/**
 * Manage a board, including swapping tiles, checking for a win, and managing taps.
 */
public class BoardManager implements Serializable {

    private Score score = new Score();

//    private List<Tile> tilesList;

    /**
     * The board being managed.
     */
    private Board board;

    public static ArrayList<Integer> s = new ArrayList<>();

    public int undo_time = 0;

    public int can_undo_time;

    /**
     * Manage a board that has been pre-populated.
     *
     * @param tiles the board in 2D List
     */
    public BoardManager(List<Tile> tiles) {
//        Board.setNumRowsCols(4);
////        List<Tile> tiles = new ArrayList<>();
//        final int numTiles = Board.NUM_ROWS * Board.NUM_COLS;
//        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
//            tiles.add(new Tile(tileNum));
//        }
        this.board = new Board(tiles);
//        this.board = board;
    }

    /**
     * Manage a new shuffled board.
     */
    BoardManager() {
        List<Tile> tiles = new ArrayList<>();
        final int numTiles = Board.NUM_ROWS * Board.NUM_COLS;
        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
            tiles.add(new Tile(tileNum));
        }

        //        Collections.shuffle(tiles);
//        System.out.println("wtf");
//        while (!(((Board.NUM_ROWS % 2 != 0) && (findNumInversion(tiles) % 2 == 0)) ||
//                ((Board.NUM_ROWS % 2 == 0) && ((blankOnOddRowFromBottom(tiles)) ==
//                        (findNumInversion(tiles) % 2 == 0))))) {
//            System.out.println("wtf2");
//            Collections.shuffle(tiles);
//        }



//        if (!(((Board.NUM_ROWS % 2 != 0) && (findNumInversion(tiles) % 2 == 0)) ||
//                ((Board.NUM_ROWS % 2 == 0) && ((blankOnOddRowFromBottom(tiles)) ==
//                        (findNumInversion(tiles) % 2 == 0))))) {
//            Collections.shuffle(tiles);
//        }

        // IDK MAN..
//        tilesList = tiles;
        this.board = new Board(tiles);
        score = new Score(MyApplication.getInstance().getUser(), "SlidingTiles");
        makeBoard(tiles);
    }

//    public List<Tile> getTilesList() {return tilesList;}

    private void makeBoard(List<Tile> lst) {
        int blankIndex = findBlank(lst);

        System.out.println(blankIndex);

        Random r = new Random();
        int bound = r.nextInt((500 - 450) + 1) + 450;

        for (int i = 0; i < bound; i++) {

            System.out.println("wtf" + i);

            int row = blankIndex / Board.NUM_ROWS;
            int col = blankIndex % Board.NUM_COLS;
            String swapWith = pickRandomTile(row, col);
            switch (swapWith) {
                case "top":
                    board.swapTiles(row, col, row - 1, col);
                    if (Board.NUM_ROWS == 3) {blankIndex -= 3;}
                    else if (Board.NUM_ROWS == 4) {blankIndex -= 4;}
                    else {blankIndex -= 5;}
                    break;
                case "below":
                    board.swapTiles(row, col, row + 1, col);
                    if (Board.NUM_ROWS == 3) {blankIndex += 3;}
                    else if (Board.NUM_ROWS == 4) {blankIndex += 4;}
                    else {blankIndex += 5;}
                    break;
                case "left":
                    board.swapTiles(row, col, row, col - 1);
                    blankIndex -= 1;
                    break;
                case "right":
                    board.swapTiles(row, col, row, col + 1);
                    blankIndex += 1;
                    break;
            }
        }

    }


//        Random r = new Random();
//
//        return r.nextInt((max - min) + 1) + min;

    //max = (a > b) ? a : b;
//        Tile above = row == 0 ? null : board.getTile(row - 1, col);
//        Tile below = row == Board.NUM_ROWS - 1 ? null : board.getTile(row + 1, col);
//        Tile left = col == 0 ? null : board.getTile(row, col - 1);
//        Tile right = col == Board.NUM_COLS - 1 ? null : board.getTile(row, col + 1);

//        if (Board.NUM_ROWS == 3) {
//            int top = row == 0 ? null : blankIndex - 3;
//            int below = row == Board.NUM_ROWS - 1 ? null :
//        } else if (Board.NUM_ROWS == 4) {
//
//        } else {
//
//        }



    private String pickRandomTile(int row, int col) {
        List<String> listOfTiles = new ArrayList<>();
        if (row != 0) {
            listOfTiles.add("top");
        } if (row != Board.NUM_ROWS - 1) {
            listOfTiles.add("below");
        } if (col != 0) {
            listOfTiles.add("left");
        } if (col != Board.NUM_COLS - 1) {
            listOfTiles.add("right");
        }
        Collections.shuffle(listOfTiles);
        return listOfTiles.get(0);
    }



//    int findNumInversion(List<Tile> lst) {
//
//        int numInversion = 0;
//
////        for (Tile tile : lst) {
////            int currentTileNum = tile.getId();
////            for (int i = lst.indexOf(tile) + 1; i < lst.size(); i++) {
////                if (lst.get(i).getId() < currentTileNum) {numInversion += 1;}
////            }
////        }
//
//        for (int i = 0; i < lst.size(); i++) {
//            int currentTileNum = lst.get(i).getId();
//            if (currentTileNum != Board.NUM_ROWS * Board.NUM_COLS) {
//                for (int x = i + 1; x < lst.size(); x++) {
//                    if (lst.get(x).getId() < currentTileNum) {numInversion += 1;}
//                }
//            }
//        }
//
//        return numInversion;
//    }

//    public static void main(String[] args) {
//        List<Tile> tiles = new ArrayList<>();
//        final int numTiles = 3 * 3;
//        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
//            tiles.add(new Tile(tileNum));
//        }
//
//        for (int i = 9; i < 10; i++) {
//            System.out.println(99);
//        }
//
//        Collections.shuffle(tiles);
//        for (Tile t : tiles) {
//            System.out.println(t.getId());
//        }
//
//        System.out.println(findNumInversion(tiles));
//
//    }

//    boolean blankOnOddRowFromBottom(List<Tile> lst) {
//        for (int i = 0; i < lst.size(); i++) {
//            if (lst.get(i).getId() == Board.NUM_ROWS * Board.NUM_COLS) {
////                if (Board.NUM_ROWS == 3) {
////                    if ((i <= 2) || (6 <= i)) {return true;}
////                } else if (Board.NUM_ROWS == 4) {
////                    if (((4 <= i) && (i <= 7)) || (i >= 12)) {return true;}
////                } else {
////                    if ((i <= 4) || ((10 <= i) && (i <= 14)) || (i >= 24)) {return true;}
////                }
//                if (((4 <= i) && (i <= 7)) || (i >= 12)) {return true;}
//            }
//        }
//        return false;
//    }

    private int findBlank(List<Tile> lst) {
        int id = 0;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).getId() == Board.NUM_ROWS * Board.NUM_COLS) {id = i;}
        }
        return id;
    }

    /**
     * Return the current board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Return whether the tiles are in row-major order.
     *
     * @return whether the tiles are in row-major order
     */
    public boolean puzzleSolved() {
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
    public boolean isValidTap(int position) {

        System.out.println(position);

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
    public void touchMove(int position) {
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