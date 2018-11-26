package a207project.fall18.GameCenter;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import static java.security.AccessController.getContext;

/**
 *
 */

public class SudokuGameActivity extends AppCompatActivity implements CellGroupFragment.OnFragmentInteractionListener, Observer {
    private final String TAG = "GameActivity";
    private TextView clickedCell;
    private int clickedGroup;
    private int clickedCellId;
    private SudokuBoard startBoard;
    private SudokuBoard currentBoard;
    int cellGroupFragments[] = new int[]{R.id.cellGroupFragment, R.id.cellGroupFragment2,
            R.id.cellGroupFragment3, R.id.cellGroupFragment4, R.id.cellGroupFragment5,
            R.id.cellGroupFragment6, R.id.cellGroupFragment7, R.id.cellGroupFragment8, R.id.cellGroupFragment9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_game);

        int difficulty = getIntent().getIntExtra("difficulty", 0);
        ArrayList<SudokuBoard> boards = readGameBoards(difficulty);

        startBoard = chooseRandomBoard(boards);
        currentBoard = new SudokuBoard();
        currentBoard.addObserver(this);
        currentBoard.copyValues(startBoard.getGameCells());
        updateCells();

//        int cellGroupFragments[] = new int[]{R.id.cellGroupFragment, R.id.cellGroupFragment2,
//                R.id.cellGroupFragment3, R.id.cellGroupFragment4, R.id.cellGroupFragment5,
//                R.id.cellGroupFragment6, R.id.cellGroupFragment7, R.id.cellGroupFragment8, R.id.cellGroupFragment9};
////        Comment to see if we actually need this.
//        for (int i = 0; i < 9; i++) {
//            CellGroupFragment thisCellGroupFragment = (CellGroupFragment) getSupportFragmentManager().findFragmentById(cellGroupFragments[i]);
//            thisCellGroupFragment.setGroupId(i+1);
//        }
//
//        //Appear all values from the current board
//        CellGroupFragment tempCellGroupFragment;
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                int column = j / 3;
//                int row = i / 3;
//
//                int fragmentNumber = (row * 3) + column;
//                tempCellGroupFragment = (CellGroupFragment) getSupportFragmentManager().findFragmentById(cellGroupFragments[fragmentNumber]);
//
//                int groupColumn = j % 3;
//                int groupRow = i % 3;
//                int groupPosition = (groupRow * 3) + groupColumn;
//                int currentValue = currentBoard.getValue(i, j);
//
//                if (currentValue != 0) {
//                    tempCellGroupFragment.setValue(groupPosition, currentValue);
//                }
//            }
//        }
    }

    private void updateCells(){
//        int cellGroupFragments[] = new int[]{R.id.cellGroupFragment, R.id.cellGroupFragment2,
//                R.id.cellGroupFragment3, R.id.cellGroupFragment4, R.id.cellGroupFragment5,
//                R.id.cellGroupFragment6, R.id.cellGroupFragment7, R.id.cellGroupFragment8, R.id.cellGroupFragment9};

        for (int i = 0; i < 9; i++) {
            CellGroupFragment thisCellGroupFragment = (CellGroupFragment) getSupportFragmentManager().findFragmentById(cellGroupFragments[i]);
            thisCellGroupFragment.setGroupId(i+1);
    }

        //Appear all values from the current board
        CellGroupFragment tempCellGroupFragment;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int column = j / 3;
                int row = i / 3;

                int fragmentNumber = (row * 3) + column;
                tempCellGroupFragment = (CellGroupFragment) getSupportFragmentManager().findFragmentById(cellGroupFragments[fragmentNumber]);

                int groupColumn = j % 3;
                int groupRow = i % 3;
                int groupPosition = (groupRow * 3) + groupColumn;
                int currentValue = currentBoard.getValue(i, j); //Notice

                if (currentValue != 0) {
                    if (currentValue != startBoard.getValue(i, j)) {
                        tempCellGroupFragment.markInput(groupPosition, currentValue, currentBoard.checkDupulicate(i, j));
                    } else {tempCellGroupFragment.setValue(groupPosition, currentValue);}
                }
            }
        }

    }


    @Override
    public void onResume(){
        super.onResume();

    }

    //Generalize a random board to start with
    private ArrayList<SudokuBoard> readGameBoards(int difficulty) {
        ArrayList<SudokuBoard> boards = new ArrayList<>();
        int fileId;
        if (difficulty == 1) {
            fileId = R.raw.normal;
        } else if (difficulty == 0) {
            fileId = R.raw.easy;
        } else {
            fileId = R.raw.hard;
        }

//        InputStream inputStream = getResources().openRawResource(fileId);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        try {
//            String line = bufferedReader.readLine();
//            while (line != null) {
//                SudokuBoard board = new SudokuBoard();
//                // read all lines in the board and set values in the board.\
//
//                for (int i = 0; i < 9; i++) {
//                    String rowCells[] = line.split(" ");
//                    for (int j = 0; j < 9; j++) {
//                        if (rowCells[j].equals("-")) {
//                            board.setValue(i, j, 0);
//                        } else {
//                            board.setValue(i, j, Integer.parseInt(rowCells[j]));
//                        }
//                    }
//                    line = bufferedReader.readLine();
//                }
//                boards.add(board);
//                line = bufferedReader.readLine();
//            }
//            bufferedReader.close();
//        } catch (IOException e) {
//            Log.e(TAG, e.getMessage());
//        }

//        //reading from internal storage (/data/data/<package-name>/files)
//        String fileName = "boards-";
//        if (difficulty == 0) {
//            fileName += "easy";
//        } else if (difficulty == 1) {
//            fileName += "normal";
//        } else {
//            fileName += "hard";
//        }
//
//        FileInputStream fileInputStream;
//        try {
//            fileInputStream = this.openFileInput(fileName);
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//            BufferedReader internalBufferedReader = new BufferedReader(inputStreamReader);
//            // Rremove redundant initializer
//            internalBufferedReader.readLine();
//            String line = internalBufferedReader.readLine();
//            while (line != null) {
//                SudokuBoard board = new SudokuBoard();
//                // read all lines in the board
//                for (int i = 0; i < 9; i++) {
//                    String rowCells[] = line.split(" ");
//                    for (int j = 0; j < 9; j++) {
//                        if (rowCells[j].equals("-")) {
//                            board.setValue(i, j, 0);
//                        } else {
//                            board.setValue(i, j, Integer.parseInt(rowCells[j]));
//                        }
//                    }
//                    line = internalBufferedReader.readLine();
//                    if (line == null) {
//                        break;
//                    }
//                }
//                boards.add(board);
//                line = internalBufferedReader.readLine();
//            }
//            internalBufferedReader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        filereader(fileId, boards);
        return boards;
    }

    private void filereader(int fileId, ArrayList<SudokuBoard> boards){
        InputStream inputStream = getResources().openRawResource(fileId);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                SudokuBoard board = new SudokuBoard();
                // read all lines in the board and set values in the board.\

                for (int i = 0; i < 9; i++) {
                    String rowCells[] = line.split(" ");
                    for (int j = 0; j < 9; j++) {
                        if (rowCells[j].equals("-")) {
                            board.setValue(i, j, 0);
                        } else {
                            board.setValue(i, j, Integer.parseInt(rowCells[j]));
                        }
                    }
                    line = bufferedReader.readLine();
                }
                boards.add(board);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
    };

    private SudokuBoard chooseRandomBoard(ArrayList<SudokuBoard> boards) {
        int randomNumber = (int) (Math.random() * boards.size());
        return boards.get(randomNumber);
    }

    private boolean isStartPiece(int group, int cell) {
        int row = ((group-1)/3)*3 + (cell/3);
        int column = ((group-1)%3)*3 + ((cell)%3);
        return startBoard.getValue(row, column) != 0;
    }

    private boolean checkAllGroups() {
        int cellGroupFragments[] = new int[]{R.id.cellGroupFragment, R.id.cellGroupFragment2, R.id.cellGroupFragment3, R.id.cellGroupFragment4,
                R.id.cellGroupFragment5, R.id.cellGroupFragment6, R.id.cellGroupFragment7, R.id.cellGroupFragment8, R.id.cellGroupFragment9};
        for (int i = 0; i < 9; i++) {
            CellGroupFragment thisCellGroupFragment = (CellGroupFragment) getSupportFragmentManager().findFragmentById(cellGroupFragments[i]);
            assert thisCellGroupFragment != null;
            if (!thisCellGroupFragment.checkGroupCorrect()) {
                return false;
            }
        }
        return true;
    }

    // Change it to real time interface. Checking if puzzle's been solve . Potentially observable
    public void onCheckBoardButtonClicked(View view) {
//        currentBoard.isBoardCorrect();
        if(checkAllGroups() && currentBoard.isBoardCorrect()) {
            Toast.makeText(this, getString(R.string.board_correct), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.board_incorrect), Toast.LENGTH_SHORT).show();
        }
    }

    public void onGoBackButtonClicked(View view) {
        finish();
    }

    public void onShowInstructionsButtonClicked(View view) {
        Intent intent = new Intent( this, SudokuInstructionsActivity.class);
        startActivity(intent);
    }

