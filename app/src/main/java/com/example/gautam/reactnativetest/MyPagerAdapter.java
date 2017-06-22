package com.example.gautam.reactnativetest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by gautam on 16/06/17.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {//

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    ReactNativeFragment firstFragment, thirdFragment;
    BlankFragment secondFragment;

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                firstFragment = new ReactNativeFragment();
                return firstFragment;
            case 1:
                secondFragment = new BlankFragment();
                return secondFragment;
            case 2:
                return new BlankFragment();
            case 3:
                thirdFragment = new ReactNativeFragment();
                return thirdFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "page 0";
            case 1:
                return "page 1";
            case 2:
                return "page 2";
            case 3:
                return "page 3";
        }
        return "";
    }

    public void onPageSelected(int position) {

        if (position == 0) {
            if (secondFragment != null) {
                secondFragment.onPageUnselected();
            }
            if (thirdFragment != null) {
                thirdFragment.onPageUnselected();
            }
            firstFragment.onPageSelected();
        } else if (position == 1) {
            if (firstFragment != null) {
                firstFragment.onPageUnselected();
            }
            if (thirdFragment != null) {
                thirdFragment.onPageUnselected();
            }
            secondFragment.onPageSelected();
        } else if (position == 3) {
            if (firstFragment != null) {
                firstFragment.onPageUnselected();
            }
            if (secondFragment != null) {
                secondFragment.onPageUnselected();
            }
            thirdFragment.onPageSelected();
        }
    }
}
