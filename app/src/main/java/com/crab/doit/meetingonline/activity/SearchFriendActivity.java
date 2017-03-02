package com.crab.doit.meetingonline.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.crab.doit.meetingonline.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by pangjiaqi on 2017/3/1.
 */

public class SearchFriendActivity extends Activity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_friend);
        editText = (EditText) findViewById(R.id.editText);
        setAutoPop();
        setTextSearch();
    }

    private void setAutoPop() {
        //设置键盘自动弹起
        editText.setFocusable(true);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
                           public void run() {
                               InputMethodManager inputManager =
                                       (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                               inputManager.showSoftInput(editText, 0);
                           }
                       },
                200);
    }

    private void setTextSearch() {
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    //doSearch();
                    return true;
                }
                return false;
            }
        });
    }

    public void click(View view){
        switch (view.getId()){
            case R.id.cancel:
                finish();
                break;
            default:
                break;
        }
    }
}
