package a207project.fall18.GameCenter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import a207project.fall18.GameCenter.KeypadDialog;

/**
 * Sodoku game activity
 */

public class SudokuGameActivity extends AppCompatActivity implements TileGroupFragment.OnFragmentInteractionListener, Observer {
    private final String TAG = "SlidingTilesGameActivity";
//    private TextView clickedCell;
//    private int clickedGroup;
//    private int clickedCellId;
    private TimerTextView timerTextView;
    private SudokuBoardManager startBoardManager;
    private SudokuBoardManager currentBoardManager;
    int cellGroupFragments[] = new int[]{R.id.cellGroupFragment, R.id.cellGroupFragment2,
            R.id.cellGroupFragment3, R.id.cellGroupFragment4, R.id.cellGroupFragment5,
            R.id.cellGroupFragment6, R.id.cellGroupFragment7, R.id.cellGroupFragment8, R.id.cellGroupFragment9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_game);

        int difficulty = getIntent().getIntExtra("difficulty", 0);
        ArrayList<SudokuBoardManager> boards = readGameBoards(difficulty);

        startBoardManager = chooseRandomBoard(boards);
        currentBoardManager = new SudokuBoardManager();
        currentBoardManager.setSudokuBoard(new SudokuBoard());
        currentBoardManager.getBoard().addObserver(this);
        currentBoardManager.copyValues(startBoardManager.getBoard());
        updateTiles();

        TimerTextView timerTextView =  (TimerTextView) findViewById(R.id.timer);
        timerTextView.setStartTime(System.currentTimeMillis());
        timerTextView.startTimer();


//        int cellGroupFragments[] = new int[]{R.id.cellGroupFragment, R.id.cellGroupFragment2,
//                R.id.cellGroupFragment3, R.id.cellGroupFragment4, R.id.cellGroupFragment5,
//                R.id.cellGroupFragment6, R.id.cellGroupFragment7, R.id.cellGroupFragment8, R.id.cellGroupFragment9};
////        Comment to see if we actually need this.
//        for (int i = 0; i < 9; i++) {
//            TileGroupFragment thisCellGroupFragment = (TileGroupFragment) getSupportFragmentManager().findFragmentById(cellGroupFragments[i]);
//            thisCellGroupFragment.setGroupId(i+1);
//        }
//
//        //Appear all values from the current tiles
//        TileGroupFragment tempCellGroupFragment;
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                int column = j / 3;
//                int row = i / 3;
//
//                int fragmentNumber = (row * 3) + column;
//                tempCellGroupFragment = (TileGroupFragment) getSupportFragmentManager().findFragmentById(cellGroupFragments[fragmentNumber]);
//
//                int groupColumn = j % 3;
//                int groupRow = i % 3;
//                int groupPosition = (groupRow * 3) + groupColumn;
//                int currentValue = currentBoardManager.getTile(i, j);
//
//                if (currentValue != 0) {
//                    tempCellGroupFragment.setTile(groupPosition, currentValue);
//                }
//            }
//        }
    }

    /**
     * Updates the Sudoku tiles
     */
    private void updateTiles(){
//        int cellGroupFragments[] = new int[]{R.id.cellGroupFragment, R.id.cellGroupFragment2,
//                R.id.cellGroupFragment3, R.id.cellGroupFragment4, R.id.cellGroupFragment5,
//                R.id.cellGroupFragment6, R.id.cellGroupFragment7, R.id.cellGroupFragment8, R.id.cellGroupFragment9};

        for (int i = 0; i < 9; i++) {
            TileGroupFragment thisTileGroupFragment = (TileGroupFragment) getSupportFragmentManager().findFragmentById(cellGroupFragments[i]);
            thisTileGroupFragment.setGroupId(i+1);
    }

        //Appear all values from the current tiles
        TileGroupFragment tempTileGroupFragment;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int column = j / 3;
                int row = i / 3;

                int fragmentNumber = (row * 3) + column;
                tempTileGroupFragment = (TileGroupFragment) getSupportFragmentManager().findFragmentById(cellGroupFragments[fragmentNumber]);

                int groupColumn = j % 3;
                int groupRow = i % 3;
                int groupPosition = (groupRow * 3) + groupColumn;
                int currentValue = currentBoardManager.getBoard().getTile(i,j); //Notice

                    if (currentValue != startBoardManager.getBoard().getTile(i,j)) {
                        tempTileGroupFragment.markInput(groupPosition, currentValue, currentBoardManager.checkDupulicate(i, j));
                    } else {
                        tempTileGroupFragment.setValue(groupPosition, currentValue);}

            }
        }

    }


