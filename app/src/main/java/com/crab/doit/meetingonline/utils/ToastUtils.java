package com.crab.doit.meetingonline.utils;

import android.content.Context;
import android.widget.Toast;

import com.crab.doit.meetingonline.R;

/**
 * Created by pangjiaqi on 2016/11/30.
 */

public class ToastUtils {
    public static void ToastShort(Context context,String string){
        Toast.makeText(context, string,Toast.LENGTH_SHORT).show();
    }

    public static void ToastShort(Context context,int resId){
        Toast.makeText(context,resId,Toast.LENGTH_SHORT).show();
    }

    public static void ToastLong(Context context,String string){
        Toast.makeText(context,string,Toast.LENGTH_LONG).show();
    }

    public static void ToastLong(Context context,int resId){
        Toast.makeText(context,resId,Toast.LENGTH_LONG).show();
    }
}
