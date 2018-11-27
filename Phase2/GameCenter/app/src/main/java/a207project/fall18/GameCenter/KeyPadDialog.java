package a207project.fall18.GameCenter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.security.AccessControlContext;


public class KeyPadDialog extends Dialog{

    private SudokuBoard sudokuBoard;
    private final View keys[] = new View[12];
//    private SudokuBoard sudokuBoard;
//    private int targetRow;
//    private int targetCol;

    /**
     *
     */
    public interface PriorityListener {
        /**
         * 回调函数，用于在Dialog的监听事件触发后刷新Activity的UI显示
         */
        default void refreshPriorityUI(String string) {

        }
    }

    private PriorityListener listener;


    public KeyPadDialog(Context context, SudokuBoard sudokuBoard, PriorityListener listener) {
        super(context);
//        this.targetRow = row;
//        this.targetCol = col;
        this.sudokuBoard = sudokuBoard;
        this.listener = listener;
    }
//    private final int used[];
//    private ShuduView shuduview;
//    private Design game;
//
//
//    public KeyDialog(Context context, int[] used, ShuduView shuduview, Design game){
//        super(context);
//        this.used =used;
//        this.shuduview = shuduview;
//        this.game=game;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        setTitle("请选择:");
        setContentView(R.layout.keypad);
        findViews();
//        for(int i=0;i<used.length;i++){
//            if(used[i]!=0){
//                keys[used[i]-1].setVisibility(View.INVISIBLE);
//            }
//        }
        setKeysListeners();
    }

    private void findViews(){
        keys[0]=findViewById(R.id.keypad_1);
        keys[1]=findViewById(R.id.keypad_2);
        keys[2]=findViewById(R.id.keypad_3);
        keys[3]=findViewById(R.id.keypad_4);
        keys[4]=findViewById(R.id.keypad_5);
        keys[5]=findViewById(R.id.keypad_6);
        keys[6]=findViewById(R.id.keypad_7);
        keys[7]=findViewById(R.id.keypad_8);
        keys[8]=findViewById(R.id.keypad_9);
        keys[9]=findViewById(R.id.keypad_10);
        keys[10]=findViewById(R.id.keypad_11);
        keys[10].setVisibility(View.INVISIBLE);
        keys[11]=findViewById(R.id.keypad_12);
    }


    private void setResult(int cell){
        listener.refreshPriorityUI(String.valueOf(cell));
//        sudokuBoard.setValue(targetRow, targetCol, cell);
//        Intent intent = new Intent();
//        intent.putExtra("chosenNumber", cell);
//        intent.putExtra("isUnsure", checkBoxChecked);

        dismiss();
    }

    private void setKeysListeners(){
        for (int i=0; i < keys.length; i++){
            int cell;
            if (i < 9) {
                cell = i + 1;
            } else cell = 0;
            keys[i].setOnClickListener(v -> setResult(cell));
        }
//
        // Go back to Sudoku board
        keys[11].setOnClickListener(v -> dismiss());
//
//        // Hint
//        keys[10].setOnClickListener(v -> {
//            shuduview.setSelectedTile(game.shudushow[shuduview.selectedX][shuduview.selectedY]);
////                game.setTile(shuduview.selectedX,shuduview.selectedY,
////                        game.shudushow[shuduview.selectedX][shuduview.selectedY]);
////                game.caculateAllusedTiles();
////                shuduview.invalidate();
//            dismiss();
//        });
    }

//    public SudokuBoard getNewSudokuBoard(){
//        return this.sudokuBoard;
//    }

}
