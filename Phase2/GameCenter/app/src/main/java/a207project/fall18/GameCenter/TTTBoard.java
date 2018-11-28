package a207project.fall18.GameCenter;

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
    private Set<Integer> vacant;

    /**
     * The tic tac toe board.
     * @param  dim
     */
    TTTBoard(int dim) {
        this.dim = dim;
        this.board = new int[dim][dim];

        vacant = new TreeSet<>();
        for (int i = 0; i < Math.pow(dim, 2); i++) {
            vacant.add(i);
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
            vacant.remove(fieldIdx);

            return true;
        }

        return false;
    }

    boolean isFull() {
        return vacant.isEmpty();
    }

}
