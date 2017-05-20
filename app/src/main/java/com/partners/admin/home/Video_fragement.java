package com.partners.admin.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Admin on 5/19/2017.
 */

public class Video_fragement extends Fragment {

    int[] item_image={R.drawable.mu1,R.drawable.mu2,R.drawable.mu3,R.drawable.mu4,R.drawable.mu5};
    int[] timer={R.drawable.timer,R.drawable.timer,R.drawable.timer,R.drawable.timer,R.drawable.timer};
    String[] item_head={"Emptiness ft. justin ","I 'm falling love with you","baby ft. justin baber","white horse ft. taylor","Emptiness ft. justin"};
    String[] hour={"18 hours ago","22 hours ago","20 hours ago","25 hours ago","32 hours ago"};
    String[] itemdesc={"Loreum Ipsum is simply dummy text of the printing and typesetting industry",
                       "Loreum Ipsum is simply dummy text of the printing and typesetting industry",
                        "Loreum Ipsum is simply dummy text of the printing and typesetting industry",
                        "Loreum Ipsum is simply dummy text of the printing and typesetting industry",
                        "Loreum Ipsum is simply dummy text of the printing and typesetting industry"};
    ArrayList<HashMap<String,String>> array=new ArrayList<HashMap<String, String>>();
    public static String item_images="item_images";
    public static String timers="timers";
    public static String item_heads="item_heads";
    public static String hours="hours";
    public static String itemdescs="itemdescs";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.video_fragment,container,false);
        ListView list=(ListView)v.findViewById(R.id.list);
        for(int i=0;i<item_head.length;i++)
        {
            HashMap<String,String> map=new HashMap<String, String>();
            map.put("item_images",String.valueOf(item_image[i]));
            map.put("timers",String.valueOf(timer[i]));
            map.put("item_heads",item_head[i]);
            map.put("hours",hour[i]);
            map.put("itemdescs",itemdesc[i]);
            array.add(map);
        }

        video_fragement_list_adapter adapter=new video_fragement_list_adapter(getActivity(),array);
        list.setAdapter(adapter);
        return v;
    }
}
