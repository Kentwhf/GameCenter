package a207project.fall18.GameCenter;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * TicTacToe Board class
 */
public class TicTacToeBoard extends Board{

    /**
     * The int dim.
     */
    static int dim;
    /**
     * The board which is consisted by col and row.
     */
    private int[][] board;
    private Set<Integer> board_tile;

    /**
     * The tic tac toe board.
     * @param  dim the dimension of the board
     */
    TicTacToeBoard(int dim) {
        this.dim = dim;
        this.board = new int[dim][dim];

        board_tile = new TreeSet<>();
        for (int i = 0; i < Math.pow(dim, 2); i++) {
            board_tile.add(i);
        }
    }

    /**
     * Check move or not, if can move, change the tile as the player.
     * @param fieldIdx  Index of the tile of tictactoe.
     * @param player the player.
     * @return whether to move.
     */
    public boolean move(int fieldIdx,  int player) {
        int row = fieldIdx / dim;
        int col = fieldIdx % dim;

        if (board[row][col] == 0) {
            board[row][col] = player;
            board_tile.remove(fieldIdx);

            return true;
        }

        return false;
    }

    /**
     * check the tile of board is full or not.
     * @return whether the tile of board is full or not.
     */
    boolean isFull() {
        return board_tile.isEmpty();
    }

    /**
     * get a random index of random tile which can be move.
     * @return  a random index of random tile which can be move.
     */
    int getRandomEmpty() {
        int num = new Random().nextInt(dim * dim);
        Integer i = ((TreeSet<Integer>)board_tile).ceiling(num);

        if (i == null) {
            i = ((TreeSet<Integer>)board_tile).floor(num);
        }

        return i == null ? -1 : i;
    }
}
