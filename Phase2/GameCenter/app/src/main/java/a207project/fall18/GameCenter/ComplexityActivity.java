package a207project.fall18.GameCenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import a207project.fall18.GameCenter.dao.SaveDao;

public class ComplexityActivity extends AppCompatActivity {

    private String game;

    private ComplexityController controller;

    private int undoTime = 3;

    private SaveDao savingManager;
    /**
     * The main save file.
     */
    public static final String SAVE_FILENAME = "save_file.ser";
    /**
     * A temporary save file.
     */
    public static final String TEMP_SAVE_FILENAME = "save_file_tmp.ser";
    /**
     * The tiles manager.
     */
//    private BoardManager boardManager;

    /**
     * Switch to game
     */
    private void switchToGame() {
        Intent tmp ;

//                new Intent(this, SlidingTilesGameActivity.class);
        MyApplication.getInstance().setBoardManager( controller.getBoardManager());
//        saveToFile(SlidingTilesStartingActivity.TEMP_SAVE_FILENAME);
        switch (game) {
            case "SlidingTiles":
                tmp = new Intent(this, SlidingTilesGameActivity.class);
                break;
            case "TicTacToe":
                tmp = new Intent(this, TicTacToeGameActivity.class);
                break;
            default:
                tmp = new Intent(this, SudokuGameActivity.class);
                break;
        }


        startActivity(tmp);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complexity);
        setTitle("Select difficulty");

        controller = new ComplexityController();
        game = MyApplication.getInstance().getGame();


        addEasyButtonListener();
        addIntermediateButtonListener();
        setupDifficultButton3Listener();
        setupConfirmButtonListener();

        savingManager = MyApplication.getInstance().getSavingManager();
    }

    // 使得只有是slidingtiles游戏时才出现set up undo button
    /**
     * Button for selecting number of undo moves
     */
    private void setupConfirmButtonListener(){
        Button button4  = findViewById(R.id.comfirmButton);

        if (game.equals("SlidingTiles")){
            button4.setVisibility(View.INVISIBLE);
        }

        button4.setOnClickListener((v) -> {
            TextView undoInputTextField = findViewById(R.id.undoInput);
            if (undoInputTextField != null){
                undoTime = Integer.parseInt(undoInputTextField.getText().toString());
                controller = new ComplexityController();
                controller.ConfirmUndoTime(undoTime);

            }
        });
    }

    /**
     * Easy version
     */
    private void addEasyButtonListener(){
        Button button1  = findViewById(R.id.button1);
        button1.setOnClickListener((v) -> {
           controller.Easy();
            switchToGame();
    });
    }

    /**
     * Intermediate version
     */
    private void addIntermediateButtonListener(){
        Button button2  = findViewById(R.id.button2);
        button2.setOnClickListener((v) -> {
           controller.Intermediate();
            switchToGame();
        });
    }

    /**
     * Hard version
     */
    private void setupDifficultButton3Listener(){
        Button button3  = findViewById(R.id.button3);
        button3.setOnClickListener((v) -> {
            controller.Difficult();
            switchToGame();
        });
    }

}

