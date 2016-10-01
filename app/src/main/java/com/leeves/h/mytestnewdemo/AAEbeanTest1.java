package com.leeves.h.mytestnewdemo;

import android.content.Context;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Function：
 * Created by h on 2016/9/28.
 *
 * @author Leeves
 */
@EBean
public class AAEbeanTest1 {

    @RootContext
    void setContext(Context context){

    }

    @RootContext
    NoHttpDemo mNoHttpDemo;

    private String mName;
    private int mAge;

//    public AAEbeanTest1(String name, int age) {
//        mName = name;
//        mAge = age;
//    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}
