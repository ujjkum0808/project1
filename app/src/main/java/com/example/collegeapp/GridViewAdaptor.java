package com.example.collegeapp;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewAdaptor extends BaseAdapter {
    private Context con;
    public Integer[] mThumbIds={ R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.u1,
            R.drawable.u2,R.drawable.u3,R.drawable.u4,R.drawable.u5,R.drawable.u6,R.drawable.u7,R.drawable.u8,
            R.drawable.u9,R.drawable.u10,R.drawable.u11 };

    public GridViewAdaptor(Context c) {
        con=c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView=new ImageView(con);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(getScreenWidth(),600));
        return imageView;
    }
    private int getScreenWidth(){
        DisplayMetrics dm=new DisplayMetrics();
        int widthindp=0;
        WindowManager wm=(WindowManager) con.getSystemService(con.WINDOW_SERVICE);
        if(wm !=null)
        {
            wm.getDefaultDisplay().getMetrics(dm);
        }
        widthindp=Math.round(dm.widthPixels / dm.density);
        return widthindp;
    }
}
