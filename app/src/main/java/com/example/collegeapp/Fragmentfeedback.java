package com.example.collegeapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Fragmentfeedback extends Fragment {

    Button submit;
    EditText feedback;
    View v;
    Toast t;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_fragmentfeedback, container, false);

        submit=v.findViewById(R.id.submit);
        feedback=v.findViewById(R.id.feedback);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedbackresult();
            }
        });
        return v;
    }

    public void feedbackresult(){
        String feed=feedback.getText().toString().trim();
        if(TextUtils.isEmpty(feed))
        {
            t=Toast.makeText(getContext(),"Please write feedback",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }
        else{
            t=Toast.makeText(getContext(),"Successfully Submmitted",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }
    }

}
