package com.realityandapp.android.samples;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Window;
//import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Administrator on 2014-9-3.
 */
public class WelcomeActivity extends Activity {
    // 点击次数计数器
    private  int count =0;
    private  int count2 =10;
    MotionEvent event;
    Handler handler=new Handler();
    Handler handler2=new Handler();
    //TextView m_editText = (TextView) findViewById(R.id.textView3);
    Runnable runnable=new Runnable(){
        @Override
        public void run() {
            //要做的事情
            count = 0;
            //new AlertDialog.Builder().setTitle("解锁程序").setMessage("10秒内未能解锁，请重新点击").setPositiveButton("确定", null).show();
        }
    };
    Runnable runnable2=new Runnable(){
        @Override
        public void run() {
            //要做的事情
            //m_editText.setText("还剩" + count2--);
            //new AlertDialog.Builder().setTitle("解锁程序").setMessage("10秒内未能解锁，请重新点击").setPositiveButton("确定", null).show();
        }
    };
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome);
        handler.postDelayed(runnable, 10000);//每十秒执行一次runnable.
        //handler2.postDelayed(runnable2, 1000);//每一秒执行一次runnable.
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
                    // 关闭计时器
                    handler.removeCallbacks(runnable);
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
