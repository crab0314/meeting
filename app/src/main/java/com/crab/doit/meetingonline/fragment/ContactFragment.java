package com.crab.doit.meetingonline.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.crab.doit.meetingonline.R;
import com.crab.doit.meetingonline.adapter.ContactAdapter;
import com.crab.doit.meetingonline.bean.ContactInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pangjiaqi on 2016/11/30.
 */

public class ContactFragment extends Fragment {

    private ListView listView;
    private ContactAdapter contactAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        contactAdapter = new ContactAdapter(getActivity());
        listView.setAdapter(contactAdapter);
        updateData();
        return view;
    }

    private void updateData() {
        List<ContactInfo> temp = new ArrayList<>();
        ContactInfo contactInfo;
        contactInfo = new ContactInfo(0, 100000, "小鱼");
        temp.add(contactInfo);
        contactInfo = new ContactInfo(1, 100000, "小虾");
        temp.add(contactInfo);
        contactInfo = new ContactInfo(0, 100000, "小果粒");
        temp.add(contactInfo);
        contactInfo = new ContactInfo(1, 100000, "小星星");
        temp.add(contactInfo);
        contactInfo = new ContactInfo(0, 100000, "小鱼");
        temp.add(contactInfo);
        contactInfo = new ContactInfo(1, 100000, "小虾");
        temp.add(contactInfo);
        contactInfo = new ContactInfo(0, 100000, "小果粒");
        temp.add(contactInfo);
        contactInfo = new ContactInfo(1, 100000, "小星星");
        temp.add(contactInfo);
        contactAdapter.setData(temp);
        contactAdapter.notifyDataSetChanged();

    }
}