//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//    @Override
//    // Method for current page to get some results from ChooseNumberActivity
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 1 && resultCode == RESULT_OK) {
//            int row = ((clickedGroup-1)/3)*3 + (clickedCellId/3);
//            int column = ((clickedGroup-1)%3)*3 + ((clickedCellId)%3);
//
//            Button buttonCheckBoard = findViewById(R.id.buttonCheckBoard);
//            if (data.getBooleanExtra("removePiece", false)) {
//                clickedCell.setText("");
//                clickedCell.setBackground(getResources().getDrawable(R.drawable.table_border_cell));
//                currentBoard.setValue(row, column, 0);
//                buttonCheckBoard.setVisibility(View.INVISIBLE);
//            } else {
//                int number = data.getIntExtra("chosenNumber", 1);
//                clickedCell.setText(String.valueOf(number));
//                currentBoard.setValue(row, column, number);
//
//                boolean isUnsure = data.getBooleanExtra("isUnsure", false);
//                if (isUnsure) {
//                    clickedCell.setBackground(getResources().getDrawable(R.drawable.table_border_cell_unsure));
//                } else {
//                    clickedCell.setBackground(getResources().getDrawable(R.drawable.table_border_cell));
//                }
//
//                if (currentBoard.isBoardFull()) {
//                    buttonCheckBoard.setVisibility(View.VISIBLE);
//                } else {
//                    buttonCheckBoard.setVisibility(View.INVISIBLE);
//                }
//            }
//        }
//    }

    @Override
    public void onFragmentInteraction(int groupId, int cellId, View view) {
        clickedCell = (TextView) view;
        clickedGroup = groupId;
        clickedCellId = cellId;
        Log.i(TAG, "Clicked group " + groupId + ", cell " + cellId);
        if (!isStartPiece(groupId, cellId)) {
//            Intent intent = new Intent(this, SudokuChooseNumberActivity.class);
//            startActivityForResult(intent, 1);

            int row = ((clickedGroup-1)/3)*3 + (clickedCellId/3);
            int column = ((clickedGroup-1)%3)*3 + ((clickedCellId)%3);
            KeyPadDialog keyPadDialog = new KeyPadDialog(this, currentBoard, new KeyPadDialog.PriorityListener() {
                @Override
                public void refreshPriorityUI(String string) {
                    currentBoard.setValue(row, column, Integer.parseInt(string));
//                    clickedCell.setText(String.valueOf(string));
//                    updateCells();
                }
            } );
            keyPadDialog.show();



//            int number = .getIntExtra("chosenNumber", 1);
//            clickedCell.setText(String.valueOf(number));
//            currentBoard.setValue(row, column, number);
//            currentBoard = KeyPadDialog.getNewSudokuBoard();
        } else {
            Toast.makeText(this, getString(R.string.start_piece_error), Toast.LENGTH_SHORT).show();
        }
    }





    @Override
    public void update(Observable o, Object arg) {
        updateCells();
    }


//    @Override
//    public void update(Observable o, Object arg) {
//        currentBoard = currentBoard.updateBoard();
//    }
}
