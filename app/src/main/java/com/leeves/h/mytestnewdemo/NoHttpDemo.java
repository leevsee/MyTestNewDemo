package com.leeves.h.mytestnewdemo;

import android.app.Activity;
import android.os.Bundle;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

/**
 * Function：
 * Created by h on 2016/9/27.
 *
 * @author Leeves
 */
@EActivity(R.layout.activity_nohttp_demo)
public class NoHttpDemo extends Activity {

    @Bean
    AAEbeanTest1 mAAEbeanTest;

    @Bean
    void setOneBean(AAEbeanTest1 mAAEbeanTest1){
        mAAEbeanTest1.getAge();
    }


    void setMultipleBeans(@Bean AAEbeanTest1 mAAEbeanTest1,@Bean AAEbeanTest2 mAAEbeanTest2){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAAEbeanTest.getName();
    }

}
