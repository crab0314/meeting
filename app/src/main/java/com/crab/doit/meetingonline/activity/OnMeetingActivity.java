package com.crab.doit.meetingonline.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.crab.doit.meetingonline.R;


/**
 * Created by pangjiaqi on 2017/3/2.
 */

public class OnMeetingActivity extends Activity {
    private TextView title;

    private int sum_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);
        title = (TextView) findViewById(R.id.title);
        Bundle bundle = getIntent().getExtras();
        int added = bundle.getInt("count");
        sum_count += added;
        title.setText(getResources().getString(R.string.on_meeting, sum_count));
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.quit:
                confirmQuit();
                break;
        }
    }

    public void confirmQuit() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.quit_title));
        builder.setMessage(getResources().getString(R.string.quit_message));
        builder.setPositiveButton(getResources().getString(R.string.positive), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                OnMeetingActivity.this.finish();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.negative), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}
