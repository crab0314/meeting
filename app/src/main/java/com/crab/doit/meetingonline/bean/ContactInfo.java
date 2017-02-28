package com.crab.doit.meetingonline.bean;

/**
 * Created by pangjiaqi on 2017/2/27.
 */

public class ContactInfo {
    public long uid;
    public String name;
    public int userState;

    public ContactInfo(int userState, long uid, String name) {
        this.userState = userState;
        this.uid = uid;
        this.name = name;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }
}
