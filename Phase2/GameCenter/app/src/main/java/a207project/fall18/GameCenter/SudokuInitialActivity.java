package a207project.fall18.GameCenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import a207project.fall18.GameCenter.dao.SaveDao;


public class SudokuInitialActivity extends AppCompatActivity {


    private SaveDao savingManager;
    private boolean currentEnglish = true;
    private final String TAG = "SudokuInitialActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_initial);

        savingManager = MyApplication.getInstance().getSavingManager();
        addLoadGameButton();
    }

    public void onStartNewGameButtonClicked(View view) {
        Intent intent = new Intent(this, ComplexityActivity.class);
        startActivity(intent);
    }

    private void addLoadGameButton() {
        Button load = findViewById(R.id.LoadGame);
        load.setOnClickListener((v) -> {
            if (MyApplication.getInstance().getBoardManager() != null){
                Intent intent = new Intent(this, SudokuGameActivity.class);
                startActivity(intent);
            }else {Toast.makeText(SudokuInitialActivity.this,"No History！",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onShowInstructionsButtonClicked(View view) {
        Intent intent = new Intent(this, SudokuInstructionsActivity.class);
        startActivity(intent);
    }
}

