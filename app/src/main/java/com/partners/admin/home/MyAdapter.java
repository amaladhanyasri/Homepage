package com.partners.admin.home;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Admin on 5/19/2017.
 */

public class MyAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    Activity activity;
    ArrayList<Integer> image_arraylist;

    public MyAdapter(Activity activity, ArrayList<Integer> image_arraylist) {
        this.activity = activity;
        this.image_arraylist = image_arraylist;
    }

      @Override
    public int getCount() {
        return image_arraylist.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slide, container, false);
        ImageView im_slider = (ImageView) view.findViewById(R.id.image);
        Picasso.with(activity.getApplicationContext())
                .load(image_arraylist.get(position))
                .placeholder(R.mipmap.ic_launcher) // optional
                .error(R.mipmap.ic_launcher)         // optional
                .into(im_slider);


        container.addView(view);

        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}