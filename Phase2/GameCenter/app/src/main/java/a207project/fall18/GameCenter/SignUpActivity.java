package a207project.fall18.GameCenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;


/**
 * A SignUp User interface
 */
public class SignUpActivity extends AppCompatActivity {

    private UserAccountManager userAccountManager;

    public static final String SAVE_FILENAME = "UserInfo_file.ser";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        setTitle("Sign up!");
        setupRegisterButtonListener();

        if (userAccountManager == null){
            userAccountManager = new UserAccountManager(new HashMap<>());
        }
        loadFromFile();

    }

    /**
     * New user registration button
     */
    private void setupRegisterButtonListener(){
        Button RegisterButton = findViewById(R.id.Register);
        RegisterButton.setOnClickListener((v) -> {
            EditText username = findViewById(R.id.NewUsername);
            EditText password = findViewById(R.id.NewPassword);
            String user = username.getText().toString();
            String pass = password.getText().toString();
            Intent i = new Intent(this, SignInActivity.class);


            // Check if new user is valid to be registered.
            UserAccount curruser = new UserAccount(user, pass);
            boolean isSuccessfulSignup = this.userAccountManager.addNewUser(curruser);
            if (isSuccessfulSignup) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Sign up successfully",
                        Toast.LENGTH_LONG);
                toast.show();

                saveToFile(SAVE_FILENAME);

                startActivity(i);

            } else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Users must choose a unique username. Please try again.",
                        Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    /**
     * Load from user info files
     *
     */
    private void loadFromFile() {

        try {
            InputStream inputStream = this.openFileInput(SignUpActivity.SAVE_FILENAME);
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
     * Add new user info into database
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

