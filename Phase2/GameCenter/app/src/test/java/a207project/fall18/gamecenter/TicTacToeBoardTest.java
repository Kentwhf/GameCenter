package a207project.fall18.gamecenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import a207project.fall18.GameCenter.Board;
import a207project.fall18.GameCenter.TicTacToeBoard;

import static java.lang.Character.isDigit;
import static org.junit.Assert.*;

public class TicTacToeBoardTest extends Board {
    private TicTacToeBoard tictactoeboard3;
    private TicTacToeBoard tictactoeboard4;
    private TicTacToeBoard tictactoeboard5;


    @Before
    public void setUp() throws Exception {
        tictactoeboard3 = new TicTacToeBoard(3);
        tictactoeboard4 = new TicTacToeBoard(4);
        tictactoeboard5 = new TicTacToeBoard(5);
    }

    @After
    public void tearDown() throws Exception {
        tictactoeboard3 = null;
        tictactoeboard4 = null;
        tictactoeboard5 = null;
    }

    @Test
    public void move(){
        assertEquals(true, tictactoeboard3.move(3, 1));
        assertEquals(true, tictactoeboard3.move(4, -1));
        assertEquals(true, tictactoeboard4.move(5, 1));
        assertEquals(true, tictactoeboard4.move(2, -1));
        assertEquals(true , tictactoeboard5.move(1, 1));
        assertEquals(true, tictactoeboard5.move(6, -1));


    }


    @Test
    public void isFull() {
        assertEquals(false, tictactoeboard3.isFull());
        assertEquals(false, tictactoeboard4.isFull());
        assertEquals(false, tictactoeboard5.isFull());
    }

    @Test
    public void getRandomEmpty() {
        Integer result1 = tictactoeboard3.getRandomEmpty();
        assertEquals(true, result1 instanceof Integer);
        Integer result2 = tictactoeboard4.getRandomEmpty();
        assertEquals(true, result2 instanceof Integer);
        Integer result3 = tictactoeboard5.getRandomEmpty();
        assertEquals(true, result3 instanceof Integer);
    }
}