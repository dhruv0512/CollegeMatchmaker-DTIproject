package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    private Button login, signUp;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        login= (Button) findViewById(R.id.loginbutton);
        db= new DatabaseHelper(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if(user.equals("")||pass.equals("")){
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean checkUser=db.checkUsernamePassword(user,pass);
                    if(checkUser==true){
                        Toast.makeText(MainActivity.this, "Sign In successful", Toast.LENGTH_SHORT).show();
                        openMenu();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signUp=(Button) findViewById(R.id.signupbutton);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu2();
            }
        });

    }
    public void openMenu(){
        Intent intent= new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
    public void openMenu2(){
        Intent intent= new Intent(this, Registeration.class);
        startActivity(intent);
    }
}
