package a207project.fall18.GameCenter.bean;

public class Score {
    private int id;
    private int userId;
//    private int gameId;
    private String gameType;
    private String nickname;
    private int finalScore;

    public Score(){}

    public Score(User user, String gameType){
        this.userId = user.getId();
        this.gameType = gameType;
        this.nickname = user.getNickname();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public int getGameId() {
//        return gameId;
//    }
//
//    public void setGameId(int gameId) {
//        this.gameId = gameId;
//    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    @Override
    public String toString() {
        return this.id+"/"+this.userId +"/"+this.gameType+"/"+this.finalScore;
    }
}


