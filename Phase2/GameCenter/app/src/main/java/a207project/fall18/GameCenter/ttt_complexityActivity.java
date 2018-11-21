import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.io.IOException;
import java.io.ObjectOutputStream;

import a207project.fall18.GameCenter.Board;
import a207project.fall18.GameCenter.BoardManager;
import a207project.fall18.GameCenter.GameActivity;
import a207project.fall18.GameCenter.StartingActivity;
import a207project.fall18.GameCenter.TicTacToeGameActivity;

public class ttt_complexityActivity extends AppCompatActivity {
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
    private Game game;

    /**
     * Switch to game
     */
    private void switchToGame() {
        Intent tmp = new Intent(this, TicTacToeGameActivity.class);
        saveToFile(StartingActivity.TEMP_SAVE_FILENAME);
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
    }

    private void addEasyButtonListener() {
        Button Button1 = findViewById(R.id.button1);
        Button1.setOnClickListener((v) -> {
            TTTBoard.dim = 3;
            saveToFile(SAVE_FILENAME);
            saveToFile(TEMP_SAVE_FILENAME);
            switchToGame();
        });
    }

    /**
     * Intermediate version
     */
    private void addIntermediateButtonListener() {
        Button Button2 = findViewById(R.id.button2);
        Button2.setOnClickListener((v) -> {
            TTTBoard.dim = 4;
            saveToFile(SAVE_FILENAME);
            saveToFile(TEMP_SAVE_FILENAME);
            switchToGame();
        });
    }

    /**
     * Hard version
     */
    private void setupDifficultButton3Listener() {
        Button Button3 = findViewById(R.id.button3);
        Button3.setOnClickListener((v) -> {
            TTTBoard.dim = 5;
            saveToFile(SAVE_FILENAME);
            saveToFile(TEMP_SAVE_FILENAME);
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
            outputStream.writeObject(TTTBoard);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}