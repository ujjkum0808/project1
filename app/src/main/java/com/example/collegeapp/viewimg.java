package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class viewimg extends AppCompatActivity {
ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewimg);

        iv=findViewById(R.id.image);

        Intent i1=getIntent();
        int pos= i1.getExtras().getInt("id");
        GridViewAdaptor ad=new GridViewAdaptor(this);
        iv.setImageResource(ad.mThumbIds[pos]);
    }
}
