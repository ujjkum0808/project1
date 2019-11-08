package com.example.collegeapp;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class Fragmenthome extends Fragment {
View v;
ViewFlipper vf;
Button achive,b7,b8,about;
ImageView ifacebook,insta,twiter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_fragmenthome, container, false);
        achive=v.findViewById(R.id.button5);
        vf=v.findViewById(R.id.flip);
        b8=v.findViewById(R.id.button8);
        b7=v.findViewById(R.id.button7);
        about=v.findViewById(R.id.button6);

        ifacebook=v.findViewById(R.id.facebook);
        insta=v.findViewById(R.id.instagram);
        twiter=v.findViewById(R.id.twiter);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu pop=new PopupMenu(getActivity(),about);
                pop.getMenuInflater().inflate(R.menu.menu_popabout,pop.getMenu());
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        //Toast.makeText(getContext(),"itemclicked: "+ menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        if(menuItem.getTitle().equals("About Bcet"))
                        {
                            Intent i1=new Intent(getContext(),about_bcet.class);
                            startActivity(i1);
                        }
                        else if(menuItem.getTitle().equals("About Sksgi"))
                        {
                            Intent i1=new Intent(getContext(),about_sksgi.class);
                            startActivity(i1);
                        }
                        else if(menuItem.getTitle().equals("Campus Durgapur"))
                        {
                            Intent i1=new Intent(getContext(),campusdgr.class);
                            startActivity(i1);
                        }
                        else if(menuItem.getTitle().equals("Messages"))
                        {
                            Intent i1=new Intent(getContext(),messages.class);
                            startActivity(i1);
                        }
                        return true;
                    }
                });
                pop.show();
            }
        });

        twiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.twitter.com/@UjjwalK77078443"));
                startActivity(i1);
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/ujjkum0808"));
                startActivity(i1);
            }
        });

        ifacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/ujjwal.kumar.3323457"));
                startActivity(i1);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getActivity().getApplicationContext(),register.class);
                startActivity(i1);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice();
            }
        });

        int images[]={R.drawable.bcet1, R.drawable.b5, R.drawable.b4};
        for(int image:images)
        {
            flipimage(image);
        }

        achive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getActivity().getApplicationContext(),achivement.class);
                startActivity(i1);
            }
        });
        return v;
    }

    public void flipimage(int images){
        ImageView iv=new ImageView(getContext());
        iv.setBackgroundResource(images);

        vf.addView(iv);
        vf.setFlipInterval(3000);
        vf.setAutoStart(true);

        vf.setInAnimation(getContext(),android.R.anim.slide_in_left);
        vf.setOutAnimation(getContext(),android.R.anim.slide_out_right);
    }

    public void notice(){
        Intent i1=new Intent(getActivity().getApplicationContext(),notice.class);
        startActivity(i1);
    }

}