package ca.douglascollege.trainbot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class User {
    //variables
    int id;
    String name;
    String password;
    String email;
    // Constructor with two parameters name and password
//    public User(String name,String password)
//    {
//        this.name=name;
//        this.password=password;
//    }
//    //Parameter constructor containing all three parameters
//    public User(int id,String name,String psd,String eml)
//    {
//        this.id=id;
//        this.name=name;
//        this.password=psd;
//        this.email=eml;
//    }
    //getting id
    public int getId() {
        return id;
    }
    //setting id
    public void setId(int id) {
        this.id = id;
    }
    //getting name
    public String getName() {
        return name;
    }
    //setting name
    public void setName(String name) {
        this.name = name;
    }
    //getting password
    public String getPassword() {
        return password;
    }
    //setting password
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    //setting password
    public void setEmail(String email) {
        this.email = email;
    }
}
