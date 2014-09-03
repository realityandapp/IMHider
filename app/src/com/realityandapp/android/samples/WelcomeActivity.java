package com.realityandapp.android.samples;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;

/**
 * Created by Administrator on 2014-9-3.
 */
public class WelcomeActivity extends Activity {
    // 点击次数计数器
    private  int count =0;
    MotionEvent event;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    // 点击方法
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            //触摸屏幕时刻
            case MotionEvent.ACTION_DOWN:
                count++;

                // 点击次数check
                if (count >= 10) {
                    // 真微信打开
                    setContentView(R.layout.weixin);
                }
                //new AlertDialog.Builder(this).setTitle("点击屏幕次数").setMessage("简单消息框" + count).setPositiveButton("确定", null) .show();
                //showXY(event.getX(), event.getY());
                break;
            //触摸并移动时刻
//            case MotionEvent.ACTION_MOVE:
//                break;
            //终止触摸时刻
//            case MotionEvent.ACTION_UP:
//                showXY(event.getX(), event.getY());
//                break;
        }

        return super.onTouchEvent(event);
    }
}
