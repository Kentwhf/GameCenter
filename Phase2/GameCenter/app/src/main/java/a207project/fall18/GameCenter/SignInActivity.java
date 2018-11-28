package a207project.fall18.GameCenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import android.widget.Toast;

import java.util.HashMap;

/**
 * A SignIn User interface
 */
public class SignInActivity extends AppCompatActivity {

    private UserAccountManager userAccountManager;
    private UserAccount currentUser;
    public static final String SAVE_FILENAME = "UserInfo_file.ser";

    @Override
//    Take text username and password from textbox.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        setTitle("Game Centre");
        setupSignInButtonListener();
        setupSignUpButtonListener();

        if (userAccountManager == null){
            userAccountManager = new UserAccountManager(new HashMap<>());
        }
        loadFromFile();
    }


    @Override
    public void onPause(){
        super.onPause();
        saveToFile(SAVE_FILENAME);
    }


    @Override
    public void onResume(){
        super.onResume();
        if (userAccountManager == null){
            userAccountManager = new UserAccountManager(new HashMap<>());
        }
        loadFromFile();
    }


    private boolean successfulSignIn(TextView usernameTextField, TextView passwordTestField) {
        String username = usernameTextField.getText().toString();
        String password = passwordTestField.getText().toString();
        UserAccount user = new UserAccount(username, password);
        if (userAccountManager.login(username, password)) {
            this.currentUser = user;
            return true;
        } else {
            return false;
        }
    }

    private void setupSignInButtonListener(){
        Button SignInButton = findViewById(R.id.SignIn);
        Intent i = new Intent(this,GameSelectionActivity.class);
        Intent session = new Intent(this,GameActivity.class);
        SignInButton.setOnClickListener((v) -> {
            if (successfulSignIn(findViewById(R.id.UserInput), findViewById(R.id.Password))) {
                session.putExtra("currentUser", this.currentUser.getUsername());
                this.currentUser = null;

                startActivity(i);
            } else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Invalid username/password",
                        Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    private void setupSignUpButtonListener(){

        Button SignUpButton = findViewById(R.id.SignUp);
        SignUpButton.setOnClickListener((v) -> {
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        });
    }

    /**
     * Deserialize the file
     *
     */
    private void loadFromFile() {

        try {
            InputStream inputStream = this.openFileInput(SignInActivity.SAVE_FILENAME);
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                userAccountManager = (UserAccountManager) input.readObject();
                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("sign-up activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("sign-up activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("sign-up activity", "File contained unexpected data type: " + e.toString());
        }
    }

    /**
     * Serialize the file
     *
     * @param fileName the name of the file
     */
    public void saveToFile(String fileName) {

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    this.openFileOutput(fileName, MODE_PRIVATE));
            outputStream.writeObject(userAccountManager);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}


