package com.realityandapp.android.samples;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.realityandapp.android.samples.utils.ShortcutsUtils;

/**
 * Created by dd on 14-7-20.
 */
public class SimpleActivity extends Activity {
    private Button btn_hide_wx;
    private AlertDialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple);
        btn_hide_wx = (Button) findViewById(R.id.btn_hide_wx);
        btn_hide_wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ShortcutsUtils.hasShortcut(SimpleActivity.this, "com.tencent.mm.ui.LauncherUI")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SimpleActivity.this);
                    dialog = builder.setMessage("发现桌面有微信快捷方式，是否隐藏")
                            .setCancelable(true)
                            .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    destroy_dialog();
                                }
                            })
                            .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ShortcutsUtils.deleteShortCut(SimpleActivity.this, "com.tencent.mm.ui.LauncherUI");
                                    destroy_dialog();
                                }
                            }).create();
                }
                ShortcutsUtils.addShortcutToDesktop(SimpleActivity.this, WeixinActivity.class, getResources().getString(R.string.weixin), R.drawable.ic_weixin);
                Toast.makeText(SimpleActivity.this, "创建成功",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void destroy_dialog() {
        dialog.hide();
        dialog.dismiss();
    }
}