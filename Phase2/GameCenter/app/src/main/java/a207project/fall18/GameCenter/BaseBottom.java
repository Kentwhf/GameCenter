package a207project.fall18.GameCenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;

import java.io.Serializable;

import a207project.fall18.GameCenter.R;

/**
 * A Tile in a sliding tiles puzzle.
 */
public class BaseBottom implements Comparable<BaseBottom>, Serializable {
    int MINE = -1;
    int BLANK = 0;

    /**
     * The background id to find the tile image.
     */
    private int background;

    /**
     * The unique type includes Mine, Blank and Num.
     */
    private int bottomtype;

    /**
     * Return the background id.
     *
     * @return the background id
     */
    public int getBackground() {
        return background;
    }

    /**
     * Return the tile id.
     *
     * @return the tile id
     */
    public int gettype() {
        return bottomtype;
    }

    /**
     * A Tile with id and background. The background may not have a corresponding image.
     *
     * @param bottomtype the id
     * @param background the background
     */
    public BaseBottom(int bottomtype, int background) {
        this.bottomtype = bottomtype;
        this.background = background;
    }

    /**
     * A bottom with a background id; look up and set the id.
     *
     */
//    public BaseBottom() {
//        switch (this.bottomtype) {
//            case MINE:
//                background = R.drawable.mine;
//                break;
//            case BLANK:
//                background = R.drawable.blank;
//                break;
//            case 1:
//                background = R.drawable.num_1;
//                break;
//            case 2:
//                background = R.drawable.num_2;
//                break;
//            case 3:
//                background = R.drawable.num_3;
//                break;
//            case 4:
//                background = R.drawable.num_4;
//                break;
//            case 5:
//                background = R.drawable.num_5;
//                break;
//            case 6:
//                background = R.drawable.num_6;
//                break;
//            case 7:
//                background = R.drawable.num_7;
//                break;
//            case 8:
//                background = R.drawable.num_8;
//                break;
//        }
//    }
    @Override
    public int compareTo(@NonNull BaseBottom o) {
        return o.bottomtype - this.bottomtype;
    }
}