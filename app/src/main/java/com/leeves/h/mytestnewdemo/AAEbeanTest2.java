package com.leeves.h.mytestnewdemo;

import org.androidannotations.annotations.EBean;

/**
 * Function：
 * Created by h on 2016/9/28.
 *
 * @author Leeves
 */
@EBean
public class AAEbeanTest2 {

    private String mSex;
    private int mIDCard;

//    public AAEbeanTest2(String sex, int IDCard) {
//        mSex = sex;
//        mIDCard = IDCard;
//    }

    public String getSex() {
        return mSex;
    }

    public void setSex(String sex) {
        mSex = sex;
    }

    public int getIDCard() {
        return mIDCard;
    }

    public void setIDCard(int IDCard) {
        mIDCard = IDCard;
    }
}
