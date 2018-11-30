package a207project.fall18.GameCenter;

 class TicTacToeRandomPlayer {


     public void setTicTacToeBoardManager(TicTacToeBoardManager ticTacToeBoardManager) {
         this.ticTacToeBoardManager = ticTacToeBoardManager;
     }

     private TicTacToeBoardManager ticTacToeBoardManager;

    TicTacToeRandomPlayer(TicTacToeBoardManager ticTacToeBoardManager) {
        this.ticTacToeBoardManager = ticTacToeBoardManager;
    }

    public int getMove(int player) {
        return ticTacToeBoardManager.getTicTacToeBoard().getRandomEmpty();
    }
}
