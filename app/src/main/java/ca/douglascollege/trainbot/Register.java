package ca.douglascollege.trainbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText textInputLayoutName;
    private EditText textInputLayoutEmail;
    private EditText textInputLayoutPassword;
    private EditText textInputLayoutConfirmPassword;

    private Button buttonRegister;
    private Button buttonLoginLink;

    private Database databaseHelper;
    private User user;
    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        initListeners();
        initObjects();
    }
    private void initViews() {



        textInputLayoutName = (EditText) findViewById(R.id.editTextUsername);
        textInputLayoutEmail = (EditText) findViewById(R.id.editTextEmail);
        textInputLayoutPassword = (EditText) findViewById(R.id.editTextPassword);
        textInputLayoutConfirmPassword = (EditText) findViewById(R.id.editTextReenterPassword);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonLoginLink = (Button) findViewById(R.id.buttonGoToLogin);

    }
    private void initListeners() {
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postDataToSQLite();
            }
        });
        buttonLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regiIntent = new Intent(Register.this, LoginInRegister.class);
                startActivity(regiIntent);
            }
        });

    }
    private void initObjects() {
        databaseHelper = new Database(Register.this);
        user = new User();
        validator = new Validator(Register.this);
    }

    private void postDataToSQLite() {
        if (!validator.isInputEditTextFilled(textInputLayoutName, getString(R.string.error_message_name))) {
            return;
        }
        if (!validator.isInputEditTextFilled(textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!validator.isInputEditTextEmail(textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!validator.isInputEditTextFilled(textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (!validator.isInputEditTextMatches(textInputLayoutPassword,
                textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
            return;
        }

        if (!databaseHelper.checkUser(textInputLayoutName.getText().toString().trim())) {

            user.setName(textInputLayoutName.getText().toString().trim());
            user.setEmail(textInputLayoutEmail.getText().toString().trim());
            user.setPassword(textInputLayoutPassword.getText().toString().trim());

            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Toast.makeText(Register.this,"User Created",Toast.LENGTH_SHORT).show();
            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(Register.this,"Email already exists",Toast.LENGTH_SHORT).show();
        }


    }
    private void emptyInputEditText() {
        textInputLayoutName.setText(null);
        textInputLayoutEmail.setText(null);
        textInputLayoutPassword.setText(null);
        textInputLayoutConfirmPassword.setText(null);
    }
    /**
     * This method is to initialize objects to be used
     */

}
