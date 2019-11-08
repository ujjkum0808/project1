package com.example.collegeapp;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Fragmentcontact extends Fragment {
    public Fragmentcontact(){

    }
ImageView i,i2;
View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_fragmentcontact, container, false);
        i=v.findViewById(R.id.imageView3);
        i2=v.findViewById(R.id.imageView10);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2="23.5208916,87.3384995";
                Intent i3=new Intent(Intent.ACTION_VIEW);
                i3.setData(Uri.parse("geo:"+s2));
                Intent chooser=Intent.createChooser(i3,"Launch Maps");
                startActivity(chooser);
            }
        });

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Intent.ACTION_CALL);
               if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else {
                    i1.setData(Uri.parse("tel:" + "6204852596"));
                    startActivity(i1);
                }

            }
        });
        return v;
    }
}
