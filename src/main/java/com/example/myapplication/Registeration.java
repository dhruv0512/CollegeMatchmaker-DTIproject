package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Registeration extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        radioGroup=findViewById(R.id.radioGroup);

        submit=findViewById(R.id.regSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();

            }


        });


    }
    public void openMenu(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
