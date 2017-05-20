package com.partners.admin.home;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawer;
    LinearLayout opendrawer,videos,images,milestones;
    TextView title;
    Typeface type;

    private ViewPager vp_slider;
    private LinearLayout ll_dots;
    MyAdapter sliderPagerAdapter;
    ArrayList<Integer> slider_image_list;
    private TextView[] dots;
    int page_position = 0;
    private   Integer[] imageIDs = {

            R.drawable.img2,
            R.drawable.img1,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,

    };

     ImageView video,selectvideo,image,selectimage,milestone,selectmilestone;
     TextView videotxt,imagetxt,milestonetxt;
     View videoview,imageview,milestoneview;
     ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        type = Typeface.createFromAsset(getAssets(), "Font/TitilliumWeb-Bold.ttf");

        videos=(LinearLayout)findViewById(R.id.videos);
        videos.setOnClickListener(this);
        images=(LinearLayout)findViewById(R.id.images);
        images.setOnClickListener(this);
        milestones=(LinearLayout)findViewById(R.id.milestones);
        milestones.setOnClickListener(this);

        video=(ImageView)findViewById(R.id.video);
        selectvideo=(ImageView)findViewById(R.id.selectvideo);
        image=(ImageView)findViewById(R.id.image);
        selectimage=(ImageView)findViewById(R.id.selectimage);
        milestone=(ImageView)findViewById(R.id.milestone);
        selectmilestone=(ImageView)findViewById(R.id.selectmilestone);

        videotxt=(TextView)findViewById(R.id.videotxt);
        videotxt.setTypeface(type);

        imagetxt=(TextView)findViewById(R.id.imagetxt);
        imagetxt.setTypeface(type);

        milestonetxt=(TextView)findViewById(R.id.milestonetxt);
        milestonetxt.setTypeface(type);

        videoview=(View)findViewById(R.id.videoview);
        imageview=(View)findViewById(R.id.imageview);
        milestoneview=(View)findViewById(R.id.milestoneview);

        viewpager=(ViewPager)findViewById(R.id.viewpager);

        fragement_adapter adapter=new fragement_adapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);

           viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if(viewpager.getCurrentItem()==0)
                {
                    videoview.setVisibility(View.VISIBLE);
                    imageview.setVisibility(View.INVISIBLE);
                    milestoneview.setVisibility(View.INVISIBLE);

                    video.setVisibility(View.INVISIBLE);
                    selectvideo.setVisibility(View.VISIBLE);
                    image.setVisibility(View.VISIBLE);
                    selectimage.setVisibility(View.INVISIBLE);
                    milestone.setVisibility(View.VISIBLE);
                    selectmilestone.setVisibility(View.INVISIBLE);

                    videotxt.setTextColor(getResources().getColor(R.color.red));
                    imagetxt.setTextColor(getResources().getColor(R.color.gray));
                    milestonetxt.setTextColor(getResources().getColor(R.color.gray));
                }

                if(viewpager.getCurrentItem()==1)
                {
                    videoview.setVisibility(View.INVISIBLE);
                    imageview.setVisibility(View.VISIBLE);
                    milestoneview.setVisibility(View.INVISIBLE);

                    video.setVisibility(View.VISIBLE);
                    selectvideo.setVisibility(View.INVISIBLE);
                    image.setVisibility(View.INVISIBLE);
                    selectimage.setVisibility(View.VISIBLE);
                    milestone.setVisibility(View.VISIBLE);
                    selectmilestone.setVisibility(View.INVISIBLE);

                    videotxt.setTextColor(getResources().getColor(R.color.gray));
                    imagetxt.setTextColor(getResources().getColor(R.color.red));
                    milestonetxt.setTextColor(getResources().getColor(R.color.gray));
                }

                if(viewpager.getCurrentItem()==2)
                {
                    videoview.setVisibility(View.INVISIBLE);
                    imageview.setVisibility(View.INVISIBLE);
                    milestoneview.setVisibility(View.VISIBLE);

                    video.setVisibility(View.VISIBLE);
                    selectvideo.setVisibility(View.INVISIBLE);
                    image.setVisibility(View.VISIBLE);
                    selectimage.setVisibility(View.INVISIBLE);
                    milestone.setVisibility(View.INVISIBLE);
                    selectmilestone.setVisibility(View.VISIBLE);

                    videotxt.setTextColor(getResources().getColor(R.color.gray));
                    imagetxt.setTextColor(getResources().getColor(R.color.gray));
                    milestonetxt.setTextColor(getResources().getColor(R.color.red));
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        drawer = (DrawerLayout) findViewById(R.id.drawer);
        opendrawer = (LinearLayout) findViewById(R.id.opendrawer);
        opendrawer.setOnClickListener(this);

        title = (TextView) findViewById(R.id.title);
        title.setTypeface(type);
        init();

        addBottomDots(0);

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == slider_image_list.size()) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                vp_slider.setCurrentItem(page_position, true);
            }
        };
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 5000);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.opendrawer:
                drawer.openDrawer(Gravity.LEFT);
                break;
            case R.id.videos:
                viewpager.setCurrentItem(0);
                videoview.setVisibility(View.VISIBLE);
                imageview.setVisibility(View.INVISIBLE);
                milestoneview.setVisibility(View.INVISIBLE);

                video.setVisibility(View.INVISIBLE);
                selectvideo.setVisibility(View.VISIBLE);
                image.setVisibility(View.VISIBLE);
                selectimage.setVisibility(View.INVISIBLE);
                milestone.setVisibility(View.VISIBLE);
                selectmilestone.setVisibility(View.INVISIBLE);

                videotxt.setTextColor(getResources().getColor(R.color.red));
                imagetxt.setTextColor(getResources().getColor(R.color.gray));
                milestonetxt.setTextColor(getResources().getColor(R.color.gray));
                break;

            case R.id.images:
                viewpager.setCurrentItem(1);
                videoview.setVisibility(View.INVISIBLE);
                imageview.setVisibility(View.VISIBLE);
                milestoneview.setVisibility(View.INVISIBLE);

                video.setVisibility(View.VISIBLE);
                selectvideo.setVisibility(View.INVISIBLE);
                image.setVisibility(View.INVISIBLE);
                selectimage.setVisibility(View.VISIBLE);
                milestone.setVisibility(View.VISIBLE);
                selectmilestone.setVisibility(View.INVISIBLE);

                videotxt.setTextColor(getResources().getColor(R.color.gray));
                imagetxt.setTextColor(getResources().getColor(R.color.red));
                milestonetxt.setTextColor(getResources().getColor(R.color.gray));
                break;
            case R.id.milestones:
                viewpager.setCurrentItem(2);

                videoview.setVisibility(View.INVISIBLE);
                imageview.setVisibility(View.INVISIBLE);
                milestoneview.setVisibility(View.VISIBLE);

                video.setVisibility(View.VISIBLE);
                selectvideo.setVisibility(View.INVISIBLE);
                image.setVisibility(View.VISIBLE);
                selectimage.setVisibility(View.INVISIBLE);
                milestone.setVisibility(View.INVISIBLE);
                selectmilestone.setVisibility(View.VISIBLE);

                videotxt.setTextColor(getResources().getColor(R.color.gray));
                imagetxt.setTextColor(getResources().getColor(R.color.gray));
                milestonetxt.setTextColor(getResources().getColor(R.color.red));
                break;
        }
    }

    private void init() {

        vp_slider = (ViewPager) findViewById(R.id.vp_slider);
        ll_dots = (LinearLayout) findViewById(R.id.ll_dots);
        slider_image_list = new ArrayList<Integer>();

        slider_image_list.add(R.drawable.img2);
        slider_image_list.add(R.drawable.img1);
        slider_image_list.add(R.drawable.img3);
        slider_image_list.add(R.drawable.img4);
        slider_image_list.add(R.drawable.img5);

        sliderPagerAdapter = new MyAdapter(MainActivity.this, slider_image_list);
        vp_slider.setAdapter(sliderPagerAdapter);

        vp_slider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        }

    private void addBottomDots(int currentPage) {
        dots = new TextView[slider_image_list.size()];

        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#000000"));
            ll_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#FFFFFF"));
    }
}