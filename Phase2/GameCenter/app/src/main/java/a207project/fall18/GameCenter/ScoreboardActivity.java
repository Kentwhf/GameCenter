package a207project.fall18.GameCenter;


import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import a207project.fall18.GameCenter.bean.Score;
import a207project.fall18.GameCenter.dao.ScoreDao;


/**
     * Create the spinner buttons for displaying scoreboards of different complexity.
     *
     * Cite: https://www.youtube.com/watch?v=on_OrrX7Nw4
     */
    public class ScoreboardActivity extends AppCompatActivity {

    private String TAG="ScoreActivity";
    private ListView listView;
    private List<Score> scoreList =new ArrayList<Score>();
    //UNCOMENT
//    private ScoreAdapter scoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        ScoreDao scoreDao=new ScoreDao(this);

//        listView=findViewById(R.id.lv_score);
//
//        scoreList=scoreDao.query(MyApplication.getInstance().getGame());
//        scoreAdapter=new ScoreAdapter(this, scoreList);
//        listView.setAdapter(scoreAdapter);
    }


//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_scoreboard);
//            setTitle("Scoreboard");
//
//            Spinner spinner = findViewById(R.id.spinner);
//            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                    R.array.difficulty, android.R.layout.simple_spinner_item);
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            spinner.setAdapter(adapter);
//            spinner.setOnItemSelectedListener(this);
//        }
//
//
//        /**
//         * Choose different directories to see rankings
//         */
//        @SuppressLint("SetTextI18n")
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            String text = parent.getItemAtPosition(position).toString();
//            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
//            ((TextView) parent.getChildAt(0)).setTextColor(Color.BLUE);
//            ((TextView) parent.getChildAt(0)).setTextSize(24);
//
//            TextView ranking = findViewById(R.id.ranking);
//            ranking.setText("No.1 kent 100\n" + "No.2 abbot 84\n" + "No.3 cho 76");
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//        }
//

    }


