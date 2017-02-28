package com.crab.doit.meetingonline.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;

import com.crab.doit.meetingonline.R;
import com.crab.doit.meetingonline.status.NetWorkStatus;
import com.crab.doit.meetingonline.utils.ToastUtils;

/**
 * Created by pangjiaqi on 2016/11/30.
 */

public class SplashActivity extends Activity {
//TODO 默认是wifi状态
    private int netStatus = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        checkForNet();
    }

    /**
     * 检查当前网络状态，
     * 查看能否连接到网络
     */
    public void checkForNet() {
        switch (netStatus) {
            case NetWorkStatus.NO_NET_WORK:
                ToastUtils.ToastLong(SplashActivity.this, R.string.network_not_available);
                break;
            case NetWorkStatus.NET_2G:
            case NetWorkStatus.NET_3G:
            case NetWorkStatus.NET_4G:
            case NetWorkStatus.NET_5G:
                showWarningDialog();
                break;
            case NetWorkStatus.NET_WIFI:
                JumpToLogin(true);
                break;
            default:
                break;
        }
    }

    public void showWarningDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setIcon(R.mipmap.warning);
        alertDialog.setTitle(R.string.warn_network);
        alertDialog.setMessage(R.string.network_2g_5g_available);
        alertDialog.setPositiveButton(R.string.positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                JumpToLogin(false);
            }
        });
        alertDialog.setNegativeButton(R.string.negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.create().show();
    }

    public void JumpToLogin(boolean isWifi) {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        intent.putExtra("status",isWifi);
        startActivity(intent);
        finish();
    }
}
