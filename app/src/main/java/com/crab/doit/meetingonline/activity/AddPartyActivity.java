package com.crab.doit.meetingonline.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.crab.doit.meetingonline.R;

/**
 * Created by pangjiaqi on 2017/3/1.
 */

public class AddPartyActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_party);
    }
}
