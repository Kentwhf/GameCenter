package a207project.fall18.GameCenter;

import java.io.Serializable;
import java.util.Observable;

public class Board extends Observable implements Serializable {


    private SlidingTile[][] slidingTiles;

    public void setSlidingTiles(SlidingTile[][] slidingTiles) {
        this.slidingTiles = slidingTiles;
    }

    public SlidingTile[][] getSlidingTiles() {
        return slidingTiles;
    }





}
