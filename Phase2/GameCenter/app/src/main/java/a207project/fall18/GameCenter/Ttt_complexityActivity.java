package a207project.fall18.GameCenter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;


public class Ttt_complexityActivity extends AppCompatActivity {

    /**
     * The board manager.
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

    private void addEasyButtonListener() {
        Button Button1 = findViewById(R.id.button1);
        Button1.setOnClickListener((v) -> {
            TicTacToeGameActivity.dim = 3;
            Intent i = new Intent(this, TicTacToeGameActivity.class);
            startActivity(i);
        });
    }

    /**
     * Intermediate version
     */
    private void addIntermediateButtonListener() {
        Button Button2 = findViewById(R.id.button2);
        Button2.setOnClickListener((v) -> {
            TicTacToeGameActivity.dim = 4;
            Intent i = new Intent(this, TicTacToeGameActivity.class);
            startActivity(i);
        });
    }

    /**
     * Hard version
     */
    private void setupDifficultButton3Listener() {
        Button Button3 = findViewById(R.id.button3);
        Button3.setOnClickListener((v) -> {
            TicTacToeGameActivity.dim = 5;
            Intent i = new Intent(this, TicTacToeGameActivity.class);
            startActivity(i);
        });
    }
}
