package a207project.fall18.GameCenter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;


public class TicTacToeComplexityActivity extends AppCompatActivity {

    /**
     * The tiles manager.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tttcomplexity);
        setTitle("Select difficulty");
        addEasyButtonListener();
        addIntermediateButtonListener();
        setupDifficultButton3Listener();
    }

    /**
     * Initialize a Easy version of the TicTacToe.
     */
    private void addEasyButtonListener() {
        Button Button1 = findViewById(R.id.button1);
        Button1.setOnClickListener((v) -> {
            TicTacToeGameActivity.size = 3;
            Intent i = new Intent(this, TicTacToeGameActivity.class);
            startActivity(i);
        });
    }

    /**
     * Initialize a Intermediate version of the TicTacToe.
     */
    private void addIntermediateButtonListener() {
        Button Button2 = findViewById(R.id.button2);
        Button2.setOnClickListener((v) -> {
            TicTacToeGameActivity.size = 4;
            Intent i = new Intent(this, TicTacToeGameActivity.class);
            startActivity(i);
        });
    }

    /**
     * Initialize a Difficult version of the TicTacToe.
     */
    private void setupDifficultButton3Listener() {
        Button Button3 = findViewById(R.id.button3);
        Button3.setOnClickListener((v) -> {
            TicTacToeGameActivity.size = 5;
            Intent i = new Intent(this, TicTacToeGameActivity.class);
            startActivity(i);
        });
    }
}