package com.example.collegeapp;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Fragmentcourses extends Fragment{
   /* HashMap<String, List<String>> myHeader;
    List<String> myChild;
    ExpandableListView explist;
    MyAdapter adapter;*/
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_fragmentcourses, container, false);

     /*   explist=v.findViewById(R.id.expandlistview);
        myHeader=MyAdapter.Dataprovider.getInfo();
        myChild=new ArrayList<String>(myHeader.keySet());
        adapter=new MyAdapter(getContext(),myHeader,myChild);
        explist.setAdapter(adapter);*/

        return v;
    }
}
/*
class MyAdapter extends BaseExpandableListAdapter {
    private Context ctx;
    private HashMap<String, List<String>> Childtitles;
    private List<String> Headertitles;

    MyAdapter(Context ctx, HashMap<String, List<String>> Childtitles, List<String> Headertitles) {
        this.ctx = ctx;
        this.Childtitles = Childtitles;
        this.Headertitles = Headertitles;
    }

    @Override
    public int getGroupCount() {
        return Headertitles.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return Childtitles.get(Headertitles.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return Headertitles.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return Childtitles.get(Headertitles.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) this.getGroup(i);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_header, null);
        }
        TextView txt = (TextView) view.findViewById(R.id.idtitle);
        txt.setTypeface(null, Typeface.BOLD);
        txt.setText(title);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) this.getChild(i, i1);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_child, null);
        }
        TextView txt = (TextView) view.findViewById(R.id.idchild);
        txt.setText(title);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

}
   public class Dataprovider {
        public static HashMap<String, List<String>> getInfo() {
            HashMap<String, List<String>> Headerdetails = new HashMap<String, List<String>>();
            List<String> Childdetails1 = new ArrayList<String>();
            Childdetails1.add("child1");
            Childdetails1.add("child1");
            Childdetails1.add("child1");

            List<String> Childdetails2 = new ArrayList<String>();
            Childdetails2.add("child2");
            Childdetails2.add("child2");
            Childdetails2.add("child2");

            List<String> Childdetails3 = new ArrayList<String>();
            Childdetails3.add("child3");
            Childdetails3.add("child3");
            Childdetails3.add("child3");

            Headerdetails.put("header1", Childdetails1);
            Headerdetails.put("header2", Childdetails2);
            Headerdetails.put("header3", Childdetails3);

            return Headerdetails;
        }
    }
*/
