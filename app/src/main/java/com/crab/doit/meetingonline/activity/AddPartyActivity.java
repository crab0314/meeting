package com.crab.doit.meetingonline.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.crab.doit.meetingonline.R;

/**
 * Created by pangjiaqi on 2017/3/1.
 */

public class AddPartyActivity extends Activity {

    private static int ADD_PARTICIPATE = 0;
    private static int DEC_PARTICIPATE = 1;

    private int parties = 0;

    private Button confirm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_party);
        confirm = (Button) findViewById(R.id.confirm);
    }

    private void setParties(int parties) {
        if (parties < 0)
            return;
        this.parties = parties;

        if (parties == 0) {
            confirm.setEnabled(false);
            confirm.setText(getResources().getString(R.string.confirm_gray));
        } else {
            confirm.setEnabled(true);
            confirm.setText(getResources().getString(R.string.confirm_number, parties));
        }
    }

    public void click(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                finish();
                break;
            case R.id.confirm:
                enterMeeting();
                break;
            case R.id.add:
                ChangePerson(ADD_PARTICIPATE);
                break;
            case R.id.dec:
                ChangePerson(DEC_PARTICIPATE);
                break;
            default:
                break;
        }
    }

    private void enterMeeting() {
        Intent intent = new Intent(AddPartyActivity.this, OnMeetingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("count",parties);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    private void ChangePerson(int choice) {
        switch (choice) {
            case 0:
                setParties(parties+1);
                break;
            case 1:
                setParties(parties-1);
                break;
        }
    }
}
