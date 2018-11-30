package a207project.fall18.gamecenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import a207project.fall18.GameCenter.Board;
import a207project.fall18.GameCenter.SlidingTile;
import a207project.fall18.GameCenter.SlidingTilesBoard;
import a207project.fall18.GameCenter.SlidingTilesBoardManager;

import static org.junit.Assert.*;

public class SlidingTilesBoardTest extends Board {
    /** The board manager for testing. */
    SlidingTilesBoard board;
    SlidingTilesBoardManager boardmanager;
    int NUM_ROWS = board.getNumRows();
    int NUM_COLS = board.getNumCols();

    /**
     * Make a set of tiles that are in order.
     * @return a set of tiles that are in order
     */
    private List<SlidingTile> makeTiles() {
        List<SlidingTile> tiles = new ArrayList<>();
        final int numTiles = SlidingTilesBoard.getNumCols() * SlidingTilesBoard.getNumRows();
        for (int tileNum = 0; tileNum != numTiles; tileNum++) {
            tiles.add(new SlidingTile(tileNum + 1, tileNum));
        }

        return tiles;
    }

    @Before
    public void setUp() throws Exception {
        List<SlidingTile> tiles = makeTiles();
        SlidingTilesBoard board = new SlidingTilesBoard(tiles);
        boardmanager = new SlidingTilesBoardManager(tiles);
    }

    @After
    public void tearDown() throws Exception {
        board = null;
        boardmanager = null;
    }

    /**
     * Shuffle a few tiles.
     */
    private void swapFirstTwoTiles() {
        boardmanager.getBoard().swapTiles(0, 0, 0, 1);
    }

    /**
     * Test whether swapping two tiles makes a solved board unsolved.
     */
    @Test
    public void testIsSolved() {
        assertEquals(true, boardmanager.puzzleSolved());
        swapFirstTwoTiles();
        assertEquals(false, boardmanager.puzzleSolved());
    }

    /**
     * Test whether swapping the first two tiles works.
     */
    @Test
    public void testSwapFirstTwo() {
        assertEquals(1, boardmanager.getBoard().getTile(0, 0).getId());
        assertEquals(2, boardmanager.getBoard().getTile(0, 1).getId());
        boardmanager.getBoard().swapTiles(0, 0, 0, 1);
        assertEquals(2, boardmanager.getBoard().getTile(0, 0).getId());
        assertEquals(1, boardmanager.getBoard().getTile(0, 1).getId());
    }

    /**
     * Test whether swapping the last two tiles works.
     */
    @Test
    public void testSwapLastTwo() {
        assertEquals(15, boardmanager.getBoard().getTile(3, 2).getId());
        assertEquals(16, boardmanager.getBoard().getTile(3, 3).getId());
        boardmanager.getBoard().swapTiles(3, 3, 3, 2);
        assertEquals(16, boardmanager.getBoard().getTile(3, 2).getId());
        assertEquals(15, boardmanager.getBoard().getTile(3, 3).getId());
    }

    /**
     * Test whether isValidHelp works.
     */
    @Test
    public void testIsValidTap() {
        assertEquals(true, boardmanager.isValidTap(11));
        assertEquals(true, boardmanager.isValidTap(14));
        assertEquals(false, boardmanager.isValidTap(10));
    }
}