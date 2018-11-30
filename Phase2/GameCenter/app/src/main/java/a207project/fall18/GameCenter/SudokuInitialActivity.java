package a207project.fall18.GameCenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import a207project.fall18.GameCenter.dao.SaveDao;


public class SudokuInitialActivity extends AppCompatActivity {


    private SaveDao savingManager;

    private boolean currentEnglish = true;
    private final String TAG = "SudokuInitialActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_initial);

        savingManager = MyApplication.getInstance().getSavingManager();
        addLoadGameButton();

//        checkCurrentLocale();
    }

//    private void checkCurrentLocale() {
//        Log.i(TAG, "Checking current locale");
//        SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
//        String currentLanguage = sharedPreferences.getString("app_language", null);
//        Configuration configuration = new Configuration();
//        Resources resources = getBaseContext().getResources();
//        Locale locale = getResources().getConfiguration().locale;
//
//        if (currentLanguage == null) {
//            Log.i(TAG, "There is no shared Preferences... Creating...");
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//
//            if (locale.getLanguage().equals("no") || locale.getLanguage().equals("nb") || locale.getLanguage().equals("nn")) {
//                //Norwegian is selected
//                Log.i(TAG, "Norwegian is selected");
//                editor.putString("app_language", "no");
//                editor.apply();
//                configuration.locale = new Locale("no", "NO");
//                currentEnglish = false;
//            } else {
//                //English is selected
//                Log.i(TAG, "English is selected");
//                editor.putString("app_language", "en");
//                editor.apply();
//                configuration.locale = new Locale("en", "US");
//                currentEnglish = true;
//            }
//        } else {
//            if (currentLanguage.equals("no")) {
//                Log.i(TAG, "Norwegian is selected");
//                configuration.locale = new Locale("no", "NO");
//                currentEnglish = false;
//
//            } else {
//                //currentLanguage == "en"
//                Log.i(TAG, "English is selected");
//                configuration.locale = new Locale("en", "US");
//                currentEnglish = true;
//            }
//        }
//        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
//        refreshViewLanguages();
//    }

//    private void refreshViewLanguages() {
//        Log.i(TAG, "Refreshing View Languages");
//        Button buttonStartNewGame = findViewById(R.id.buttonStartNewGame);
//        buttonStartNewGame.setText(R.string.new_game);
//        Button buttonAddNewBoard = findViewById(R.id.buttonAddNewBoard);
//        buttonAddNewBoard.setText(R.string.add_new_board);
//        Button buttonShowInstructions = findViewById(R.id.buttonShowInstructions);
//        buttonShowInstructions.setText(R.string.show_instructions);
//
//        TextView textViewChooseLanguage = findViewById(R.id.textViewChooseLanguage);
//        textViewChooseLanguage.setText(R.string.choose_language);
//    }

    public void onStartNewGameButtonClicked(View view) {
        Intent intent = new Intent(this, SudokuGameDifficultyActivity.class);
        startActivity(intent);
    }

    private void addLoadGameButton() {
        Button load = findViewById(R.id.LoadGame);
        load.setOnClickListener((v) -> {


//            List<BoardManager> historicalFile = savingManager.query("get slidingTilesBoardManager");

            if ( MyApplication.getInstance().getBoardManager() != null){
//                saveToFile(TEMP_SAVE_FILENAME);
//                MyApplication.getInstance().setBoardManager( historicalFile.get(0));// testing
                Intent intent = new Intent(this, SudokuGameActivity.class);
//                intent.putExtra("old game", historicalFile.get(0));
                startActivity(intent);

            }
            else{
                Toast.makeText(SudokuInitialActivity.this,"No History！",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onShowInstructionsButtonClicked(View view) {
        Intent intent = new Intent(this, SudokuInstructionsActivity.class);
        startActivity(intent);
    }

}