//    @Override
//    public void onResume(){
//        super.onResume();
//        if (currentBoardManager.isBoardCorrect()) {
//            timerTextView.stopTimer();
//            String duration = timerTextView.getDurationBreakdown(System.currentTimeMillis() - timerTextView.getStartTime());
//        }
//
//    }

    /**
     * @param difficulty an int that represents the difficulty of the game
     * @return an array list of SudokuBoardManagers with the same difficulty
     */
    //Generalize a random tiles to start with
    private ArrayList<SudokuBoardManager> readGameBoards(int difficulty) {
        ArrayList<SudokuBoardManager> boards = new ArrayList<>();
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
//                SudokuBoardManager tiles = new SudokuBoardManager();
//                // read all lines in the tiles and set values in the tiles.\
//
//                for (int i = 0; i < 9; i++) {
//                    String rowCells[] = line.split(" ");
//                    for (int j = 0; j < 9; j++) {
//                        if (rowCells[j].equals("-")) {
//                            tiles.setTile(i, j, 0);
//                        } else {
//                            tiles.setTile(i, j, Integer.parseInt(rowCells[j]));
//                        }
//                    }
//                    line = bufferedReader.readLine();
//                }
//                boards.add(tiles);
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
//                SudokuBoardManager tiles = new SudokuBoardManager();
//                // read all lines in the tiles
//                for (int i = 0; i < 9; i++) {
//                    String rowCells[] = line.split(" ");
//                    for (int j = 0; j < 9; j++) {
//                        if (rowCells[j].equals("-")) {
//                            tiles.setTile(i, j, 0);
//                        } else {
//                            tiles.setTile(i, j, Integer.parseInt(rowCells[j]));
//                        }
//                    }
//                    line = internalBufferedReader.readLine();
//                    if (line == null) {
//                        break;
//                    }
//                }
//                boards.add(tiles);
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

    /**
     * @param fileId an int that represents the R file at certain difficulty
     * @param boards an array list of Sudoku Boards that are able to be displayed
     */
    @SuppressLint("LongLogTag")
    private void filereader(int fileId, ArrayList<SudokuBoardManager> boards){
        InputStream inputStream = getResources().openRawResource(fileId);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                SudokuBoardManager boardmanager = new SudokuBoardManager();
                boardmanager.setSudokuBoard(new SudokuBoard());
                // read all lines in the tiles and set values in the tiles.\

                for (int i = 0; i < 9; i++) {
                    String rowCells[] = line.split(" ");
                    for (int j = 0; j < 9; j++) {
                        if (rowCells[j].equals("-")) {
                            boardmanager.getBoard().setTile(i, j, 0);
                        } else {
                            boardmanager.getBoard().setTile(i, j, Integer.parseInt(rowCells[j]));
                        }
                    }
                    line = bufferedReader.readLine();
                }
                boards.add(boardmanager);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    /**
     * @param boards an array list of SudokuBoardManagers
     * @return an randomly selected a207project.fall18.GameCenter.SudokuBoard
     */
    private SudokuBoardManager chooseRandomBoard(ArrayList<SudokuBoardManager> boards) {
        int randomNumber = (int) (Math.random() * boards.size());
        return boards.get(randomNumber);
    }


    /**
     * @param group a selected group
     * @param cell a selected cell
     * @return if the selected is a starting piece
     */
    private boolean isStartPiece(int group, int cell) {
        int row = ((group-1)/3)*3 + (cell/3);
        int column = ((group-1)%3)*3 + ((cell)%3);
        return startBoardManager.getBoard().getTile(row, column) != 0;
    }


    /**
     * @return if layout TileGroupFragment has correct groups
     */
    // check if we actually need this method
    private boolean checkAllGroups() {
//        int cellGroupFragments[] = new int[]{R.id.cellGroupFragment, R.id.cellGroupFragment2, R.id.cellGroupFragment3, R.id.cellGroupFragment4,
//                R.id.cellGroupFragment5, R.id.cellGroupFragment6, R.id.cellGroupFragment7, R.id.cellGroupFragment8, R.id.cellGroupFragment9};
        for (int i = 0; i < 9; i++) {
            TileGroupFragment thisTileGroupFragment = (TileGroupFragment) getSupportFragmentManager().findFragmentById(cellGroupFragments[i]);
            assert thisTileGroupFragment != null;
            if (!thisTileGroupFragment.checkGroupCorrect()) {
                return false;
            }
        }
        return true;
    }

    // Change it to real time interface. Checking if puzzle's been solve . Potentially observable
    public void onCheckBoardButtonClicked(View view) {
//        currentBoardManager.isBoardCorrect();
        if(checkAllGroups() && currentBoardManager.isBoardCorrect()) {
            Toast.makeText(this, getString(R.string.board_correct), Toast.LENGTH_SHORT).show();
            timerTextView.stopTimer();
            String duration = timerTextView.getDurationBreakdown(System.currentTimeMillis() - timerTextView.getStartTime());
            // Pass value to the model
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
//                currentBoardManager.setTile(row, column, 0);
//                buttonCheckBoard.setVisibility(View.INVISIBLE);
//            } else {
//                int number = data.getIntExtra("chosenNumber", 1);
//                clickedCell.setText(String.valueOf(number));
//                currentBoardManager.setTile(row, column, number);
//
//                boolean isUnsure = data.getBooleanExtra("isUnsure", false);
//                if (isUnsure) {
//                    clickedCell.setBackground(getResources().getDrawable(R.drawable.table_border_cell_unsure));
//                } else {
//                    clickedCell.setBackground(getResources().getDrawable(R.drawable.table_border_cell));
//                }
//
//                if (currentBoardManager.isBoardFull()) {
//                    buttonCheckBoard.setVisibility(View.VISIBLE);
//                } else {
//                    buttonCheckBoard.setVisibility(View.INVISIBLE);
//                }
//            }
//        }
//    }

    @SuppressLint("LongLogTag")
    @Override
    public void onFragmentInteraction(int groupId, int cellId, View view) {
        TextView clickedCell = (TextView) view;
        int clickedGroup = groupId;
        int clickedCellId = cellId;
        Log.i(TAG, "Clicked group " + groupId + ", cell " + cellId);
        if (!isStartPiece(groupId, cellId)) {
//            Intent intent = new Intent(this, SudokuChooseNumberActivity.class);
//            startActivityForResult(intent, 1);

            int row = ((clickedGroup-1)/3)*3 + (clickedCellId/3);
            int column = ((clickedGroup-1)%3)*3 + ((clickedCellId)%3);
            KeypadDialog keypadDialog = new KeypadDialog(this, new KeypadDialog.PriorityListener() {
                @Override
                public void refreshPriorityUI(String string) {
                    currentBoardManager.getBoard().setTile(row, column, (int)Integer.parseInt(string));

                }
            } );
            keypadDialog.show();



//            int number = .getIntExtra("chosenNumber", 1);
//            clickedCell.setText(String.valueOf(number));
//            currentBoardManager.setTile(row, column, number);
//            currentBoardManager = KeypadDialog.getNewSudokuBoardManager();
        } else {
            Toast.makeText(this, getString(R.string.start_piece_error), Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    public void update(Observable o, Object arg) {
        updateTiles();
    }


//    @Override
//    public void update(Observable o, Object arg) {
//        currentBoardManager = currentBoardManager.updateBoard();
//    }
}
