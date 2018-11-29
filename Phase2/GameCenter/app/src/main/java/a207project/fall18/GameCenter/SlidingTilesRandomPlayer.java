package a207project.fall18.GameCenter;

 class SlidingTilesRandomPlayer {


     public void setTicTacToeBoardManager(TicTacToeBoardManager ticTacToeBoardManager) {
         this.ticTacToeBoardManager = ticTacToeBoardManager;
     }

     private TicTacToeBoardManager ticTacToeBoardManager;

    SlidingTilesRandomPlayer(TicTacToeBoardManager game) {
        this.ticTacToeBoardManager = game;
    }

    public int GetMove(int player) {
        return ticTacToeBoardManager.getBoard().getRandomEmpty();
    }
}
