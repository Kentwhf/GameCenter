package a207project.fall18.GameCenter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import a207project.fall18.GameCenter.dao.SaveDao;

/**
 * The game activity.
 */
public class SlidingTilesGameActivity extends AppCompatActivity implements Observer, Serializable {

    private SaveDao savingManager;

    /**
     * The board manager.
     */
    private SlidingTilesBoardManager boardManager;

    /**
     * The buttons to display.
     */
    private ArrayList<Button> tileButtons;

    /**
     * Constants for swiping directions. Should be an enum, probably.
     */
//    public static final int UP = 1;
//    public static final int DOWN = 2;
//    public static final int LEFT = 3;
//    public static final int RIGHT = 4;

    // Grid View and calculated column height and width based on device size
    private SlidingTilesGestureDetectGridView gridView;
    private static int columnWidth, columnHeight;

    /**
     * Set up the background image for each button based on the master list
     * of positions, and then call the adapter to set the view.
     */
    // Display
    public void display() {
        updateTileButtons();
        gridView.setAdapter(new CustomAdapter(tileButtons, columnWidth, columnHeight));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boardManager = (SlidingTilesBoardManager) MyApplication.getInstance().getBoardManager();
//        loadFromFile(SlidingTilesStartingActivity.TEMP_SAVE_FILENAME);
        createTileButtons(this);
        setContentView(R.layout.activity_sliding_tiles_game);
        addUndoButtonListener();

        savingManager = MyApplication.getInstance().getSavingManager();



        // Add View to activity
        gridView = findViewById(R.id.grid);
        gridView.setNumColumns(SlidingTilesBoard.NUM_COLS);
        gridView.setSlidingTilesBoardManager(boardManager);
        boardManager.getSlidingTilesBoard().addObserver(this);
        // Observer sets up desired dimensions as well as calls our display function
        gridView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onGlobalLayout() {
                        gridView.getViewTreeObserver().removeOnGlobalLayoutListener(
                                this);
                        int displayWidth = gridView.getMeasuredWidth();
                        int displayHeight = gridView.getMeasuredHeight();

                        columnWidth = displayWidth / SlidingTilesBoard.NUM_COLS;
                        columnHeight = displayHeight / SlidingTilesBoard.NUM_ROWS;

                        display();
                    }
                });
    }

    private void addUndoButtonListener() {
        Button undoButton = findViewById(R.id.undo);
//        undoButton.setOnClickListener((View.OnClickListener) SlidingTileBoardManager.undo());
        undoButton.setOnClickListener((v) -> {
            if (this.boardManager.undo()) {
//                this.boardManager.undo();
                updateTileButtons();
                gridView = findViewById(R.id.grid);
                gridView.setNumColumns(SlidingTilesBoard.NUM_COLS);
                gridView.setSlidingTilesBoardManager(boardManager);
                boardManager.getSlidingTilesBoard().addObserver(this);
                display();
            }
            else{
                Toast.makeText(SlidingTilesGameActivity.this,"No More Undo chance！",Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * Create the buttons for displaying the tiles.
     *
     * @param context the context
     */
    private void createTileButtons(Context context) {
        SlidingTilesBoard board = boardManager.getSlidingTilesBoard();
        tileButtons = new ArrayList<>();
        for (int row = 0; row != SlidingTilesBoard.NUM_ROWS; row++) {
            for (int col = 0; col != SlidingTilesBoard.NUM_COLS; col++) {
                Button tmp = new Button(context);
                tmp.setBackgroundResource(board.getTile(row, col).getBackground());
                this.tileButtons.add(tmp);
            }
        }
    }

    /**
     * Update the backgrounds on the buttons to match the tiles.
     */
    private void updateTileButtons() {
        SlidingTilesBoard board = boardManager.getSlidingTilesBoard();
        int nextPos = 0;
        for (Button b : tileButtons) {
            int row = nextPos / SlidingTilesBoard.NUM_ROWS;
            int col = nextPos % SlidingTilesBoard.NUM_COLS;
            b.setBackgroundResource(board.getTile(row, col).getBackground());
            nextPos++;
        }

        // uncomment
        TextView scores = findViewById(R.id.Score);
        scores.setText("Scores : " + board.getCurrentscore());
        savingManager.autoSave(boardManager);
        boardManager.setScore();
//        saveToFile(SAVE_FILENAME);
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();

        boardManager.setScore();

//        MyApplication.getInstance().currentScore.setFinalScore(boardManager.getSlidingTilesBoard().getCurrentscore());
//        boardManager.setScore(MyApplication.getInstance().currentScore);


//        MyApplication.getInstance().setSlidingTileBoardManager( boardManager);
//        saveToFile(SlidingTilesStartingActivity.TEMP_SAVE_FILENAME);
    }

//    /**
//     * Load the board manager from fileName.
//     *
//     * @param fileName the name of the file
//     */
//    private void loadFromFile(String fileName) {
//
//        try {
//            InputStream inputStream = this.openFileInput(fileName);
//            if (inputStream != null) {
//                ObjectInputStream input = new ObjectInputStream(inputStream);
//                boardManager = (SlidingTileBoardManager) input.readObject();
//                inputStream.close();
//            }
//        } catch (FileNotFoundException e) {
//            Log.e("login activity", "File not found: " + e.toString());
//        } catch (IOException e) {
//            Log.e("login activity", "Can not read file: " + e.toString());
//        } catch (ClassNotFoundException e) {
//            Log.e("login activity", "File contained unexpected data type: " + e.toString());
//        }
//    }
//
//    /**
//     * Save the board manager to fileName.
//     *
//     * @param fileName the name of the file
//     */
//    public void saveToFile(String fileName) {
//        try {
//            ObjectOutputStream outputStream = new ObjectOutputStream(
//                    this.openFileOutput(fileName, MODE_PRIVATE));
//            outputStream.writeObject(boardManager);
//
//            outputStream.close();
//        } catch (IOException e) {
//            Log.e("Exception", "File write failed: " + e.toString());
//        }
//    }


    @Override
    public void update(Observable o, Object arg) {
        display();
    }
}