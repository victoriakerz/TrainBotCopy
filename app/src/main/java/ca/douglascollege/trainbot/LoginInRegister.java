package ca.douglascollege.trainbot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginInRegister extends AppCompatActivity {

    private EditText userNameLogin;
    private EditText passwordLogin;

    private Button buttonLogin;

    private User user;
    private Validator validator;
    private Database databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        initListeners();
        initObjects();
    }
    private void initViews() {
        userNameLogin = (EditText) findViewById(R.id.editTextUsernameLogin);
        passwordLogin = (EditText) findViewById(R.id.editTextPasswordLogin);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
    }
    private void initListeners() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userNameLogin.getText().toString();
                String password = passwordLogin.getText().toString();
                User currentUser = new User();
                currentUser.setName(name);
                currentUser.setPassword(password);
                int id = checkUser(currentUser);

                if (id == -1){
                    Toast.makeText(LoginInRegister.this,"User Does Not Exist",Toast.LENGTH_SHORT).show();
                    emptyInputEditText();
                }
                else{
                    Toast.makeText(LoginInRegister.this,"Correct password",Toast.LENGTH_SHORT).show();
                    emptyInputEditText();
                }
            }
        });
        userNameLogin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        passwordLogin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
    }
    private void initObjects() {
        databaseHelper = new Database(LoginInRegister.this);
        user = new User();
        validator = new Validator(LoginInRegister.this);
    }
//    private void postDataToSQLite() {
//        if (!validator.isInputEditTextFilled(userNameLogin, getString(R.string.error_message_name))) {
//            return;
//        }
//        if (!validator.isInputEditTextFilled(userNameLogin, getString(R.string.error_message_email))) {
//            return;
//        }
//        if (!validator.isInputEditTextEmail(userNameLogin, getString(R.string.error_message_email))) {
//            return;
//        }
//        if (!validator.isInputEditTextFilled(passwordLogin, getString(R.string.error_message_password))) {
//            return;
//        }
//
//        if (!databaseHelper.checkUser(textInputLayoutName.getText().toString().trim())) {
//
//            user.setName(textInputLayoutName.getText().toString().trim());
//            user.setEmail(textInputLayoutEmail.getText().toString().trim());
//            user.setPassword(textInputLayoutPassword.getText().toString().trim());
//
//            databaseHelper.addUser(user);
//
//            Toast.makeText(Register.this,"User Created",Toast.LENGTH_SHORT).show();
//            emptyInputEditText();
//
//        } else {
//            Toast.makeText(Register.this,"Email already exists",Toast.LENGTH_SHORT).show();
//        }
//    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    private void emptyInputEditText() {
        userNameLogin.setText(null);
        passwordLogin.setText(null);
    }

    public int checkUser(User user) {
        return databaseHelper.checkUser(user);
    }
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        uname = findViewById(R.id.editTextUsernameLogin);
//        pswd = findViewById(R.id.editTextPasswordLogIn);
//        login = findViewById(R.id.button);


//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String name = uname.getText().toString();
//                String password = pswd.getText().toString();
//                User newuser = new User();
//                newuser.setName(name);
//                newuser.setPassword(password);
//                int id = checkUser(newuser);
//
//                if (id == -1){
//                    Toast.makeText(LoginInRegister.this,"User Does Not Exist",Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(LoginInRegister.this,"User exists",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//        db=new Database(LoginInRegister.this);
        //inserting dummy users
//        db.addUser(new User("Ankur", "Bansal"));
//        db.addUser(new User("Vibhor", "Tayal"));
//        db.addUser(new User("user1", "user1"));
//    }


}
