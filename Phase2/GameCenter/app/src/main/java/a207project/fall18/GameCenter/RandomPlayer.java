package a207project.fall18.GameCenter;

import java.io.Serializable;

class RandomPlayer implements Serializable {
    static Game game;

    RandomPlayer(Game game) {
        this.game = game;
    }

    public int GetMove(int player) {
        return game.getTTTBoard().getRandomEmpty();
    }
}
