package a207project.fall18.gamecenter;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import a207project.fall18.GameCenter.Board;
import a207project.fall18.GameCenter.BoardManager;
import a207project.fall18.GameCenter.MovementController;
import a207project.fall18.GameCenter.Tile;
import a207project.fall18.GameCenter.bean.Score;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;

public class MovementControllerTest {

//    private Board board;

    private MovementController controller;

    private BoardManager boardManager;

    private List<Tile> lst;

    private int numOfInversion;

    private boolean blankOnOddRowFromBottom;

    private Context context;

    @Before
    public void setUp() throws Exception {
        Board.setNumRowsCols(4);
        lst = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            lst.add(new Tile(i, i));
        }
        lst.add(new Tile(14, 14));
        lst.add(new Tile(13, 13));
        lst.add(new Tile(16, 16));
        lst.add(new Tile(15, 15));
        boardManager = new BoardManager(lst);
        controller = new MovementController();
        controller.setBoardManager(boardManager);
        numOfInversion = 1;
        blankOnOddRowFromBottom = true;
    }

    @Test
    public void createSolvableBoard() {
        boolean outputSolvable;
//        if (((Board.getNumRows() % 2 != 0) && (numOfInversion % 2 == 0)) ||
//                ((Board.getNumRows() % 2 == 0) && ((blankOnOddRowFromBottom) ==
//                        (numOfInversion % 2 == 0)))) {
//            outputSolvable = true;
//        } else {outputSolvable = false;}
        outputSolvable = (((Board.getNumRows() % 2 != 0) && (numOfInversion % 2 == 0)) ||
                ((Board.getNumRows() % 2 == 0) && ((blankOnOddRowFromBottom) ==
                        (numOfInversion % 2 == 0))));
        assertFalse(outputSolvable);

    }

    @Test
    public void processTapMovement() {
//        List<Tile> lst = boardManager.getTilesList();

//        int i = findBlankIndex(lst);
//        if (i == 0) {
//            inputPosition = 1;
//        } else {inputPosition = i - 1;}

        int inputPosition = 15;
        int expectedId = 16;
        int outputId;
        controller.processTapMovement(context, inputPosition, true);
        outputId = boardManager.getBoard().getTile(3, 3).getId();
        assertEquals(expectedId, outputId);

    }

    @After
    public void tearDown() throws Exception {
        lst = null;
        boardManager = null;
        controller = null;
    }

}