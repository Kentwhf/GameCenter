package a207project.fall18.GameCenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;

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

    private String TAG = "ScoreActivity";
    /**
     * A ListView
     */
    private ListView listView;
    /**
     * List of scores
     */
    private List<Score> scoreList =new ArrayList<Score>();

    /**
     * A ScoreAdapter
     */
    private ScoreAdapter scoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        ScoreDao scoreDao = MyApplication.getInstance().getScoreDao();

        listView=findViewById(R.id.lv_score);

        scoreList = scoreDao.query(MyApplication.getInstance().getGame());

        scoreAdapter=new ScoreAdapter(this, scoreList);
        listView.setAdapter(scoreAdapter);
    }

    }


