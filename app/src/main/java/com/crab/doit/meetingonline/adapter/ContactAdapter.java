package com.crab.doit.meetingonline.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.crab.doit.meetingonline.R;
import com.crab.doit.meetingonline.bean.ContactInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pangjiaqi on 2017/2/27.
 */

public class ContactAdapter extends BaseAdapter {

    public static final int ON_LINE = 0;
    public static final int OFF_LINE = 1;

    private LayoutInflater inflater;
    private Context context;

    public List<ContactInfo> contactInfoList = new ArrayList<>();

    public void setData(List<ContactInfo> list) {
        contactInfoList = list;
    }

    public List<ContactInfo> getData() {
        return contactInfoList;
    }

    public ContactAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (contactInfoList.size() > 0)
            return contactInfoList.size();
        return 0;
    }

    @Override
    public ContactInfo getItem(int i) {
        return contactInfoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ContactInfo contactInfo = contactInfoList.get(i);
        String name = contactInfo.getName();
        int state = contactInfo.getUserState();

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_contact, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.name = (TextView) convertView.findViewById(R.id.userName);
            viewHolder.state = (TextView) convertView.findViewById(R.id.userState);
            viewHolder.button = (Button) convertView.findViewById(R.id.button);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //viewHolder.imageView=;//头像的获取方式
        viewHolder.name.setText(name);
        if (state == ON_LINE) {
            viewHolder.state.setText(R.string.on_line);
            viewHolder.state.setTextColor(context.getResources().getColor(R.color.mainBlue));
        } else if (state == OFF_LINE) {
            viewHolder.state.setText(R.string.off_line);
            viewHolder.state.setTextColor(context.getResources().getColor(R.color.dark_gray));
        }
        return convertView;
    }

    public class ViewHolder {
        ImageView imageView;
        TextView name;
        TextView state;
        Button button;
    }
}
