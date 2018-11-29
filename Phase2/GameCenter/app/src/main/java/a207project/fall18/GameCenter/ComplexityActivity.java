package a207project.fall18.GameCenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.ObjectOutputStream;

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
     * The board manager.
     */
    private BoardManager boardManager;

    /**
     * Switch to game
     */
    private void switchToGame() {
        Intent tmp ;

//                new Intent(this, GameActivity.class);
        MyApplication.getInstance().setBoardManager( boardManager);
//        saveToFile(StartingActivity.TEMP_SAVE_FILENAME);
        if (game == "SlidingTiles"){
            tmp = new Intent(this, GameActivity.class);
        }

        else if (game == "TicTacToe"){
            tmp = new Intent(this, TicTacToeGameActivity.class);
        }
        else{
            tmp = new Intent(this, SudokuGameActivity.class);
        }


        startActivity(tmp);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complexity);
        setTitle("Select difficulty");

        controller = new ComplexityController(undoTime);
        game = MyApplication.getInstance().getGame();

        addEasyButtonListener();
        addIntermediateButtonListener();
        setupDifficultButton3Listener();
        setupConfirmButtonListener();

        savingManager = MyApplication.getInstance().getSavingManager();
    }

    /**
     * Button for selecting number of undo moves
     */
    private void setupConfirmButtonListener(){
        Button Button3  = findViewById(R.id.comfirmButton);
        Button3.setOnClickListener((v) -> {
            TextView undoInputTextField = findViewById(R.id.undoInput);
            if (undoInputTextField != null){
                undoTime = Integer.parseInt(undoInputTextField.getText().toString());
                controller = new ComplexityController(undoTime);

            }
        });
    }

    /**
     * Easy version
     */
    private void addEasyButtonListener(){
        Button Button1  = findViewById(R.id.button1);
        Button1.setOnClickListener((v) -> {
           controller.Easy();
            switchToGame();
    });
    }

    /**
     * Intermediate version
     */
    private void addIntermediateButtonListener(){
        Button Button2  = findViewById(R.id.button2);
        Button2.setOnClickListener((v) -> {
           controller.Intermediate();
            switchToGame();
        });
    }

    /**
     * Hard version
     */
    private void setupDifficultButton3Listener(){
        Button Button3  = findViewById(R.id.button3);
        Button3.setOnClickListener((v) -> {
            controller.Difficult();
            switchToGame();
        });
    }

}

