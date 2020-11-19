package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mTitle, mDes, mCourse, mFee;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImageView=itemView.findViewById(R.id.college_icon);
        this.mTitle=itemView.findViewById(R.id.title);
        this.mDes=itemView.findViewById(R.id.description);
        this.mCourse=itemView.findViewById(R.id.course);
        this.mFee=itemView.findViewById(R.id.fees);
    }
}
