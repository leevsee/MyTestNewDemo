package com.leeves.h.mytestnewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Leeves on 2016/10/3.
 */

public class DownBarActivity extends AppCompatActivity {

    DownBarView mDownBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_bar);
        mDownBarView = (DownBarView) findViewById(R.id.downbar);
        
        downLoad();
    }

    private void downLoad() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(200);
                        Message message = handler.obtainMessage();
                        message.arg1 = i + 1;
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mDownBarView.setProgress(msg.arg1);
            if (msg.arg1 == 100) {
                mDownBarView.finishLoad();
            }
        }
    };

}
