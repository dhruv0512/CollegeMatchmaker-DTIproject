package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.ui.courses.ArcActivity;
import com.example.myapplication.ui.courses.ArtActivity;
import com.example.myapplication.ui.courses.DesActivity;
import com.example.myapplication.ui.courses.EngActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.courses.LawActivity;
import com.example.myapplication.ui.courses.ManageActivity;
import com.example.myapplication.ui.courses.McommActivity;
import com.example.myapplication.ui.courses.MedActivity;
import com.example.myapplication.ui.courses.MoreActivity;
import com.example.myapplication.ui.search.SearchFragment;

public class HomeFragment extends Fragment  {

    private HomeViewModel homeViewModel;
    private CardView cardManage, cardEng, cardMed, cardLaw, cardMcomm, cardArt, cardArc, cardDes, cardMore;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        cardManage=root.findViewById(R.id.cardManage);
        cardEng=root.findViewById(R.id.cardEngineering);
        cardMed=root.findViewById(R.id.cardMedical);
        cardLaw=root.findViewById(R.id.cardLaw);
        cardMcomm=root.findViewById(R.id.cardMass);
        cardArc=root.findViewById(R.id.cardArchitecture);
        cardArt=root.findViewById(R.id.cardArts);
        cardDes=root.findViewById(R.id.cardDesign);
        cardMore=root.findViewById(R.id.cardMore);
        cardManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cardManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManage();
            }
        });

        cardEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openEng();
            }
        });
        cardMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMed();
            }
        });

        cardLaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLaw();
            }
        });
        cardArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArt();
            }
        });
        cardArc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openArc();
            }
        });
        cardDes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDes();
            }
        });
        cardMcomm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMcomm();
            }
        });
        cardMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMore();
            }
        });

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    public void openManage(){
        Intent intent= new Intent(getActivity(), ManageActivity.class);
        startActivity(intent);

    }
    public void openEng(){
        Intent intent= new Intent(getActivity(), EngActivity.class);
        startActivity(intent);

    }

    public void openMed(){
        Intent intent= new Intent(getActivity(), MedActivity.class);
        startActivity(intent);

    }

    public void openLaw(){
        Intent intent= new Intent(getActivity(), LawActivity.class);
        startActivity(intent);

    }

    public void openMcomm(){
        Intent intent= new Intent(getActivity(), McommActivity.class);
        startActivity(intent);

    }

    public void openArt(){
        Intent intent= new Intent(getActivity(), ArtActivity.class);
        startActivity(intent);

    }

    public void openArc(){
        Intent intent= new Intent(getActivity(), ArcActivity.class);
        startActivity(intent);

    }

    public void openDes(){
        Intent intent= new Intent(getActivity(), DesActivity.class);
        startActivity(intent);

    }

    public void openMore(){
        Intent intent= new Intent(getActivity(), MoreActivity.class);
        startActivity(intent);

    }



}