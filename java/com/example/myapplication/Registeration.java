package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Registeration extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button submit;
    EditText username, password, email, name, rePassword;
    DatabaseHelper db;
    String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        radioGroup=findViewById(R.id.radioGroup);
        username=(EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        email=(EditText) findViewById(R.id.email);
        name=(EditText) findViewById(R.id.fullName);
        rePassword=(EditText) findViewById(R.id.confirmPassword);
        radioGroup.setOnCheckedChangeListener(this);
        submit=findViewById(R.id.regSubmit);
        db=new DatabaseHelper(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String fName=name.getText().toString();
                String mail=email.getText().toString();
                String rePass=rePassword.getText().toString();
                if(user.equals("")||pass.equals("")||fName.equals("")||mail.equals("")||rePass.equals(""))
                    Toast.makeText(Registeration.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(rePass)){
                        boolean checkUser=db.checkUsername(user);
                        if (checkUser==false){
                            boolean insert=db.insertData(fName,gender,mail,user,pass);
                            if (insert==true){
                                Toast.makeText(Registeration.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                openMenu();

                            }
                            else {
                                Toast.makeText(Registeration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(Registeration.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Registeration.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }


        });


    }
    public void openMenu(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch(checkedId){
            case R.id.radio1:
                gender="Male";
                break;
            case R.id.radio2:
                gender="Female";
                break;
            case R.id.radio3:
                gender="Others";
                break;

        }
    }
}
