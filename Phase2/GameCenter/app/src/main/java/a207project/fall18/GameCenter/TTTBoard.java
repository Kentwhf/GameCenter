package a207project.fall18.GameCenter;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TTTBoard {

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
     * @param  dim
     */
    TTTBoard(int dim) {
        this.dim = dim;
        this.board = new int[dim][dim];

        board_tile = new TreeSet<>();
        for (int i = 0; i < Math.pow(dim, 2); i++) {
            board_tile.add(i);
        }
    }

    /**
     * Check The move or not.
     * @para fieldIdx.
     * @para player.
     */
    public boolean move(int fieldIdx, @Game.FieldValue int player) {
        int row = fieldIdx / dim;
        int col = fieldIdx % dim;

        if (board[row][col] == 0) {
            board[row][col] = player;
            board_tile.remove(fieldIdx);

            return true;
        }

        return false;
    }

    boolean isFull() {
        return board_tile.isEmpty();
    }

    int getRandomEmpty() {
        int rnd = new Random().nextInt(dim * dim);
        Integer v = ((TreeSet<Integer>)board_tile).ceiling(rnd);

        if (v == null) {
            v = ((TreeSet<Integer>)board_tile).floor(rnd);
        }

        return v == null ? -1 : v;
    }


}
