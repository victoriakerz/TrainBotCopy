package ca.douglascollege.trainbot;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
//    EditText uname,pswd;
//    Button login;
//    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        uname=(EditText)findViewById(R.id.editTextUsername);
//        pswd=(EditText)findViewById(R.id.editTextPasswiord);
//        login=(Button)findViewById(R.id.buttonLogin);
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
//
//        db=new Database(MainActivity.this);
////inserting dummy users
//        db.addUser(new User("Ankur", "Bansal"));
//        db.addUser(new User("Vibhor", "Tayal"));
//        db.addUser(new User("Jatin", "Garg"));
//    }
//    public int checkUser(User user)
//    {
//        return db.checkUser(user);
//    }

}}