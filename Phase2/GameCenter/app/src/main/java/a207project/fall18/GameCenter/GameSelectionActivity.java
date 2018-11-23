package a207project.fall18.GameCenter;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import a207project.fall18.GameCenter.bean.Score;

public class
GameSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_selection);
        setTitle("Select Game");

        setupSlidingTilesGame1ButtonListener();
        LogoutButtonListener();
    }

    /**
     * Button for SlidingTiles
     */
    private void setupSlidingTilesGame1ButtonListener(){
        Button Game1 = findViewById(R.id.Game1);
        Game1.setOnClickListener((v) -> {
            MyApplication.getInstance().setGame("SlidingTiles");
            Score STscore = new Score(MyApplication.getInstance().getUser(), "SlidingTiles");
            MyApplication.getInstance().setScore(STscore);
            MyApplication.getInstance().setSavingManager(new SavingManager(this, "SlidingTiles"));
            Intent i = new Intent(this, StartingActivity.class);
            startActivity(i);
        });
    }

    /**
     * Logout button
     */
    private void LogoutButtonListener(){
        Button Logout= findViewById(R.id.Logout);
        Logout.setOnClickListener((v) -> {
            Intent i = new Intent(this, SignInActivity.class);
            startActivity(i);
        });
    }
}
