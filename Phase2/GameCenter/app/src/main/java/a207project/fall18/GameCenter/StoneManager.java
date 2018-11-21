package a207project.fall18.GameCenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoneManager {
    /**
     * The board being managed.
     */
    public String[][] board;

    public static ArrayList<String> s = new ArrayList<>();


    /**
     * Manage a board that has been pre-populated.
     *
     */
    StoneManager() {
        board = new String[][]{{"U", "V", "W", "X", "Y"},
                {"O", "P", "Q", "R", "S", "T"},
                {"J", "K", "L", "M", "N"},
                {"F", "G", "H", "I"}, { "C", "D", "E"}, {"A", "B"}};
    }

    /**
     * Manage a new shuffled board.
     */
//    StoneManager() {
//        List<Tile> stones = new ArrayList<>();
//        final int numTiles = Board.NUM_ROWS * Board.NUM_COLS;
//        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
//            stones.add(new Tile(tileNum));
//        }
//
//       ;
//    }

}
