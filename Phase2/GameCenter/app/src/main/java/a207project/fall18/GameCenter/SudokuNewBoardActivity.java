package a207project.fall18.GameCenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import me.kirkhorn.knut.android_sudoku.fragments.CellGroupFragment;
//import me.kirkhorn.knut.android_sudoku.model.SudokuBoard;

/**
 *
 */

//public class SudokuNewBoardActivity extends AppCompatActivity implements CellGroupFragment.OnFragmentInteractionListener {
//    private final String TAG = "NewSudokuBoardActivity";
//    private TextView clickedCell;
////    private SudokuBoard newSudokuBoard;
//    private int clickedGroup;
//    private int clickedCellId;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sudoku_new_board);
//
//        int cellGroupFragments[] = new int[]{R.id.cellGroupFragment, R.id.cellGroupFragment2, R.id.cellGroupFragment3, R.id.cellGroupFragment4,
//                R.id.cellGroupFragment5, R.id.cellGroupFragment6, R.id.cellGroupFragment7, R.id.cellGroupFragment8, R.id.cellGroupFragment9};
//        for (int i = 1; i < 10; i++) {
//            CellGroupFragment thisCellGroupFragment = (CellGroupFragment) getSupportFragmentManager().findFragmentById(cellGroupFragments[i-1]);
//            thisCellGroupFragment.setGroupId(i);
//        }
//
////        newSudokuBoard = new SudokuBoard();
//    }
//
////    public void onGoBackButtonClicked(View view) {
////        finish();
////    }
////
////    public void onContinueButtonClicked(View view) {
////        Intent intent = new Intent(this, SudokuGameDifficultyActivity.class);
////        intent.putExtra("newSudokuBoard", true);
////        startActivityForResult(intent, 2);
////    }
////
////    private void saveSudokuBoard(int difficulty) {
////        String fileName = "boards-";
////        if (difficulty == 0) {
////            fileName += "easy";
////        } else if (difficulty == 1) {
////            fileName += "normal";
////        } else {
////            fileName += "hard";
////        }
////        String content = newSudokuBoard.toString();
////        System.out.println("new SudokuBoard: " + content);
////        FileOutputStream fileOutputStream;
////        try {
////            fileOutputStream = openFileOutput(fileName, Context.MODE_APPEND);
////            fileOutputStream.write(content.getBytes());
////            fileOutputStream.close();
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
////
////    @Override
////    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
////        if (requestCode == 1 && resultCode == RESULT_OK) {
////            int row = ((clickedGroup-1)/3)*3 + (clickedCellId/3);
////            int column = ((clickedGroup-1)%3)*3 + ((clickedCellId)%3);
////
////            if (data.getBooleanExtra("removePiece", false)) {
////                clickedCell.setText("");
////                newSudokuBoard.setValue(row, column, 0);
////            } else {
////                int number = data.getIntExtra("chosenNumber", 1);
////                newSudokuBoard.setValue(row, column, number);
////                clickedCell.setText(String.valueOf(number));
////                clickedCell.setTextColor(Color.BLACK);
////                clickedCell.setTypeface(null, Typeface.BOLD);
////            }
////        } else if (requestCode == 2 && resultCode == RESULT_OK) {
////            if (data.getBooleanExtra("boardSaved", false)) {
////                saveSudokuBoard(data.getIntExtra("difficulty", 1));
////                Toast.makeText(this, getString(R.string.successful_new_board), Toast.LENGTH_SHORT).show();
////            } else {
////                Toast.makeText(this, getString(R.string.successful_new_board), Toast.LENGTH_SHORT).show();
////            }
////        }
////    }
////
////    @Override
////    public void onFragmentInteraction(int groupId, int cellId, View view) {
////        clickedCell = (TextView) view;
////        clickedCellId = cellId;
////        clickedGroup = groupId;
////        Log.i(TAG, "Clicked group " + groupId + ", cell " + cellId);
////        Intent intent = new Intent(this, SudokuChooseNumberActivity.class);
////        intent.putExtra("newSudokuBoard", true);
////        startActivityForResult(intent, 1);
////    }
//}
