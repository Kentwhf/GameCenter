package a207project.fall18.GameCenter;

import android.app.Application;


import a207project.fall18.GameCenter.bean.Score;
import a207project.fall18.GameCenter.bean.User;

public class MyApplication extends Application {

    public User user;
    public String gameType;
    public Score currentScore;
    public static BoardManager boardManager;
    public static SavingManager savingManager;

    private static MyApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public BoardManager getBoardManager(){return boardManager;}
    public void setBoardManager(BoardManager bm){this.boardManager = bm;}

    public SavingManager getSavingManager(){return this.savingManager;}
    public void setSavingManager(SavingManager sm){this.savingManager = sm;}

    public static MyApplication getInstance() {
        return instance;
    }

    public String getGame() {
        return gameType;
    }

    public void setGame(String game) {
        this.gameType = game;
    }

    public Score getScore() {
        return currentScore;
    }

    public void setScore(Score score) {
        this.currentScore = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
