package com.partners.admin.home;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Admin on 5/19/2017.
 */

public class video_fragement_list_adapter extends BaseAdapter {

    ImageView music,times;
    TextView head,hour,desc;
    LayoutInflater in;
    Context context;
    ArrayList<HashMap<String,String>> a;
    HashMap<String,String> m=new HashMap<String, String>();
Typeface type;
    public video_fragement_list_adapter(Context context, ArrayList<HashMap<String, String>> array) {
         this.context=context;
        a=array;
    }

    @Override
    public int getCount() {
        return a.size();
    }

    @Override
    public Object getItem(int position) {
        return a.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        in=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v=in.inflate(R.layout.list_adapter,parent,false);
        Typeface type = Typeface.createFromAsset(context.getAssets(), "Font/TitilliumWeb-Bold.ttf");
        music=(ImageView)v.findViewById(R.id.itemsimg);
        times=(ImageView)v.findViewById(R.id.timer);
        head=(TextView)v.findViewById(R.id.items_head);head.setTypeface(type);
        hour=(TextView)v.findViewById(R.id.hours);hour.setTypeface(type);
        desc=(TextView)v.findViewById(R.id.itemsdesc);desc.setTypeface(type);

        m=a.get(position);

        music.setImageResource(Integer.parseInt(m.get(Video_fragement.item_images)));
        times.setImageResource(Integer.parseInt(m.get(Video_fragement.timers)));
        head.setText(m.get(Video_fragement.item_heads));
        hour.setText(m.get(Video_fragement.hours));
        desc.setText(m.get(Video_fragement.itemdescs));

        return v;
    }
}
