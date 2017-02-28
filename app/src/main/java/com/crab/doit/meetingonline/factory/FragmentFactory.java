package com.crab.doit.meetingonline.factory;

import android.app.Fragment;

import com.crab.doit.meetingonline.R;
import com.crab.doit.meetingonline.fragment.CenterFragment;
import com.crab.doit.meetingonline.fragment.ContactFragment;

/**
 * Created by pangjiaqi on 2016/11/30.
 */

public class FragmentFactory {
    public static Fragment getInstanceByIndex(int index) {
        Fragment fragment = null;
        switch (index) {
            case R.id.rb_contact:
                fragment = new ContactFragment();
                break;
            case R.id.rb_center:
                fragment = new CenterFragment();
                break;
            default:
                break;
        }
        return fragment;
    }
}
