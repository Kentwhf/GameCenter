package a207project.fall18.GameCenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import a207project.fall18.GameCenter.TicTacToeGameActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ttt_activity_main);

//        Toast toast = Toast.makeText(this, R.string.welcome, Toast.LENGTH_LONG);
//        toast.show();

        Intent intent = new Intent(this, TicTacToeGameActivity.class);
        startActivity(intent);
        finish();
    }
}
