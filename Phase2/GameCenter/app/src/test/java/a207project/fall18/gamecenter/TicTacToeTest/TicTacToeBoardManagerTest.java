package a207project.fall18.gamecenter.TicTacToeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import a207project.fall18.GameCenter.BoardManager;
import a207project.fall18.GameCenter.TicTacToeBoard;
import a207project.fall18.GameCenter.TicTacToeBoardManager;
import a207project.fall18.GameCenter.TicTacToeScore;

import static org.junit.Assert.*;

public class TicTacToeBoardManagerTest {
    /**
     * TicTacToeBoardManager which size = 3
     */
    private TicTacToeBoardManager tictactoeboardmanager1;
    /**
     * TicTacToeBoardManager which size = 4
     */
    private TicTacToeBoardManager tictactoeboardmanager2;
    /**
     * TicTacToeBoardManager which size = 5
     */
    private TicTacToeBoardManager tictactoeboardmanager3;


    /**
     * Set up the testing original.
     * @throws Exception Expected Exception
     */
    @Before
    public void setUp() throws Exception {
        tictactoeboardmanager1 = new TicTacToeBoardManager(3);
        tictactoeboardmanager2 = new TicTacToeBoardManager(4);
        tictactoeboardmanager3 = new TicTacToeBoardManager(5);
    }

    /**
     * Tear down after testing
     * @throws Exception Expected Expection
     */
    @After
    public void tearDown() throws Exception {
        tictactoeboardmanager1 = null;
        tictactoeboardmanager2 = null;
        tictactoeboardmanager3 = null;
    }

    /**
     * Text getTicTacToeBoard.
     */
    @Test
    public void getTicTacToeBoardTest() {
        TicTacToeBoard tictactoeboard1 = new TicTacToeBoard(3);
        assertEquals(tictactoeboard1.getSize(),
                tictactoeboardmanager1.getTicTacToeBoard().getSize());
        TicTacToeBoard tictactoeboard2 = new TicTacToeBoard(4);
        assertEquals(tictactoeboard2.getSize(),
                tictactoeboardmanager2.getTicTacToeBoard().getSize());
        TicTacToeBoard tictactoeboard3 = new TicTacToeBoard(5);
        assertEquals(tictactoeboard3.getSize(),
                tictactoeboardmanager3.getTicTacToeBoard().getSize());
    }

    /**
     * Text Move.
     */
    @Test
    public void MoveTest() {
        boolean result1 = tictactoeboardmanager1.Move(1,1);
        boolean result2 = tictactoeboardmanager1.Move(4,-1);
        assertEquals(true, result1);
        assertEquals(true, result2);




    }

    /**
     * Text GetMove.
     */
    @Test
    public void getMoveTest() {
        int result1 = tictactoeboardmanager1.getMove(1);
        int result2 = tictactoeboardmanager1.getMove(-1);
        assertEquals(1, result1);
        assertEquals(1, result2);
    }

    /**
     * Text SwitchAITest.
     */
    @Test
    public void switchAITest() {
    }
}