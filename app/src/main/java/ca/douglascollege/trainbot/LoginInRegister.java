package ca.douglascollege.trainbot;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginInRegister extends AppCompatActivity {

    EditText uname, pswd;
    Button login;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uname = findViewById(R.id.editTextUsername);
        pswd = findViewById(R.id.editTextPasswiord);
        login = findViewById(R.id.buttonLogin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = uname.getText().toString();
                String password = pswd.getText().toString();
                User newuser = new User();
                newuser.setName(name);
                newuser.setPassword(password);
                int id = checkUser(newuser);

                if (id == -1){
                    Toast.makeText(LoginInRegister.this,"User Does Not Exist",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoginInRegister.this,"User exists",Toast.LENGTH_SHORT).show();
                }
            }
        });

        db=new Database(LoginInRegister.this);
        //inserting dummy users
//        db.addUser(new User("Ankur", "Bansal"));
//        db.addUser(new User("Vibhor", "Tayal"));
//        db.addUser(new User("user1", "user1"));
    }

    public int checkUser(User user) {
        return db.checkUser(user);
    }
}
