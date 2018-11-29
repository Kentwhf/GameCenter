package a207project.fall18.GameCenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

/**
 * A SudokuBoard Manager
 */

class SudokuBoard extends Observable {

    private int[][] gameCells = new int[9][9];


//    public SudokuBoard(){};

    /**
     * @param row row
     * @param column column
     * @param value value being set
     */
    public void setValue(int row, int column, int value) {
        gameCells[row][column] = value;
        setChanged();
        notifyObservers();
    }


    /**
     * @return returnr a Sudoku Bard
     */
    public int[][] getGameCells() {
        return gameCells;
    }


    /**
     * @param newGameCells Copy a Sudoku Bard
     */
    public void copyValues(int[][] newGameCells) {
        for (int i = 0; i < newGameCells.length; i++) {
            for (int j = 0; j < newGameCells[i].length; j++) {
                gameCells[i][j] = newGameCells[i][j];
            }
        }
    }

//    public boolean isBoardFull() {
//        for (int i = 0; i < gameCells.length; i++) {
//            for (int j = 0; j < gameCells[i].length; j++) {
//                if (gameCells[i][j] == 0) {
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
        for (int i = 0; i < gameCells.length; i++) {
            ArrayList<Integer> horizontals = new ArrayList<>();
            ArrayList<Integer> verticals = new ArrayList<>();
            for (int j = 0; j < gameCells[i].length; j++) {
                int number1 = gameCells[i][j];
                int number2 = gameCells[j][i];
                if ((horizontals.contains(number1) && (verticals.contains(number2)))) {
                    return false;
                } else {
                    horizontals.add(number1);
                    verticals.add(number2);
                }
            }
        }

//        // Check vertical
//        for (int i = 0; i < gameCells.length; i++) {
//            ArrayList<Integer> numbers = new ArrayList<>();
//            for (int j = 0; j < gameCells[i].length; j++) {
//                int number = gameCells[j][i];
//                if (numbers.contains(number)) {
//                    return false;
//                } else {
//                    numbers.add(number);
//                }
//            }
//        }

        // Check each group is in CellGroupFragment class for easier code
        // returns true if horizontal and vertical lines are correct
        return true;
    }


    /**
     * @param row row
     * @param column column
     * @return get the value at a given and a given column in the Sudoku Board
     */
    public int getValue(int row, int column) {
        return gameCells[row][column];
    }

//    public SudokuBoard updateBoard(){
//        return this;
//    }

//    @Override
//    public String toString() {
//        StringBuilder temp = new StringBuilder();
//        for (int i = 0; i < gameCells.length; i++) {
//            for (int j = 0; j < gameCells[i].length; j++) {
//                if (j == 0) {
//                    temp.append("\n");
//                }
//
//                int currentNumber = gameCells[i][j];
//                if (currentNumber == 0) {
//                    temp.append("-");
//                } else {
//                    temp.append(currentNumber);
//                }
//
//                if (j != (gameCells[i].length-1)) {
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
        ArrayList<Integer> group = getTargetGroup(row,column);
        group.remove((Integer)gameCells[row][column]);

        for (int i: gameCells[row]) {horizontals.add(i);}
        horizontals.remove((Integer)gameCells[row][column]);

        for (int i = 0; i < gameCells.length; i++) {verticals.add(gameCells[i][column]);}
        verticals.remove((Integer)gameCells[row][column]);

        return horizontals.contains(gameCells[row][column]) || verticals.contains(gameCells[row][column]) ||
                group.contains(gameCells[row][column]);
    }


    /**
     * @param row row
     * @param column column
     * @return return an array list of integers that are in specific cell group. The cell gorup includes
     * the cell at the given row and column
     */
    public ArrayList<Integer> getTargetGroup(int row, int column){

        int temp1 = row;
        int temp2 = column;

//        int temp1 = row % 3;
//        int temp2 = column % 3 ;

        if (temp1 % 3 == 0){temp1++;};
        if (temp1 % 3 == 2){temp1--;};
        if (temp2 % 3 == 0){temp2++;};
        if (temp2 % 3 == 2){temp2--;};


        return new ArrayList<>(Arrays.asList(gameCells[temp1][temp2], gameCells[temp1][temp2-1],gameCells[temp1][temp2+1],
                        gameCells[temp1+1][temp2], gameCells[temp1+1][temp2-1], gameCells[temp1+1][temp2+1],
                        gameCells[temp1-1][temp2], gameCells[temp1-1][temp2-1], gameCells[temp1-1][temp2+1]));
    }

}
