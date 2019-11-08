package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class notice extends AppCompatActivity {

     ListView lv;
     List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        preparedata();

        lv=findViewById(R.id.listview1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(notice.this,android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);

    }

    public void preparedata(){
        list=new ArrayList<>();
        list.add("Admission of aspiring eligible candidates in first year");
        list.add("Commencement of first year class");
        list.add("Notification for admission in BBA, BCA");
    }
}
