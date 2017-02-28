package com.crab.doit.meetingonline.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;

import com.crab.doit.meetingonline.R;
import com.crab.doit.meetingonline.factory.FragmentFactory;

/**
 * Created by pangjiaqi on 2016/11/30.
 */

public class HomeActivity extends Activity {

    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        fragmentManager = getFragmentManager();
        fillContent(R.id.rb_contact);

        radioGroup = (RadioGroup) findViewById(R.id.ll_rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                fillContent(i);
            }
        });
    }

    public void fillContent(int i) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = FragmentFactory.getInstanceByIndex(i);
        transaction.replace(R.id.content_home, fragment).commit();
    }
}
