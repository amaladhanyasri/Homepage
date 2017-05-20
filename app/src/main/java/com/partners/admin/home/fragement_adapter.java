package com.partners.admin.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Admin on 5/19/2017.
 */

public class fragement_adapter extends FragmentPagerAdapter {
    public fragement_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new Video_fragement();
            case 1:
                return new Image_fragment();
            case 2:
                return new Milestone_fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
