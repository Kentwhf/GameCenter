package a207project.fall18.GameCenter;

import java.io.Serializable;
import java.util.ArrayList;

import a207project.fall18.GameCenter.bean.Score;

/**
 * A a207project.fall18.GameCenter.sudokuBoard Manager
 */

class SudokuBoardManager extends BoardManager implements Serializable {

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    private SudokuBoard sudokuBoard;

    @Override
    public Score getScore() {
        return score;
    }

    private Score score;


    @Override
    public void setScore() {
//        this.score.setFinalScore(board.getCurrentScore());
        this.score.setUserId(MyApplication.getInstance().getUser().getId());
        this.score.setGameType(MyApplication.getInstance().getGame());
        this.score.setNickname(MyApplication.getInstance().getUser().getNickname());

    }

    /**
     * @return returnr a Sudoku Bard
     */
    public SudokuBoard getBoard() {
        return sudokuBoard;
    }


    /**
     * @param newBoard Copy a Sudoku Board
     */
    public void copyValues(SudokuBoard newBoard) {
        for (int i = 0; i < newBoard.getSlidingTiles().length; i++) {
            for (int j = 0; j < newBoard.getSlidingTiles()[i].length; j++) {
                sudokuBoard.getSlidingTiles()[i][j] = newBoard.getSlidingTiles()[i][j];
            }
        }
    }

    /**
     * @return return if the tiles is solved correctly
     */
    // Can be rafactored
    public boolean isBoardCorrect() {
        // Check horizontal and vertical
        for (int i = 0; i < sudokuBoard.getSlidingTiles().length; i++) {
            ArrayList<Integer> horizontals = new ArrayList<>();
            ArrayList<Integer> verticals = new ArrayList<>();
            for (int j = 0; j < sudokuBoard.getSlidingTiles()[i].length; j++) {
                int number1 = sudokuBoard.getSlidingTiles()[i][j];
                int number2 = sudokuBoard.getSlidingTiles()[j][i];
                if ((horizontals.contains(number1) && (verticals.contains(number2)))) {
                    return false;
                } else {
                    horizontals.add(number1);
                    verticals.add(number2);
                }
            }
        }
        return true;
    }


    /**
     * @param row row
     * @param column column
     * @return return if there are duplicates of numbers
     */
    public boolean checkDupulicate(int row, int column){
        ArrayList<Integer> horizontals = new ArrayList<>();
        ArrayList<Integer> verticals = new ArrayList<>();
        ArrayList<Integer> group = sudokuBoard.getTargetGroup(row,column);
        group.remove((Integer) sudokuBoard.getSlidingTiles()[row][column]);

        for (int i: sudokuBoard.getSlidingTiles()[row]) {horizontals.add(i);}
        horizontals.remove((Integer) sudokuBoard.getSlidingTiles()[row][column]);

        for (int i = 0; i < sudokuBoard.getSlidingTiles().length; i++) {verticals.add(
                sudokuBoard.getSlidingTiles()[i][column]);}
        verticals.remove((Integer) sudokuBoard.getSlidingTiles()[row][column]);

        return horizontals.contains(sudokuBoard.getSlidingTiles()[row][column]) ||
                verticals.contains(sudokuBoard.getSlidingTiles()[row][column]) ||
                group.contains(sudokuBoard.getSlidingTiles()[row][column]);
    }
}


