package a207project.fall18.GameCenter;

 class RandomPlayer {


     public void setTicTacToeBoardManager(TicTacToeBoardManager ticTacToeBoardManager) {
         this.ticTacToeBoardManager = ticTacToeBoardManager;
     }

     private TicTacToeBoardManager ticTacToeBoardManager;

    RandomPlayer(TicTacToeBoardManager game) {
        this.ticTacToeBoardManager = game;
    }

    public int GetMove(int player) {
        return ticTacToeBoardManager.getBoard().getRandomEmpty();
    }
}
