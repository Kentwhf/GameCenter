package a207project.fall18.GameCenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import a207project.fall18.GameCenter.bean.User;
import a207project.fall18.GameCenter.dao.UserDao;


/**
 * A SignUp User interface
 */
public class SignUpActivity extends AppCompatActivity {

    private UserDao userAccountManager;
    private Button  RegisterButton;
    private EditText username;
    private EditText password;
    private EditText nickname;
    private EditText verifypassword;


//    public static final String SAVE_FILENAME = "UserInfo_file.ser";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        setTitle("Sign up!");


        RegisterButton = findViewById(R.id.Register);
        //COMMENT
        username = findViewById(R.id.Username);
        nickname = findViewById(R.id.Nickname);
        password = findViewById(R.id.NPassword);
        verifypassword = findViewById(R.id.ConfirmPassword);

        userAccountManager = new UserDao(this);

        RegisterButton.setOnClickListener(this::onClick);

//        if (userAccountManager == null){
//            userAccountManager = new UserAccountManager(new HashMap<>());

//        loadFromFile();



    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.Register:
                register();
                break;
        }

    }


    private void register(){
        User user=new User();
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());
        user.setNickname(nickname.getText().toString());
        if(username.getText().toString().matches("")||password.getText().toString().matches("")||verifypassword.getText().toString().matches("")){
            Toast.makeText(SignUpActivity.this,"username/password is empty！",Toast.LENGTH_SHORT).show();
            return;
        }else   if(!password.getText().toString().equals(verifypassword.getText().toString())){
            Toast.makeText(SignUpActivity.this,"password confirm fail",Toast.LENGTH_SHORT).show();
            return;
        }else{
//            UserDao userdao = new UserDao(this);
            long registerResult = MyApplication.getInstance().getUserDao().register(user);
            if(registerResult>0){
                Toast.makeText(SignUpActivity.this,"Regist success！" + registerResult,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SignInActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(SignUpActivity.this,"Regist fail,username exist！",Toast.LENGTH_SHORT).show();
            }

        }
    }
}





    /**
     * New user registration button
     */
//    private void setupRegisterButtonListener(){
//        Button RegisterButton = findViewById(R.id.Register);
//        RegisterButton.setOnClickListener((v) -> {
//            EditText username = findViewById(R.id.NewUsername);
//            EditText password = findViewById(R.id.ConfirmPassword);
//            String user = username.getText().toString();
//            String pass = password.getText().toString();
//            Intent i = new Intent(this, SignInActivity.class);
//
//
//            // Check if new user is valid to be registered.
//            UserAccount curruser = new UserAccount(user, pass);
//            boolean isSuccessfulSignup = this.userAccountManager.addNewUser(curruser);
//            if (isSuccessfulSignup) {
//                Toast toast = Toast.makeText(getApplicationContext(),
//                        "Sign up successfully",
//                        Toast.LENGTH_LONG);
//                toast.show();
//
//                saveToFile(SAVE_FILENAME);
//
//                startActivity(i);
//
//            } else {
//                Toast toast = Toast.makeText(getApplicationContext(),
//                        "Users must choose a unique username. Please try again.",
//                        Toast.LENGTH_LONG);
//                toast.show();
//            }
//        });
//    }

    /**
     * Load from user info files
     *
     */
//    private void loadFromFile() {
//
//        try {
//            InputStream inputStream = this.openFileInput(SignUpActivity.SAVE_FILENAME);
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
//     * Add new user info into database
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


