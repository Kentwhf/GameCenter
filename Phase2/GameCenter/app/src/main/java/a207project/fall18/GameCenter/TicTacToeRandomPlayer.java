package a207project.fall18.GameCenter;

 class TicTacToeRandomPlayer {


     public void setTicTacToeBoardManager(TicTacToeBoardManager ticTacToeBoardManager) {
         this.ticTacToeBoardManager = ticTacToeBoardManager;
     }

     private TicTacToeBoardManager ticTacToeBoardManager;

    TicTacToeRandomPlayer(TicTacToeBoardManager ticTacToeBoardManager) {
        this.ticTacToeBoardManager = ticTacToeBoardManager;
    }

    public int GetMove(int player) {
        return ticTacToeBoardManager.getSlidingTilesBoard().getRandomEmpty();
    }
}
