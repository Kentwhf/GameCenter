package a207project.fall18.GameCenter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A a207project.fall18.GameCenter.sudokuBoard Manager
 */

class SudokuBoardManager extends BoardManager{

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    private SudokuBoard sudokuBoard;


//    public a207project.fall18.GameCenter.sudokuBoard(){};


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
        for (int i = 0; i < newBoard.getTiles().length; i++) {
            for (int j = 0; j < newBoard.getTiles()[i].length; j++) {
                sudokuBoard.getTiles()[i][j] = newBoard.getTiles()[i][j];
            }
        }
    }

//    public boolean isBoardFull() {
//        for (int i = 0; i < a207project.fall18.GameCenter.sudokuBoard.length; i++) {
//            for (int j = 0; j < a207project.fall18.GameCenter.sudokuBoard.getTiles()[i].length; j++) {
//                if (a207project.fall18.GameCenter.sudokuBoard.getTiles()[i][j] == 0) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    /**
     * @return return if the board is solved correctly
     */
    // Can be rafactored
    public boolean isBoardCorrect() {
        // Check horizontal and vertical
        for (int i = 0; i < sudokuBoard.getTiles().length; i++) {
            ArrayList<Integer> horizontals = new ArrayList<>();
            ArrayList<Integer> verticals = new ArrayList<>();
            for (int j = 0; j < sudokuBoard.getTiles()[i].length; j++) {
                int number1 = sudokuBoard.getTiles()[i][j];
                int number2 = sudokuBoard.getTiles()[j][i];
                if ((horizontals.contains(number1) && (verticals.contains(number2)))) {
                    return false;
                } else {
                    horizontals.add(number1);
                    verticals.add(number2);
                }
            }
        }

//        // Check vertical
//        for (int i = 0; i < a207project.fall18.GameCenter.sudokuBoard.length; i++) {
//            ArrayList<Integer> numbers = new ArrayList<>();
//            for (int j = 0; j < a207project.fall18.GameCenter.sudokuBoard.getTiles()[i].length; j++) {
//                int number = a207project.fall18.GameCenter.sudokuBoard.getTiles()[j][i];
//                if (numbers.contains(number)) {
//                    return false;
//                } else {
//                    numbers.add(number);
//                }
//            }
//        }

        // Check each group is in TileGroupFragment class for easier code
        // returns true if horizontal and vertical lines are correct
        return true;
    }




//    public a207project.fall18.GameCenter.sudokuBoard updateBoard(){
//        return this;
//    }

//    @Override
//    public String toString() {
//        StringBuilder temp = new StringBuilder();
//        for (int i = 0; i < a207project.fall18.GameCenter.sudokuBoard.length; i++) {
//            for (int j = 0; j < a207project.fall18.GameCenter.sudokuBoard.getTiles()[i].length; j++) {
//                if (j == 0) {
//                    temp.append("\n");
//                }
//
//                int currentNumber = a207project.fall18.GameCenter.sudokuBoard.getTiles()[i][j];
//                if (currentNumber == 0) {
//                    temp.append("-");
//                } else {
//                    temp.append(currentNumber);
//                }
//
//                if (j != (a207project.fall18.GameCenter.sudokuBoard.getTiles()[i].length-1)) {
//                    temp.append(" ");
//                }
//            }
//        }
//        return temp.toString();
//    }


    /**
     * @param row row
     * @param column column
     * @return return if there are duplicates of numbers
     */
    public boolean checkDupulicate(int row, int column){
        ArrayList<Integer> horizontals = new ArrayList<>();
        ArrayList<Integer> verticals = new ArrayList<>();
        ArrayList<Integer> group = sudokuBoard.getTargetGroup(row,column);
        group.remove((Integer) sudokuBoard.getTiles()[row][column]);

        for (int i: sudokuBoard.getTiles()[row]) {horizontals.add(i);}
        horizontals.remove((Integer) sudokuBoard.getTiles()[row][column]);

        for (int i = 0; i < sudokuBoard.getTiles().length; i++) {verticals.add(sudokuBoard.getTiles()[i][column]);}
        verticals.remove((Integer) sudokuBoard.getTiles()[row][column]);

        return horizontals.contains(sudokuBoard.getTiles()[row][column]) || verticals.contains(sudokuBoard.getTiles()[row][column]) ||
                group.contains(sudokuBoard.getTiles()[row][column]);
    }
}


