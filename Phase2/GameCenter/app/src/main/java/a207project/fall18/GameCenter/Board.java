package a207project.fall18.GameCenter;

import java.util.Observable;

public abstract class Board extends Observable {

    private SlidingTile[][] slidingTiles;

    public void setSlidingTiles(SlidingTile[][] slidingTiles) {
        this.slidingTiles = slidingTiles;
    }

    public SlidingTile[][] getSlidingTiles() {
        return slidingTiles;
    }





}
