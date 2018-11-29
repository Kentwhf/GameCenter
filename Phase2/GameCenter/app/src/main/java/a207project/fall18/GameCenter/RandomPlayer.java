package a207project.fall18.GameCenter;

 class RandomPlayer {
    static Game game;

    RandomPlayer(Game game) {
        this.game = game;
    }

    public int GetMove(int player) {
        return game.getBoard().getRandomEmpty();
    }
}
