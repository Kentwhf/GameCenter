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
    private TicTacToeBoardManager tictactoeboardmanager1;
    private TicTacToeBoardManager tictactoeboardmanager2;
    private TicTacToeBoardManager tictactoeboardmanager3;
    private TicTacToeBoard ticTacToeBoard1;
    private TicTacToeScore ticTacToeScore1;


    @Before
    public void setUp() throws Exception {
        tictactoeboardmanager1 = new TicTacToeBoardManager(3);
        ticTacToeBoard1 = new TicTacToeBoard(3);
        ticTacToeBoard1 = tictactoeboardmanager1.getTicTacToeBoard();
        tictactoeboardmanager2 = new TicTacToeBoardManager(4);
        tictactoeboardmanager3 = new TicTacToeBoardManager(5);
    }

    @After
    public void tearDown() throws Exception {
        tictactoeboardmanager1 = null;
        tictactoeboardmanager2 = null;
        tictactoeboardmanager3 = null;
    }

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

    @Test
    public void MoveTest() {
        boolean result1 = tictactoeboardmanager1.Move(1,1);
        boolean result2 = tictactoeboardmanager1.Move(4,-1);
//        boolean result3 = tictactoeboardmanager2.Move(6,1);
//        boolean result4 = tictactoeboardmanager2.Move(3,-1);
//        boolean result5 = tictactoeboardmanager3.Move(7,1);
//        boolean result6 = tictactoeboardmanager3.Move(2,-1);

        assertEquals(true, result1);
        assertEquals(true, result2);
//        assertEquals(true, result3);
//        assertEquals(true, result4);
//        assertEquals(true, result5);
//        assertEquals(true, result6);



    }

    @Test
    public void getMoveTest() {
        int result1 = tictactoeboardmanager1.getMove(1);
        int result2 = tictactoeboardmanager1.getMove(-1);
        assertEquals(1, result1);
        assertEquals(1, result2);
    }

    @Test
    public void switchAITest() {
    }
}