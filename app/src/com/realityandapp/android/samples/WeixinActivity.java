package com.realityandapp.android.samples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by dd on 14-9-2.
 */
public class WeixinActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.weixin);
    }
}