package a207project.fall18.GameCenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class ComplexityActivity extends AppCompatActivity {

    private SavingManager savingManager;
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
        Intent tmp = new Intent(this, GameActivity.class);
        MyApplication.getInstance().setBoardManager(boardManager);
//        saveToFile(StartingActivity.TEMP_SAVE_FILENAME);
        startActivity(tmp);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complexity);
        setTitle("Select difficulty");
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
                int time = Integer.parseInt(undoInputTextField.getText().toString());
                boardManager.setCanUndoTime(time);} else{boardManager.setCanUndoTime(3);}
//            saveToFile(SAVE_FILENAME);
//            saveToFile(TEMP_SAVE_FILENAME);
            savingManager.addAutosavemap(MyApplication.getInstance().getUser(), boardManager);
            MyApplication.getInstance().setBoardManager(boardManager);
        });
    }

    /**
     * Easy version
     */
    private void addEasyButtonListener(){
        Button Button1  = findViewById(R.id.button1);
        Button1.setOnClickListener((v) -> {
            Board.setNumRowsCols(3);
            boardManager = new BoardManager();
//            saveToFile(SAVE_FILENAME);
//            saveToFile(TEMP_SAVE_FILENAME);
            savingManager.addAutosavemap(MyApplication.getInstance().getUser(), boardManager);
            MyApplication.getInstance().setBoardManager(boardManager);
            switchToGame();
    });
    }

    /**
     * Intermediate version
     */
    private void addIntermediateButtonListener(){
        Button Button2  = findViewById(R.id.button2);
        Button2.setOnClickListener((v) -> {
            Board.setNumRowsCols(4);
            boardManager = new BoardManager();
//            saveToFile(SAVE_FILENAME);
//            saveToFile(TEMP_SAVE_FILENAME);
            savingManager.addAutosavemap(MyApplication.getInstance().getUser(), boardManager);
            MyApplication.getInstance().setBoardManager(boardManager);
            switchToGame();
        });
    }

    /**
     * Hard version
     */
    private void setupDifficultButton3Listener(){
        Button Button3  = findViewById(R.id.button3);
        Button3.setOnClickListener((v) -> {
            Board.setNumRowsCols(5);
            boardManager = new BoardManager();
//            saveToFile(SAVE_FILENAME);
//            saveToFile(TEMP_SAVE_FILENAME);
            savingManager.addAutosavemap(MyApplication.getInstance().getUser(), boardManager);
            MyApplication.getInstance().setBoardManager(boardManager);
            switchToGame();
        });
    }

    /**
     * Save the board manager to fileName.
     *
     * @param fileName the name of the file
     */
    public void saveToFile(String fileName) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    this.openFileOutput(fileName, MODE_PRIVATE));
            outputStream.writeObject(boardManager);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
