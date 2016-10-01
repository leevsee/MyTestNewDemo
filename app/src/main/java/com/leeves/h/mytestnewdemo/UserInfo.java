package com.leeves.h.mytestnewdemo;

/**
 * Function：
 * Created by h on 2016/9/28.
 *
 * @author
 */
public class UserInfo {

    private String mUserName;
    private int mAge;

    public UserInfo(String userName, int age) {
        mUserName = userName;
        mAge = age;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}
