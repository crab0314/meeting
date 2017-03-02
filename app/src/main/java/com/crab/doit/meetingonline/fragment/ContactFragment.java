package com.crab.doit.meetingonline.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.crab.doit.meetingonline.R;
import com.crab.doit.meetingonline.activity.AddPartyActivity;
import com.crab.doit.meetingonline.activity.HomeActivity;
import com.crab.doit.meetingonline.activity.LoginActivity;
import com.crab.doit.meetingonline.activity.SearchFriendActivity;
import com.crab.doit.meetingonline.adapter.ContactAdapter;
import com.crab.doit.meetingonline.bean.ContactInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pangjiaqi on 2016/11/30.
 */

public class ContactFragment extends Fragment {

    private ListView listView;
    private Button button;
    private ContactAdapter contactAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        button = (Button) view.findViewById(R.id.more_option);
        setButtonListener();
        contactAdapter = new ContactAdapter(getActivity());
        listView.setAdapter(contactAdapter);
        updateData();
        return view;
    }

    private void setButtonListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopMenu(button);
            }
        });
    }

    private void showPopMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
        popupMenu.getMenuInflater().inflate(R.menu.more_option, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                jumpToActivity(menuItem.getOrder());
                return false;
            }
        });
        popupMenu.show();
    }

    private void jumpToActivity(int i) {
        switch (i) {
            case 0:
                startActivity(new Intent(getActivity(), AddPartyActivity.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(), SearchFriendActivity.class));
                break;
            default:
                break;
        }
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
