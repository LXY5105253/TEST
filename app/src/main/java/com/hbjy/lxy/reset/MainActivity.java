package com.hbjy.lxy.reset;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hbjy.lxy.library.app.dialog.NiftyDialogBuilder;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.main_bt1)
    Button mainBt1;
    @InjectView(R.id.main_bt2)
    Button mainBt2;
    @InjectView(R.id.main_bt3)
    Button mainBt3;
    String[] items = {"a","b","c","d"};
    boolean isCheck[] = {};

    private static final String TAG = MainActivity.class.getSimpleName();
    private NiftyDialogBuilder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        builder = NiftyDialogBuilder.getInstance(this);

    }

    @OnClick({R.id.main_bt1, R.id.main_bt2, R.id.main_bt3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_bt1:
                builder.setTitleText("普通")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("这是测试")
                        .setButtonLeftClick(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i(TAG, "onClick: 取消");
                                builder.dismiss();
                            }
                        })
                        .setButtonRightClick(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i(TAG, "onClick: 确定");
                                builder.dismiss();
                            }
                        })
                        .show();
                break;
            case R.id.main_bt2:
                builder.setTitleText("单选")
                        .setSingleChoiceItem(items, 3, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i(TAG, "onClick: " + items[which]);
                            }
                        })
                        .show();
                break;
            case R.id.main_bt3:
                builder.setTitleText("多选");
                builder.setMultChoiceItems(items, isCheck, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Log.i(TAG, "onClick: " + items[which]);
                    }
                }).show();
                break;
        }
    }
}
