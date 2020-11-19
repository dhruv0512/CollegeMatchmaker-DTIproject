package com.example.myapplication.ui.courses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Model;
import com.example.myapplication.MyAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ManageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        recyclerView=findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new MyAdapter(this,getMyList());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Model> getMyList(){
        ArrayList<Model> models= new ArrayList<>();
        Model m;
        m = new Model();
        m.setTitle("Indian Institute of Management Banglore-IIMB");
        m.setDescription("Banglore, Karnataka");
        m.setCourse("MBA - Masters Of Business Administration");
        m.setFees("₹2,315,000 total");
        m.setImg(R.drawable.iitb);
        models.add(m);

        m=new Model();
        m.setTitle("Indian Institute of Management Ahmedabad-IIMA");
        m.setDescription("Ahmedabad, Gujrat");
        m.setCourse("MBA - Masters Of Business Administration");
        m.setFees("₹2,300,000 per year");
        m.setImg(R.drawable.iitd);
        models.add(m);

        m=new Model();
        m.setTitle("University of Delhi, Faculty of Management Studies-FMS");
        m.setDescription("New Delhi, Delhi NCR");
        m.setCourse("MBA - Masters Of Business Administration");
        m.setFees("₹96,000 per year");
        m.setImg(R.drawable.bits);
        models.add(m);

        m=new Model();
        m.setTitle("Bennett University");
        m.setDescription("Greater Noida, Uttar Pradesh");
        m.setCourse("MBA - Masters Of Business Administration");
        m.setFees("₹775,000 per year");
        m.setImg(R.drawable.bu);
        models.add(m);



        return models;
    }
}