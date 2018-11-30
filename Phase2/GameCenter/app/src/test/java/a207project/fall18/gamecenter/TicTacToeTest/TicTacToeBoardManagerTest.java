package a207project.fall18.gamecenter.TicTacToeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import a207project.fall18.GameCenter.BoardManager;
import a207project.fall18.GameCenter.TicTacToeBoard;
import a207project.fall18.GameCenter.TicTacToeBoardManager;

import static org.junit.Assert.*;

public class TicTacToeBoardManagerTest extends BoardManager {
    private TicTacToeBoardManager tictactoeboardmanager1;
    private TicTacToeBoardManager tictactoeboardmanager2;
    private TicTacToeBoardManager tictactoeboardmanager3;
    private int[][] board;
    private Set<Integer> board_tile;

//    public TicTacToeBoardManagerTest(int[][] board, Set<Integer> board_tile) {
//        this.board = board;
//        this.board_tile = board_tile;
//    }

    @Before
    public void setUp() throws Exception {
        tictactoeboardmanager1 = new TicTacToeBoardManager(3);
//        tictactoeboardmanager2 = new TicTacToeBoardManager(4);
//        tictactoeboardmanager3 = new TicTacToeBoardManager(5);
    }

    @After
    public void tearDown() throws Exception {
        tictactoeboardmanager1 = null;
//        tictactoeboardmanager2 = null;
//        tictactoeboardmanager3 = null;
    }

    @Test
    public void getTicTacToeBoard() {
//        for (int i = 0; i < 3 * 3; i++) {
//            board_tile.add(i);}
        TicTacToeBoard tictactoeboard = new TicTacToeBoard(3);
        assertEquals(tictactoeboard, tictactoeboardmanager1.getBoard());
    }




    @Test
    public void move() {
    }

    @Test
    public void getMove() {
    }

    @Test
    public void switchAI() {
    }
}