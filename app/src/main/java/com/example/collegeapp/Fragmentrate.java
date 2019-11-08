package com.example.collegeapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Fragmentrate extends Fragment {
RatingBar rate,rb;
TextView t1;
View v,layout;
RelativeLayout ri;
Button submit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fragmentrate, container, false);
        layout=inflater.inflate(R.layout.rate,(ViewGroup)v.findViewById(R.id.rate_layout));
        rate = v.findViewById(R.id.rate);
         submit = v.findViewById(R.id.button2);
        // ri = v.findViewById(R.id.rate_layout);
         t1 = layout.findViewById(R.id.textView5);
         rb = layout.findViewById(R.id.ratingBar);
       // LayoutInflater inf = getLayoutInflater();
       // layout = inf.inflate(R.layout.rate, (ViewGroup)ri);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });

        return v;
    }
    public void show(){
        float ratevalue=rate.getRating();
        rb.setRating(ratevalue);
        t1.setText(String.valueOf(ratevalue));
        Toast tost=Toast.makeText(getContext(),"Toast :Gravity.TOP",Toast.LENGTH_SHORT);
        tost.setGravity(Gravity.CENTER,0,0);
        tost.setView(layout);
        tost.show();
    }

    }

