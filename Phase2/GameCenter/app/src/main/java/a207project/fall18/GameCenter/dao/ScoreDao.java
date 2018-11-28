package a207project.fall18.GameCenter.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import a207project.fall18.GameCenter.bean.Score;

public class ScoreDao extends Dao<Score>{

    public ScoreDao(Context context){
        super(context);
        sqLiteHelper = new SQLiteHelper(context);
    }
    @Override
    public long insert(Score score) {
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("userId", score.getUserId());
        values.put("nickname", score.getNickname());
        values.put("gameType", score.getGameType());
        values.put("finalScore", score.getFinalScore());
        long id = db.insert("Score", null, values);
        db.close();
        return id;
    }


    @Override
    public boolean delete(int ID) {
        return false;
    }

    @Override
    public boolean update(Score score) {
        return false;
    }

    @Override
    public List<Score> query(String game) {
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        Cursor cursor=db.query("Score",null,"gameType",new String[]{game},null,null,"finalScore DESC");
        List<Score> scoreList =new ArrayList<Score>();
        while(cursor.moveToNext()){
            int id= cursor.getInt(cursor.getColumnIndex("id"));
            String nickname = cursor.getString(2);
            String gametype = cursor.getString(3);
            int finalScore = cursor.getInt(4);
            Score score=new Score();
            score.setId(id);
            score.setNickname(nickname);
            score.setGameType(gametype);
            score.setFinalScore(finalScore);
            scoreList.add(score);
        }
        cursor.close();
        db.close();
        return scoreList;
    }
}
