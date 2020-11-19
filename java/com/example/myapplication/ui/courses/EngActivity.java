package com.example.myapplication.ui.courses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.Model;
import com.example.myapplication.MyAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class EngActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new MyAdapter(this,getMyList());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Model> getMyList(){
        ArrayList<Model> models= new ArrayList<>();
        Model m;
        m = new Model();
        m.setTitle("Indian Institute of Technology Bombay-IITB");
        m.setDescription("Mumbai, Maharashtra");
        m.setCourse("BE/B.Tech - Bachelor of Technology");
        m.setFees("₹211,400 per year");
        m.setImg(R.drawable.iitb);
        models.add(m);

        m=new Model();
        m.setTitle("Indian Institute of Technology Delhi-IITD");
        m.setDescription("New Delhi, Delhi NCR");
        m.setCourse("BE/B.Tech - Bachelor of Technology");
        m.setFees("₹224,900 per year");
        m.setImg(R.drawable.iitd);
        models.add(m);

        m=new Model();
        m.setTitle("Birla Institute of Technology and Science-BITS");
        m.setDescription("Pilani, Rajasthan");
        m.setCourse("BE/B.Tech - Bachelor of Technology");
        m.setFees("₹423,475 per year");
        m.setImg(R.drawable.bits);
        models.add(m);

        m=new Model();
        m.setTitle("Bennett University");
        m.setDescription("Greater Noida, Uttar Pradesh");
        m.setCourse("BE/B.Tech - Bachelor of Technology");
        m.setFees("₹425,000 per year");
        m.setImg(R.drawable.bu);
        models.add(m);



        return models;
    }
}