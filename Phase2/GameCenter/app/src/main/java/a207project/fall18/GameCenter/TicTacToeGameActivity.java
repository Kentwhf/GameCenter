package a207project.fall18.GameCenter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Random;

import a207project.fall18.GameCenter.R;
import a207project.fall18.GameCenter.dao.SaveDao;

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
    private static RandomPlayer computer = new RandomPlayer(game);
    @Game.FieldValue private int player = Game.X;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe_game);

        game = new Game(dim);
        game.SwitchAI(computer);
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
        Random random = new Random();
        if (random.nextBoolean()) MoveOpponent();
        setaddBackButtonListener();
    }

    @Override
    public void onClick(View v) {
        ImageView field = (ImageView) v;
        int fieldIdx = field.getId();

        if (game.Move(fieldIdx, player)) {
            field.setImageResource(boardImages.get(player));

            if (game.won) {
                DeclareResult("You Win!!");
            }
            else {
                MoveOpponent();
            }

        }

        if (!game.won && game.getTTTBoard().isFull()) {
            DeclareResult("It's a draw!");
        }
    }

    private void MoveOpponent() {
        @Game.FieldValue int opponent = player * -1;
        int moveIdx = game.GetMove(opponent);

        if (moveIdx >= 0) {
            game.Move(moveIdx, opponent);
            ImageView opponentField = findViewById(moveIdx);
            opponentField.setImageResource(boardImages.get(opponent));

            if (game.won) {
                DeclareResult("You Lose!!");
            }
        }
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

    /**
     * Intermediate version
     */
    private void setaddBackButtonListener() {
        Button Game = findViewById(R.id.Game);
        Game.setOnClickListener((v) -> {
            Intent i = new Intent(this, GameSelectionActivity.class);
            startActivity(i);
        });
    }



}