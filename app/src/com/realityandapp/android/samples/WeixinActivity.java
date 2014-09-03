package com.realityandapp.android.samples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dd on 14-9-2.
 */
public class WeixinActivity extends Activity {
    private int count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.weixin);

        task = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        };
        timer.schedule(task, 5000);
    }


    @Override
    public void onBackPressed() {
        count++;
        if(count >= 10){
            Intent i = new Intent();
            i.setClassName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            startActivity(i);
            finish();
        }
    }



    private final Timer timer = new Timer();
    private TimerTask task = null;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                count = 0;
            }
        }
    };

}