package com.example.collegeapp;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Fragmentgallery extends Fragment {
    GridView g;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_fragmentgallery, container, false);
        g=v.findViewById(R.id.grid);
        g.setAdapter(new GridViewAdaptor(getActivity()));

        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                ActivityOptions option=ActivityOptions.makeSceneTransitionAnimation(getActivity());
                Intent i1=new Intent(getContext(),viewimg.class);
                i1.putExtra("id",pos);
                startActivity(i1);
            }
        });
        return v;
    }
}
