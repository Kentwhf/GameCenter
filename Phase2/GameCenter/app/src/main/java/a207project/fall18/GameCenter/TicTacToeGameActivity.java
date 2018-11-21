package a207project.fall18.GameCenter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.Hashtable;

import a207project.fall18.GameCenter.R;

/**
 * The tic tac toe game activity.
 */
public class TicTacToeGameActivity extends AppCompatActivity implements View.OnClickListener {
    private static Hashtable<Integer, Integer> boardImages = new Hashtable<>();
    /**
     * Dim of the board.
     */
    public static int dim = 3;
    /**
     * The game with the num of the scale.
     */
    private static Game game = new Game(dim);
    @Game.FieldValue private int player = Game.X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe_game);

        game = new Game(dim);
        boardImages.put(Game.EMPTY, R.drawable.ttt_blank);
        boardImages.put(Game.X, R.drawable.ttt_x);
        boardImages.put(Game.O, R.drawable.ttt_o);

        GridLayout grid = findViewById(R.id.board);
        grid.setOnClickListener(this);
        grid.setColumnCount(dim);

        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                ImageView field = new ImageView(this);

                GridLayout.LayoutParams params = new GridLayout.LayoutParams(
                        GridLayout.spec(row, 1f),
                        GridLayout.spec(col, 1f));
                params.height = 0;
                params.width = 0;
                field.setLayoutParams(params);

                field.setScaleType(ImageView.ScaleType.FIT_XY);
                field.setImageResource(boardImages.get(Game.EMPTY));
                field.setId(row * dim + col);
                grid.addView(field);
            }
        }

        for (int i = 0; i < grid.getChildCount(); i++) {
            ImageView field = (ImageView) grid.getChildAt(i);
            field.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        ImageView field = (ImageView) v;
        int fieldIdx = field.getId();

        if (game.Move(fieldIdx, player)) {
            field.setImageResource(boardImages.get(player));

//            if (game.won) {
//                DeclareResult(getString(R.string.win_human));
//            }
        }

        if (!game.won && game.getBoard().isFull()) {
            DeclareResult("It's a draw!");
        }
        player = player * -1;
    }

    public void DeclareResult(CharSequence message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NewGame();
            }
        });
        alertDialogBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                NewGame();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void NewGame() {
        this.recreate();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.game_menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.new_game:
//                NewGame();
//                return true;
//            case R.id.board_3x3:
//                dim = 3;
//                NewGame();
//                return true;
//            case R.id.board_4x4:
//                dim = 4;
//                NewGame();
//                return true;
//            case R.id.board_5x5:
//                dim = 5;
//                NewGame();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}