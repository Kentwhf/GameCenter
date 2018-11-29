package a207project.fall18.GameCenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import a207project.fall18.GameCenter.bean.User;
import a207project.fall18.GameCenter.dao.UserDao;

/**
 * A SignIn User interface
 */
public class SignInActivity extends AppCompatActivity {

//    private UserDao userAccountManager;

    private Button signin;
    private Button signup;
    private EditText username;
    private EditText password;
//    private UserAccount currentUser;
//    public static final String SAVE_FILENAME = "UserInfo_file.ser";

    @Override
//    Take text username and password from textbox.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        setTitle("Game Centre");
//        setupSignInButtonListener();
//        setupSignUpButtonListener();

        signin = findViewById(R.id.SignInBT);
        signup = findViewById(R.id.SignUpBT);

        username = findViewById(R.id.UserInputBT);
        password = findViewById(R.id.PasswordBT);

        Log.v("shabi", username.getText().toString());
        Log.v("shabi", password.getText().toString());

        signin.setOnClickListener(this::onClick);
        signup.setOnClickListener(this::onClick);


//        userAccountManager = new UserDao(this);

//        if (userAccountManager == null){
//            userAccountManager = new UserAccountManager(new HashMap<>());
//        }
//        loadFromFile();
    }

    private void onClick(View v){
        switch (v.getId()){
            case R.id.SignInBT:
                Signin();
                break;
            case R.id.SignUpBT:
                Signup();
                break;
        }
    }


    private void Signin(){
        User user = new User();
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());

//        Log.v("shabi", username.getText().toString());
//        Log.v("shabi", password.getText().toString());

        if(username.getText().toString().matches("") || password.getText().toString().matches("")){
            Toast.makeText(SignInActivity.this,"username/password is empty！",Toast.LENGTH_SHORT).show();
        }else{
            boolean loginResult = MyApplication.getInstance().getUserDao().login(user);
            if(loginResult){
                MyApplication.getInstance().setUser(user);
                Toast.makeText(SignInActivity.this,"login success！",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, GameSelectionActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(SignInActivity.this,"Login fail！",Toast.LENGTH_SHORT).show();

            }
        }
    }



    private void Signup(){
        Intent intent=new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }


//    @Override
//    public void onPause(){
//        super.onPause();
//        saveToFile(SAVE_FILENAME);
//    }


//    @Override
//    public void onResume(){
//        super.onResume();
//        if (userAccountManager == null){
//            userAccountManager = new UserAccountManager(new HashMap<>());
//        }
//        loadFromFile();
//    }


//    private boolean successfulSignIn(TextView usernameTextField, TextView passwordTestField) {
//        String username = usernameTextField.getText().toString();
//        String password = passwordTestField.getText().toString();
//        UserAccount user = new UserAccount(username, password);
//        if (userAccountManager.login(username, password)) {
//            this.currentUser = user;
//            return true;
//        } else {
//            return false;
//        }
//    }

//    private void setupSignInButtonListener(){
//        Button SignInButton = findViewById(R.id.SignIn);
//        Intent i = new Intent(this,GameSelectionActivity.class);
//        Intent session = new Intent(this,GameActivity.class);
//        SignInButton.setOnClickListener((v) -> {
//            if (successfulSignIn(findViewById(R.id.UserInput), findViewById(R.id.Password))) {
//                session.putExtra("currentUser", this.currentUser.getUsername());
//                this.currentUser = null;
//
//                startActivity(i);
//            } else {
//                Toast toast = Toast.makeText(getApplicationContext(),
//                        "Invalid username/password",
//                        Toast.LENGTH_LONG);
//                toast.show();
//            }
//        });
//    }
//
//    private void setupSignUpButtonListener(){
//
//        Button SignUpButton = findViewById(R.id.SignUp);
//        SignUpButton.setOnClickListener((v) -> {
//            Intent i = new Intent(this, SignUpActivity.class);
//            startActivity(i);
//        });
//    }

//    /**
//     * Deserialize the file
//     *
//     */
//    private void loadFromFile() {
//
//        try {
//            InputStream inputStream = this.openFileInput(SignInActivity.SAVE_FILENAME);
//            if (inputStream != null) {
//                ObjectInputStream input = new ObjectInputStream(inputStream);
//                userAccountManager = (UserAccountManager) input.readObject();
//                inputStream.close();
//            }
//        } catch (FileNotFoundException e) {
//            Log.e("sign-up activity", "File not found: " + e.toString());
//        } catch (IOException e) {
//            Log.e("sign-up activity", "Can not read file: " + e.toString());
//        } catch (ClassNotFoundException e) {
//            Log.e("sign-up activity", "File contained unexpected data type: " + e.toString());
//        }
//    }
//
//    /**
//     * Serialize the file
//     *
//     * @param fileName the name of the file
//     */
//    public void saveToFile(String fileName) {
//
//        try {
//            ObjectOutputStream outputStream = new ObjectOutputStream(
//                    this.openFileOutput(fileName, MODE_PRIVATE));
//            outputStream.writeObject(userAccountManager);
//            outputStream.close();
//        } catch (IOException e) {
//            Log.e("Exception", "File write failed: " + e.toString());
//        }
//    }
}


